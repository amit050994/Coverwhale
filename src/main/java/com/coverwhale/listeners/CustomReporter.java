package com.coverwhale.listeners;

import static com.coverwhale.utils.common.Constants.CURRENT_DAY_EXECUTION_REPORT;
import static com.coverwhale.utils.common.Constants.DRIVER;
import static com.coverwhale.utils.common.Constants.EXECUTION_REPORTS_PATH;
import static com.coverwhale.utils.common.Constants.PDF_DOWNLOAD_PATH;
import static com.coverwhale.utils.common.Constants.LOG_DESIGN;
import static com.coverwhale.utils.common.Constants.PNG_EXTENSION;
import static com.coverwhale.utils.common.Constants.TEST_CASE_SCREENSHOTS_PATH;
import static com.coverwhale.utils.common.Constants.TEST_RESULT_DIRECTORY_PATH;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.coverwhale.reporter.extent.ExtentReporter;
import com.coverwhale.utils.common.CommonUtils;
import com.coverwhale.utils.common.Config;
import com.coverwhale.utils.common.DateUtils;
import com.coverwhale.utils.selenium.ScreenShotGenerator;

/** It provides complete reporting of the suite execution.
 * 
 * @author Jaikant
 *
 */
public class CustomReporter implements IReporter, ITestListener, IExecutionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomReporter.class);
	public static Map<String, ExtentReporter> EXTENT_REPORTERS = new HashMap<>();
	public static Map<String, String> CLASS_NAMES = new HashMap<>();
    
	@Override
	public synchronized void onStart(ITestContext testContext) {
		String className = testContext.getCurrentXmlTest().getClasses().get(0).getName();
		ExtentReporter extentReporter = new ExtentReporter();
		extentReporter.onStart(testContext);
		String klass = className.split("\\.")[className.split("\\.").length - 1];
		
		EXTENT_REPORTERS.put(klass, extentReporter);
		CLASS_NAMES.put(className, klass); // e.g {com.demo.core.AdminTest : AdminTest}
		
		LOGGER.info("Class Map is : {}", CLASS_NAMES);
		LOGGER.info("Reporter map: {}", EXTENT_REPORTERS);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		String klass = CLASS_NAMES.get(testContext.getCurrentXmlTest().getClasses().get(0).getName());
		EXTENT_REPORTERS.get(klass).onFinish(testContext);
		
		WebDriver driver = ((WebDriver)testContext.getAttribute("driver"));
//		if (Objects.nonNull(driver))
//			driver.quit();
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		String klass = CLASS_NAMES.get(testResult.getTestClass().getName());
		List<String> reporterMessages = Reporter.getOutput(testResult);
		reporterMessages.forEach(message -> {
			EXTENT_REPORTERS.get(klass).info(message);
		});
		EXTENT_REPORTERS.get(klass).fail(testResult.getThrowable());
		EXTENT_REPORTERS.get(klass).onTestFail(testResult);
		
		LOGGER.error(LOG_DESIGN + "Test Case Failed: {}", testResult.getMethod().getMethodName());
		LOGGER.error(LOG_DESIGN + "Failure Reason : ", testResult.getThrowable());
		
		onTestCompletion(testResult, "FAILED");

	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		String klass = CLASS_NAMES.get(testResult.getTestClass().getName());
		List<String> reporterMessages = Reporter.getOutput(testResult);
		reporterMessages.forEach(message -> {
			EXTENT_REPORTERS.get(klass).info(message);
		});
		EXTENT_REPORTERS.get(klass).onTestSkip(testResult);
		LOGGER.info(LOG_DESIGN + "Test Case Skipped: {}", testResult.getMethod().getMethodName());
		
		onTestCompletion(testResult, "SKIPPED");
	}

	@Override
	public void onTestStart(ITestResult testResult) {
		String klass = CLASS_NAMES.get(testResult.getTestClass().getName());
		testResult.getTestContext().setAttribute("reporter", EXTENT_REPORTERS.get(klass));
		EXTENT_REPORTERS.get(klass).onTestStart(testResult);
		LOGGER.info(LOG_DESIGN + "Execution Started For Test: {}", testResult.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		String klass = CLASS_NAMES.get(testResult.getTestClass().getName());
		List<String> reporterMessages = Reporter.getOutput(testResult);
		reporterMessages.forEach(message -> {
			EXTENT_REPORTERS.get(klass).info(message);
		});
		EXTENT_REPORTERS.get(klass).onTestPass(testResult);

		LOGGER.info(LOG_DESIGN + "Test Case Passed : {}", testResult.getMethod().getMethodName());
		
		onTestCompletion(testResult, "PASSED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {

	}

	@Override
	public void onExecutionStart() {
		LOGGER.info("                            ##########################                                 ");
		LOGGER.info("############################ SUITE EXECUTION STARTED ################################");
		LOGGER.info("                            ##########################                                 ");

		CommonUtils.createDirectory(TEST_RESULT_DIRECTORY_PATH);
		CommonUtils.createDirectory(TEST_CASE_SCREENSHOTS_PATH);
		CommonUtils.createDirectory(EXECUTION_REPORTS_PATH);
		CommonUtils.createDirectory(CURRENT_DAY_EXECUTION_REPORT);
		
		ExtentReporter.onExceutionStart();

		LOGGER.info(LOG_DESIGN + "Test Result Directories created.");

	}

	@Override
	public void onExecutionFinish() {
		if (Config.getProperty("cleanDownloadedPDFs").equalsIgnoreCase("yes"))
		CommonUtils.cleanDirectory(PDF_DOWNLOAD_PATH);
		
		LOGGER.info("                            ##########################                                 ");
		LOGGER.info("############################ SUITE EXECUTION FINISHED ################################");
		LOGGER.info("                            ##########################                                 ");
	}

	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> suites, String arg2) {
		
	}

	
	/** It will be used to perform the after test steps if any.
	 * 
	 * @param testResult
	 * @param testStatus
	 */
	private void onTestCompletion(ITestResult testResult, String testStatus) {
		String klass = CLASS_NAMES.get(testResult.getTestClass().getName());
		EXTENT_REPORTERS.get(klass).setExecutionTime(testResult);

		String testCaseName = testResult.getMethod().getMethodName();
		ITestContext context = testResult.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute(DRIVER);
		String screenShotPath = TEST_CASE_SCREENSHOTS_PATH + File.separatorChar + testCaseName + DateUtils.getCurrentDateWithTime().replaceAll(":", "") + PNG_EXTENSION;
		ScreenShotGenerator.captureScreenshot(driver, screenShotPath);
		EXTENT_REPORTERS.get(klass).attachScreenshot(screenShotPath);
		/*if (testStatus.equalsIgnoreCase("FAILED")) {
			ExtentReporter.attachScreenshot(screenShotPath);
		}*/
		LOGGER.info("###### TEST CASE [{}] : {} ########", testCaseName, testStatus);
		LOGGER.info("");
	}
	
}

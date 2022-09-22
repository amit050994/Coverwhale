package com.coverwhale.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.coverwhale.utils.common.Config;
import com.coverwhale.utils.selenium.DriverPool;
import com.coverwhale.utils.selenium.WebUtils;

/** This class manages which driver should be created according to class parameters defined in testng xml..
 * 
 * @author Jaikant
 *
 */
public class BaseConfiguration {

	public WebDriver driver;
	private ITestContext context;
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseConfiguration.class);
	private static final String APPLICATION_URL = Config.getProperty("appURL");

	@SuppressWarnings("unchecked")
	@Parameters({ "browser", "nodeURL" })
	@BeforeClass
	public void setup(@Optional("CHROME")String browser, @Optional("")String nodeURL, ITestContext ctx) {
		try {
			
				driver = DriverPool.getDriver(browser, nodeURL);
				WebUtils webUtils = new WebUtils(driver);
				driver.manage().window().maximize();
				webUtils.navigateToURL(APPLICATION_URL);
		} catch (Exception e) {
			LOGGER.error("Error occured {} ", e.getMessage());
			throw new WebDriverException(e.getMessage());
		}

		this.context = DriverPool.setupContext(driver, ctx, browser, nodeURL);
	}
	
}

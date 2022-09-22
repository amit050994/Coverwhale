package com.coverwhale.crawler.invoicedoc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coverwhale.actions.web.LoginActions;
import com.coverwhale.actions.web.SubmissionStatusButtonsPageActions;
import com.coverwhale.core.BaseConfiguration;
import com.coverwhale.reporter.extent.ExcelReporter;
import com.coverwhale.utils.selenium.WebUtils;

// Some values are hard coded, but can be improved overtime
public class InvoiceCrawler extends BaseConfiguration {

	private LoginActions loginActions;
	private SubmissionStatusButtonsPageActions submissionStatusButtons;
	private WebUtils webUtils;

	private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceCrawler.class);
	private static final String INVOICE_CRAWLER_DATA_SHEET_LOCATION  = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config" + File.separator + "InvoiceCrawlerData.xlsx";


	@BeforeClass
	public void setUp() {
		loginActions = new LoginActions(driver);
		submissionStatusButtons = new SubmissionStatusButtonsPageActions(driver);
		webUtils = new WebUtils(driver);
		loginActions.login("anastasiia@mailinator.com", "12Desbrosses");
	}

	@Test(testName = "Read Invoice documents", description = "Read all invoice documents with different submissionIds")

	public void read_invoice_documents() {
		Map<String, Map<String, String>> masterResult = new LinkedHashMap<>();
		Map<String, Map<String, String>> allLabels = ExcelReporter.getSheetData(INVOICE_CRAWLER_DATA_SHEET_LOCATION, "Summary");
		List<String> submissionData =  new ArrayList<>(allLabels.keySet());
		Map.Entry<String, Map<String, String>> entry = allLabels.entrySet().iterator().next();
		String[] allHeaders = entry.getValue().keySet().toArray(String[]::new);
		
		try {
			for (String submissionCount : submissionData) {
				String transactionId = allLabels.get(submissionCount).get("TransactionId");
				String submissionId = allLabels.get(submissionCount).get("SubmissionId");
				webUtils.navigateToURL("https://uat.coverwhale.dev/transportation/" + submissionId + "/" + transactionId);
				if (submissionStatusButtons.doesSubmissionExists()) {
					String invoiceDocURL = submissionStatusButtons.getDocumentURL();
					String transactioId = invoiceDocURL.split("transportation/")[1].split("/")[1];
					submissionStatusButtons.clickOnFilesTab();
					boolean isDocumentPresent = submissionStatusButtons.downloadLatestCWISInvoiceDocument();
					if (isDocumentPresent) {
						InvoiceDocReaderForCrawler.INVOICE_DOC_CRAWLER_MAP.put(submissionId, submissionId);
						Map<String, String> testResult = extractInvoiceDoc(submissionId,transactionId, allHeaders);
						testResult.put("SubmissionId", submissionId);
						testResult.put("TransactionId", transactioId);
						testResult.put("Id", submissionCount);
						masterResult.put(submissionCount, testResult);
					} else {
						masterResult.put(submissionCount, null);
					}
				} else {
					masterResult.put(submissionCount, null);
				}
				
			}

			ExcelReporter.fillResults(masterResult);
		} catch (Exception e) {
			if (Objects.nonNull(masterResult))
				ExcelReporter.fillResults(masterResult);
			LOGGER.error("Error occured {}", e.getMessage());
		} 
	}
	
	
	public Map<String, String> extractInvoiceDoc(String submissionId, String transactionId, String [] allHeaders) {
		Map<String, String> testResult  = new HashMap<>();
		try {

		Map<String, String> invoiceDataFromPdfAL = InvoiceDocReaderForCrawler.getInvoiceData(submissionId, "AL", allHeaders);
		Map<String, String> invoiceDataFromPdfAPD = InvoiceDocReaderForCrawler.getInvoiceData(submissionId, "APD", allHeaders);
		Map<String, String> invoiceDataFromPdfMTC = InvoiceDocReaderForCrawler.getInvoiceData(submissionId, "MTC", allHeaders);
		Map<String, String> invoiceDataFromPdfTGL = InvoiceDocReaderForCrawler.getInvoiceData(submissionId, "TGL", allHeaders);
		Map<String, String> invoiceDataFromPdfNTL = InvoiceDocReaderForCrawler.getInvoiceData(submissionId, "NTL", allHeaders);
		
		testResult = Stream.of(invoiceDataFromPdfAL, invoiceDataFromPdfAPD, invoiceDataFromPdfMTC, invoiceDataFromPdfTGL, invoiceDataFromPdfNTL).flatMap(m -> m.entrySet().stream()) .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		LOGGER.info("Test Result for submission id {} with transaction id {} is {}", submissionId, transactionId, testResult);
		
		} catch (Exception e) {
			LOGGER.error("Error extracting values {}", e.getMessage());
		}
		
		return testResult;
	}
}
package com.coverwhale.validators.web;

import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.InvoicePDFReader;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class InvoiceDataValidatorIL {

	public void validatePdfDataForTC_12_01() {
		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_12_01";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get(testCaseId);

			// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData(testCaseId, "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_12_02() {
		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_12_02";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get(testCaseId);

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData(testCaseId, "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_12_03() {
		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_12_03";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get(testCaseId);

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData(testCaseId, "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_12_04() {
		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_12_04";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get(testCaseId);

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData(testCaseId, "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		assertion.assertAll();
	}

}

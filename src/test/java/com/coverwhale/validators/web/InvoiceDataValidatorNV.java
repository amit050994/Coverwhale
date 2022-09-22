package com.coverwhale.validators.web;

import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.InvoicePDFReader;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class InvoiceDataValidatorNV {


	public void validatePdfDataForTC_10_01() {
		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_10_01");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_10_01", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_10_01", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_10_02() {
		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_10_02");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_10_02", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_10_02", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_10_03() {
		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_10_03");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_10_03", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_10_03", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_10_04() {
		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_10_04");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_10_04", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_10_04", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		assertion.assertAll();
	}


}

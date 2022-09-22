package com.coverwhale.validators.web;

import java.util.Map;

import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.InvoicePDFReader;

public class InvoiceDataValidatorOR {

	public void validatePdfDataForTC_09_01() {

		SoftAssert assertion = new SoftAssert();
		
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_09_01");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_09_01", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_APD"), "Fire Marshal Tax APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_09_01", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_MTC"), "Fire Marshal Tax MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_09_01", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_TGL"), "Fire Marshal Tax TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_09_01", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_NTL"), "Fire Marshal Tax NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_09_02() {

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_09_02");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_09_02", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_APD"), "Fire Marshal Tax APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_09_02", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_MTC"), "Fire Marshal Tax MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_09_02", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_TGL"), "Fire Marshal Tax TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_09_02", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_NTL"), "Fire Marshal Tax NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_09_03() {

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_09_03");


		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_09_03", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Fire Marshal Tax").split("\\)")[1].trim(), invoiceResults.get("Fire Marshal Tax_APD"), "Fire Marshal Tax APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_09_03", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"),  invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Fire Marshal Tax").split("\\)")[1].trim(), invoiceResults.get("Fire Marshal Tax_MTC"), "Fire Marshal Tax MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_09_03", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_TGL"), "Fire Marshal Tax TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_09_03", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Fire Marshal Tax").split("\\)")[1].trim(), invoiceResults.get("Fire Marshal Tax_NTL"), "Fire Marshal Tax NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_09_04() {

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_09_04");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_09_04", "APD", alValuesToScrapAPD);

		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Fire Marshal Tax").split("\\)")[1].trim(), invoiceResults.get("Fire Marshal Tax_APD"), "Fire Marshal Tax APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_09_04", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Premium - MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Policy Cost_MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_MTC"), "Fire Marshal Tax MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax",  "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_09_04", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"),invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_TGL"), "Fire Marshal Tax TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_09_04", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_NTL"), "Fire Marshal Tax NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_09_05() {


		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_09_05");


		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_09_05", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_APD"), "Fire Marshal Tax APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_09_05", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_MTC"), "Fire Marshal Tax MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_09_05", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_TGL"), "Fire Marshal Tax TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_09_05", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_NTL"), "Fire Marshal Tax NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();

	}
	public void validatePdfDataForTC_09_06() {

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_09_06");


		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_09_06", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Fire Marshal Tax").split("\\)")[1].trim(), invoiceResults.get("Fire Marshal Tax_APD"), "Fire Marshal Tax APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_09_06", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Fire Marshal Tax").split("\\)")[1].trim(), invoiceResults.get("Fire Marshal Tax_MTC"), "Fire Marshal Tax MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_09_06", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Fire Marshal Tax").split("\\)")[1].trim(), invoiceResults.get("Fire Marshal Tax_TGL"), "Fire Marshal Tax TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Commission - TGL").split("\\$")[1], invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_09_06", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Fire Marshal Tax").split("\\)")[1].trim(), invoiceResults.get("Fire Marshal Tax_NTL"), "Fire Marshal Tax NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();

	}
	public void validatePdfDataForTC_09_07() {

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_09_07");


		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_09_07", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_APD"), "Fire Marshal Tax APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_09_07", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_MTC"), "Fire Marshal Tax MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_09_07", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_TGL"), "Fire Marshal Tax TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Fire Marshal Tax", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_09_07", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Fire Marshal Tax").split("\\$")[1], invoiceResults.get("Fire Marshal Tax_NTL"), "Fire Marshal Tax NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

}

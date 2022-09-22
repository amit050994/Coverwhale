package com.coverwhale.validators.web;

import java.util.Map;

import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.InvoicePDFReader;

public class InvoiceDataValidatorNJ {

	public void validatePdfDataForTC_08_01() {
		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL","Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_01");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_01", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		// TODO Make them uniform and try to avoid appending $ sign here
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_01", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_01", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_01", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_01", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_08_02() {
		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_02");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_02", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_02", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_02", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_02", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_02", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");
		assertion.assertAll();
	}

	public void validatePdfDataForTC_08_03() {
		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_03");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_03", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_03", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_03", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"),  invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_03", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_03", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_08_04() {
		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL", "Uninsured/Underinsured Motorists/Property Damage",
				"Personal Injury Protection", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_04");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_04", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_04", "APD", alValuesToScrapAPD);

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

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_04", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Premium - MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Policy Cost_MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",  "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_04", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"),invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_04", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_08_05() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_05");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_05", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), "$0.00", "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_05", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
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

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_05", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_05", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_05", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Stamping Fees").split("\\)")[1].trim(), invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();

	}
	public void validatePdfDataForTC_08_06() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_06");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_06", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Commission - AL").split("\\$")[1], invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_06", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"),  invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_06", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_06", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Commission - TGL").split("\\$")[1], invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_06", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}
	
	public void validatePdfDataForTC_08_07() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_07");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_07", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_07", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"),  invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_07", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_07", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_07", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();

	}
	public void validatePdfDataForTC_08_08() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_08");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_08", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_08", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"),  invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_08", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_08", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_08", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\)")[1].trim(), invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();

	}

	public void validatePdfDataForTC_08_09() {
		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL","Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();

		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_09");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_09", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		// TODO Make them uniform and try to avoid appending $ sign here
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_09", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_09", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_09", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_09", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}

	public void validatePdfDataForTC_08_10() {
		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL","Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();

		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_08_10");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_08_10", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_AL"), "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), invoiceResults.get("Total Premium - AL"), "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), invoiceResults.get("Uninsured/Underinsured Motorists/Property Damage"), "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), invoiceResults.get("Personal Injury Protection"), "Personal Injury Protection");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), invoiceResults.get("Policy Fees_AL"), "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_AL"), "Underwriting Fees AL");
		// TODO Make them uniform and try to avoid appending $ sign here
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_AL"), "Surplus Lines Taxes AL");
		assertion.assertEquals("$" + invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_AL"), "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), invoiceResults.get("Commission - AL"), "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._AL"), "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_08_10", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_APD"), "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), invoiceResults.get("Total Premium - APD"), "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), invoiceResults.get("Policy Fees_APD"), "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_APD"), "Underwriting Fees APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_APD"), "Surplus Lines Taxes APD");
		assertion.assertEquals("$" + invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_APD"), "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), invoiceResults.get("Commission - APD"), "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._APD"), "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_08_10", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_MTC"), "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), invoiceResults.get("Total Premium - MTC"), "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), invoiceResults.get("Policy Fees_MTC"), "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_MTC"), "Underwriting Fees MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_MTC"), "Surplus Lines Taxes MTC");
		assertion.assertEquals("$" + invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_MTC"), "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), invoiceResults.get("Commission - MTC"), "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._MTC"), "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_08_10", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_TGL"), "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), invoiceResults.get("Total Premium - TGL"), "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), invoiceResults.get("Policy Fees_TGL"), "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_TGL"), "Underwriting Fees TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_TGL"), "Surplus Lines Taxes TGL");
		assertion.assertEquals("$" + invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_TGL"), "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), invoiceResults.get("Commission - TGL"), "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._TGL"), "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_08_10", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), invoiceResults.get("Total Policy Cost_NTL"), "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), invoiceResults.get("Total Premium - NTL"), "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), invoiceResults.get("Policy Fees_NTL"), "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), invoiceResults.get("Underwriting Fees_NTL"), "Underwriting Fees NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\$")[1], invoiceResults.get("Surplus Lines Taxes_NTL"), "Surplus Lines Taxes NTL");
		assertion.assertEquals("$" + invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], invoiceResults.get("Stamping Fees_NTL"), "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), invoiceResults.get("Commission - NTL"), "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), invoiceResults.get("Net Due to: Cover Whale Insurance Solutions Inc._NTL"), "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		assertion.assertAll();
	}
}

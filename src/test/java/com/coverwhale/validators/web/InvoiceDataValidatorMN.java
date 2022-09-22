package com.coverwhale.validators.web;


import java.util.Map;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.InvoicePDFReader;

public class InvoiceDataValidatorMN {

	public void validatePdfDataForTC_13_01() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_13_01";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_13_01");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData(testCaseId, "AL", invoiceValuesToScrapAL);
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

		assertion.assertAll();

	}


	public void validatePdfDataForTC_13_02() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_13_02";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_13_02");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData(testCaseId, "AL", invoiceValuesToScrapAL);
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

		assertion.assertAll();

	}


	public void validatePdfDataForTC_13_03() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_13_03";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_13_03");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData(testCaseId, "AL", invoiceValuesToScrapAL);
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

		assertion.assertAll();

	}


	public void validatePdfDataForTC_13_04() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_13_04";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_13_04");

		// AL

		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData(testCaseId, "AL", invoiceValuesToScrapAL);
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

		assertion.assertAll();

	}


	public void validatePdfDataForTC_13_05() {

		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL",
				"Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees",
				"Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees",
				"Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_13_05";
		Map<String, String> invoiceResults = (Map<String, String>) DataRecorder.INVOICE_RESULT_CACHE.get("TC_13_05");

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData(testCaseId, "AL", invoiceValuesToScrapAL);
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

		assertion.assertAll();

	}


}
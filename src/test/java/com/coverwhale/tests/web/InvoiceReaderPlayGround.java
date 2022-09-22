package com.coverwhale.tests.web;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.coverwhale.core.InvoicePDFReader;
import com.coverwhale.listeners.CustomReporter;

@Listeners(CustomReporter.class)
public class InvoiceReaderPlayGround {


	@Test(testName = "DUMMY_TEST", description = "User's mailing address state is not in the list of licensed states")
	public void DUMMY_TEST() {
		
		String invoiceValuesToScrapAL[] = {"Total Policy Cost", "Total Premium - AL", "Uninsured/Underinsured Motorists/Property Damage", "Personal Injury Protection", "Policy Fees", "Broker Fees", "Underwriting Fees", "TX Crime Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - AL", "Net Due to: Cover Whale Insurance Solutions Inc."};

		SoftAssert assertion = new SoftAssert();

		// AL
		Reporter.log("Comparing AL values");
		Map<String, String> invoiceDataFromPdfAL = InvoicePDFReader.getInvoiceData("TC_04_01", "AL", invoiceValuesToScrapAL);
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Policy Cost"), "$0.00", "Total Policy Cost AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Total Premium - AL"), "$0.00", "Total Premium - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Uninsured/Underinsured Motorists/Property Damage"), "$0.00", "Uninsured/Underinsured Motorists/Property Damage AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Personal Injury Protection"), "$0.00", "Personal Injury Protection AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Policy Fees"), "$0.00", "Policy Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Underwriting Fees"), "$0.00", "Underwriting Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("TX Crime Fees"), "$0.00", "TX Crime Fees");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Surplus Lines Taxes").split("\\$")[1], "0.00", "Surplus Lines Taxes AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Stamping Fees").split("\\$")[1], "0.00", "Stamping Fees AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Commission - AL").split("\\)")[1].trim(), "$0.00", "Commission - AL");
		assertion.assertEquals(invoiceDataFromPdfAL.get("Net Due to: Cover Whale Insurance Solutions Inc."), "$0.00", "Net Due to: Cover Whale Insurance Solutions Inc. AL");

		// APD
		Reporter.log("Comparing APD values");
		String alValuesToScrapAPD[] = {"Total Policy Cost", "Total Premium - APD", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - APD",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfAPD = InvoicePDFReader.getInvoiceData("TC_04_01", "APD", alValuesToScrapAPD);
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Policy Cost"), "$0.00", "Total Policy Cost APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Total Premium - APD"), "$0.00", "Total Premium - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Policy Fees"), "$0.00", "Policy Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Underwriting Fees"), "$0.00", "Underwriting Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Surplus Lines Taxes").split("\\$")[1], "0.00", "Surplus Lines Taxes APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Stamping Fees").split("\\$")[1], "0.00", "Stamping Fees APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Commission - APD").split("\\)")[1].trim(), "-$0.00", "Commission - APD");
		assertion.assertEquals(invoiceDataFromPdfAPD.get("Net Due to: Cover Whale Insurance Solutions Inc."), "$0.00", "Net Due to: Cover Whale Insurance Solutions Inc. APD");

		// MTC
		Reporter.log("Comparing MTC values");
		String alValuesToScrapMTC[] = {"Total Policy Cost", "Total Premium - MTC", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - MTC",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfMTC = InvoicePDFReader.getInvoiceData("TC_04_01", "MTC", alValuesToScrapMTC);
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Policy Cost"), "$0.00", "Total Policy Cost MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Total Premium - MTC"), "$0.00", "Total Premium - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Policy Fees"), "$0.00", "Policy Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Underwriting Fees"), "$0.00", "Underwriting Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Surplus Lines Taxes").split("\\$")[1], "0.00", "Surplus Lines Taxes MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Stamping Fees").split("\\$")[1], "0.00", "Stamping Fees MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Commission - MTC").split("\\)")[1].trim(), "-$0.00", "Commission - MTC");
		assertion.assertEquals(invoiceDataFromPdfMTC.get("Net Due to: Cover Whale Insurance Solutions Inc."), "$0.00", "Net Due to: Cover Whale Insurance Solutions Inc. MTC");

		// TGL
		Reporter.log("Comparing TGL values");
		String alValuesToScrapTGL[] = {"Total Policy Cost", "Total Premium - TGL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - TGL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfTGL = InvoicePDFReader.getInvoiceData("TC_04_01", "TGL", alValuesToScrapTGL);
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Policy Cost"), "$0.00", "Total Policy Cost TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Total Premium - TGL"), "$0.00", "Total Premium - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Policy Fees"), "$0.00", "Policy Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Underwriting Fees"), "$0.00", "Underwriting Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Surplus Lines Taxes").split("\\$")[1], "0.00", "Surplus Lines Taxes TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Stamping Fees").split("\\$")[1], "0.00", "Stamping Fees TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Commission - TGL").split("\\)")[1].trim(), "-$0.00", "Commission - TGL");
		assertion.assertEquals(invoiceDataFromPdfTGL.get("Net Due to: Cover Whale Insurance Solutions Inc."), "$0.00", "Net Due to: Cover Whale Insurance Solutions Inc. TGL");

		// NTL
		Reporter.log("Comparing NTL values");
		String alValuesToScrapNTL[] = {"Total Policy Cost", "Total Premium - NTL", "Policy Fees", "Broker Fees",
				"Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees", "Commission - NTL",
				"Net Due to: Cover Whale Insurance Solutions Inc."};

		Map<String, String> invoiceDataFromPdfNTL = InvoicePDFReader.getInvoiceData("TC_04_01", "NTL", alValuesToScrapNTL);
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Policy Cost"), "$0.00", "Total Policy Cost NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Total Premium - NTL"), "$0.00", "Total Premium - NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Policy Fees"), "$0.00", "Policy Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Underwriting Fees"), "$0.00", "Underwriting Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Surplus Lines Taxes").split("\\$")[1], "0.00", "Surplus Lines Taxes NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Stamping Fees").split("\\$")[1], "0.00", "Stamping Fees NTL");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Commission - NTL").split("\\)")[1].trim(), "-$0.00", "Commission - NTL;");
		assertion.assertEquals(invoiceDataFromPdfNTL.get("Net Due to: Cover Whale Insurance Solutions Inc."), "$0.00", "Net Due to: Cover Whale Insurance Solutions Inc. NTL");

		
	}

}

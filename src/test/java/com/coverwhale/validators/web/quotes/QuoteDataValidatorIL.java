package com.coverwhale.validators.web.quotes;

import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.QuotePdfReader;
import com.google.gson.Gson;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.LinkedHashMap;
import java.util.Map;

public class QuoteDataValidatorIL {


	public void validateQuoteDoc(String testCaseID) {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = testCaseID;
		Map<String, String> quoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);

		// CTI
		String CTILabelsToScrap[] = { "Automobile Liability", "Total Cost" };
		Reporter.log("Comparing commercial truck insurance table values");

		// commercial truck insurance data
		Map<String, String> CTIDataFromPDF = quoteReader.getCommercialTruckInsuranceData(quotePDFData, CTILabelsToScrap);
		System.out.println("CTI Data : " + CTIDataFromPDF);
		assertion.assertEquals(CTIDataFromPDF.get("Automobile Liability"), quoteResults.get("CTI_Automobile Liability"), "CTI Automobile Liability");
		assertion.assertEquals(CTIDataFromPDF.get("Total Cost"), quoteResults.get("CTI_Total Cost"), "CTI Total Cost");

		// APD
		String apdYearlyLabelsToScrap[] = { "Policy Fee", "Broker Fee","Surplus Lines Tax", "Stamping Fee", "Underwriting Fee" };
		String apdPremiumDetailLabelsToScrap[] = { "Towing, Storage and Labor", "Trailer Interchange", "Premium Subtotal" };

		Reporter.log("Comparing Automobile Physical Damage values");
		Map<String, String> APDDataFromPDF = quoteReader.getAPDData(quotePDFData, apdYearlyLabelsToScrap, apdPremiumDetailLabelsToScrap);
		System.out.println("APD Data : " + APDDataFromPDF);
		assertion.assertEquals(APDDataFromPDF.get("Yearly"), quoteResults.get("APD_Yearly"), "APD Yearly");
		assertion.assertEquals(APDDataFromPDF.get("Policy Fee"), quoteResults.get("APD_Policy Fee"), "APD Policy Fee");
		assertion.assertEquals(APDDataFromPDF.get("Broker Fee"), quoteResults.get("APD_Broker Fee"), "APD Broker Fee");
		assertion.assertEquals(APDDataFromPDF.get("Surplus Lines Tax"), quoteResults.get("APD_Surplus Lines Tax"), "APD Surplus Lines Tax");
		assertion.assertEquals(APDDataFromPDF.get("Stamping Fee"), quoteResults.get("APD_Stamping Fee"), "APD Stamping Fee");
		assertion.assertEquals(APDDataFromPDF.get("Underwriting Fee"), quoteResults.get("APD_Underwriting Fee"), "APD Underwriting Fee");

		assertion.assertEquals(APDDataFromPDF.get("Automobile Physical Damage"), quoteResults.get("APD_PD_Automobile Physical Damage"), "APD PD Automobile Physical Damage");  // PD : Premium detail table
		assertion.assertEquals(APDDataFromPDF.get("Towing, Storage and Labor"), quoteResults.get("APD_PD_Towing, Storage and Labor"), "APD PD Towing, Storage and Labor");
		assertion.assertEquals(APDDataFromPDF.get("Trailer Interchange"), quoteResults.get("APD_PD_Trailer Interchange"), "APD PD Trailer Interchange");
		assertion.assertEquals(APDDataFromPDF.get("Premium Subtotal"), quoteResults.get("APD_PD_Premium Subtotal"), "APD PD Premium Subtotal");

		assertion.assertAll();

	}

	public void validateQuoteDocAdditionalPremiumTaxes(String testCaseID) {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = testCaseID;
		Map<String, String> expectedQuoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);

		String valuesToRead[] = { "Auto Liability", "Automobile Physical Damage", "Towing, Storage and Labor",
				"Trailer Interchange", "Motor Truck Cargo", "Truckers General Liability", "Non-Trucking Liability",
				"Premium Subtotal", "Policy Fees", "Broker Fees", "Underwriting Fees", "Surplus Lines Taxes",
				"Stamping Fees" };

		// APT: Additional premium and taxes
		Reporter.log("Comparing [Additional Premium and Taxes] table values");
		Map<String, Map<String,String>> tableDataFromPDF = quoteReader.getAdditionalPremiumAndTaxesTableData(quotePDFData, valuesToRead);
		Gson gson = new Gson();
		//	System.out.println(gson.toJson(tableDataFromPDF));
		assertion.assertEquals(tableDataFromPDF.get("Auto Liability"), gson.fromJson(expectedQuoteResults.get("APT_Auto Liability"), LinkedHashMap.class), "APT Auto Liability");
		assertion.assertEquals(tableDataFromPDF.get("Automobile Physical Damage"), gson.fromJson(expectedQuoteResults.get("APT_Automobile Physical Damage"), LinkedHashMap.class), "APT Automobile Physical Damage");
		assertion.assertEquals(tableDataFromPDF.get("Towing, Storage and Labor"), gson.fromJson(expectedQuoteResults.get("APT_Towing, Storage and Labor"), LinkedHashMap.class), "APT Towing, Storage and Labor");
		assertion.assertEquals(tableDataFromPDF.get("Trailer Interchange"), gson.fromJson(expectedQuoteResults.get("APT_Trailer Interchange"), LinkedHashMap.class), "APT Trailer Interchange");
		assertion.assertEquals(tableDataFromPDF.get("Motor Truck Cargo"), gson.fromJson(expectedQuoteResults.get("APT_Motor Truck Cargo"), LinkedHashMap.class), "APT Motor Truck Cargo");
		assertion.assertEquals(tableDataFromPDF.get("Truckers General Liability"), gson.fromJson(expectedQuoteResults.get("APT_Truckers General Liability"), LinkedHashMap.class), "APT Truckers General Liability");
		assertion.assertEquals(tableDataFromPDF.get("Non-Trucking Liability"), gson.fromJson(expectedQuoteResults.get("APT_Non-Trucking Liability"), LinkedHashMap.class), "APT Non-Trucking Liability");
		assertion.assertEquals(tableDataFromPDF.get("Premium Subtotal"), gson.fromJson(expectedQuoteResults.get("APT_Premium Subtotal"), LinkedHashMap.class), "APT Premium Subtotal");
		assertion.assertEquals(tableDataFromPDF.get("Broker Fees"), gson.fromJson(expectedQuoteResults.get("APT_Broker Fees"), LinkedHashMap.class), "APT Broker Fees");
		assertion.assertEquals(tableDataFromPDF.get("Underwriting Fees"), gson.fromJson(expectedQuoteResults.get("APT_Underwriting Fees"), LinkedHashMap.class), "APT Underwriting Fees");
		assertion.assertEquals(tableDataFromPDF.get("Surplus Lines Taxes"), gson.fromJson(expectedQuoteResults.get("APT_Surplus Lines Taxes"), LinkedHashMap.class), "APT Surplus Lines Taxes");
		assertion.assertEquals(tableDataFromPDF.get("Stamping Fees"), gson.fromJson(expectedQuoteResults.get("APT_Stamping Fees"), LinkedHashMap.class), "APT Stamping Fees");

		assertion.assertAll();
	}

	public void validateQuoteDocReturnPremiumTaxes(String testCaseID) {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = testCaseID;
		Map<String, String> expectedQuoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);

		String valuesToRead[] = { "Auto Liability", "Automobile Physical Damage", "Towing, Storage and Labor",
				"Trailer Interchange", "Motor Truck Cargo", "Truckers General Liability", "Non-Trucking Liability",
				"Premium Subtotal", "Policy Fees", "Broker Fees", "Underwriting Fees", "Surplus Lines Taxes",
				"Stamping Fees" };

		// APT: Additional premium and taxes
		Reporter.log("Comparing [Return Premium and Taxes] table values");
		Map<String, Map<String,String>> tableDataFromPDF = quoteReader.getReturnPremiumAndTaxesTableData(quotePDFData, valuesToRead);
		Gson gson = new Gson();
		//	System.out.println(gson.toJson(tableDataFromPDF));
		assertion.assertEquals(tableDataFromPDF.get("Auto Liability"), gson.fromJson(expectedQuoteResults.get("APT_Auto Liability"), LinkedHashMap.class), "APT Auto Liability");
		assertion.assertEquals(tableDataFromPDF.get("Automobile Physical Damage"), gson.fromJson(expectedQuoteResults.get("APT_Automobile Physical Damage"), LinkedHashMap.class), "APT Automobile Physical Damage");
		assertion.assertEquals(tableDataFromPDF.get("Towing, Storage and Labor"), gson.fromJson(expectedQuoteResults.get("APT_Towing, Storage and Labor"), LinkedHashMap.class), "APT Towing, Storage and Labor");
		assertion.assertEquals(tableDataFromPDF.get("Trailer Interchange"), gson.fromJson(expectedQuoteResults.get("APT_Trailer Interchange"), LinkedHashMap.class), "APT Trailer Interchange");
		assertion.assertEquals(tableDataFromPDF.get("Motor Truck Cargo"), gson.fromJson(expectedQuoteResults.get("APT_Motor Truck Cargo"), LinkedHashMap.class), "APT Motor Truck Cargo");
		assertion.assertEquals(tableDataFromPDF.get("Truckers General Liability"), gson.fromJson(expectedQuoteResults.get("APT_Truckers General Liability"), LinkedHashMap.class), "APT Truckers General Liability");
		assertion.assertEquals(tableDataFromPDF.get("Non-Trucking Liability"), gson.fromJson(expectedQuoteResults.get("APT_Non-Trucking Liability"), LinkedHashMap.class), "APT Non-Trucking Liability");
		assertion.assertEquals(tableDataFromPDF.get("Premium Subtotal"), gson.fromJson(expectedQuoteResults.get("APT_Premium Subtotal"), LinkedHashMap.class), "APT Premium Subtotal");
		assertion.assertEquals(tableDataFromPDF.get("Broker Fees"), gson.fromJson(expectedQuoteResults.get("APT_Broker Fees"), LinkedHashMap.class), "APT Broker Fees");
		assertion.assertEquals(tableDataFromPDF.get("Underwriting Fees"), gson.fromJson(expectedQuoteResults.get("APT_Underwriting Fees"), LinkedHashMap.class), "APT Underwriting Fees");
		assertion.assertEquals(tableDataFromPDF.get("Surplus Lines Taxes"), gson.fromJson(expectedQuoteResults.get("APT_Surplus Lines Taxes"), LinkedHashMap.class), "APT Surplus Lines Taxes");
		assertion.assertEquals(tableDataFromPDF.get("Stamping Fees"), gson.fromJson(expectedQuoteResults.get("APT_Stamping Fees"), LinkedHashMap.class), "APT Stamping Fees");

		assertion.assertAll();
	}

}
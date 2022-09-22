package com.coverwhale.validators.web.quotes;

import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.QuotePdfReader;
import com.google.gson.Gson;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.LinkedHashMap;
import java.util.Map;

public class QuoteDataValidatorNC {
	public void validateQuoteDataForTC_15_01() {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_15_01";
		Map<String, String> quoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);


		// CTI

		String CTILabelsToScrap[] = {"Automobile Physical Damage", "Motor Truck Cargo",
				"Truckers General Liability", "Non-Trucking Liability", "Total Cost" };

		Reporter.log("Comparing commercial truck insurance table values");
		// commercial truck insurance data
		Map<String, String> CTIDataFromPDF = quoteReader.getCommercialTruckInsuranceData(quotePDFData, CTILabelsToScrap);
		System.out.println("CTI Data : " + CTIDataFromPDF);
		assertion.assertEquals(CTIDataFromPDF.get("Automobile Physical Damage"), quoteResults.get("CTI_Automobile Physical Damage"), "CTI Automobile Physical Damage");
		assertion.assertEquals(CTIDataFromPDF.get("Motor Truck Cargo"), quoteResults.get("CTI_Motor Truck Cargo"), "CTI Motor Truck Cargo");
		assertion.assertEquals(CTIDataFromPDF.get("Truckers General Liability"), quoteResults.get("CTI_Truckers General Liability"), "CTI Truckers General Liability");
		assertion.assertEquals(CTIDataFromPDF.get("Non-Trucking Liability"), quoteResults.get("CTI_Non-Trucking Liability"), "CTI Non-Trucking Liability");
		assertion.assertEquals(CTIDataFromPDF.get("Total Cost"), quoteResults.get("CTI_Total Cost"), "CTI Total Cost");

		// APD
		String apdYearlyLabelsToScrap[] = { "Policy Fee", "Broker Fee","Surplus Lines Tax", "Stamping Fee", "Underwriting Fee" };
		String apdPremiumDetailLabelsToScrap[] = { "Towing, Storage and Labor", "Trailer Interchange", "Premium Subtotal","Automobile Physical Damage" };

		Reporter.log("Comparing Automobile Physical Damage values");
		Map<String, String> APDDataFromPDF = quoteReader.getAPDData(quotePDFData, apdYearlyLabelsToScrap, apdPremiumDetailLabelsToScrap);
		System.out.println("APD Data : " + APDDataFromPDF);
		assertion.assertEquals(APDDataFromPDF.get("Yearly"), quoteResults.get("APD_Yearly"), "APD Yearly");
		assertion.assertEquals(APDDataFromPDF.get("Policy Fee"), quoteResults.get("APD_Policy Fee"), "APD Policy Fee");
		assertion.assertEquals(APDDataFromPDF.get("Broker Fee"), quoteResults.get("APD_Broker Fee"), "APD Broker Fee");
		assertion.assertEquals(APDDataFromPDF.get("Surplus Lines Tax"), quoteResults.get("APD_Surplus Lines Tax"), "APD Surplus Lines Tax");
		assertion.assertEquals(APDDataFromPDF.get("Stamping Fee"), quoteResults.get("APD_Stamping Fee"), "APD Stamping Fee");
		assertion.assertEquals(APDDataFromPDF.get("Underwriting Fee"), quoteResults.get("APD_Underwriting Fee"), "APD Underwriting Fee");
		//assertion.assertEquals(APDDataFromPDF.get("SLAS Transaction Fees"), quoteResults.get("APD_SLAS Transaction Fees"), "APD SLAS Transaction Fees");
		assertion.assertEquals(APDDataFromPDF.get("Automobile Physical Damage"), quoteResults.get("APD_PD_Automobile Physical Damage"), "APD PD Automobile Physical Damage");  // PD : Premium detail table
		assertion.assertEquals(APDDataFromPDF.get("Towing, Storage and Labor"), quoteResults.get("APD_PD_Towing, Storage and Labor"), "APD PD Towing, Storage and Labor");
		assertion.assertEquals(APDDataFromPDF.get("Trailer Interchange"), quoteResults.get("APD_PD_Trailer Interchange"), "APD PD Trailer Interchange");
		assertion.assertEquals(APDDataFromPDF.get("Premium Subtotal"), quoteResults.get("APD_PD_Premium Subtotal"), "APD PD Premium Subtotal");

		// MTC
		String mtcYearlyLabelsToScrap[] = { "Policy Fee", "Broker Fee", "Surplus Lines Tax","Stamping Fee","Underwriting Fee"};
		String mtcPremiumDetailLabelsToScrap[] = { "Premium Subtotal","Motor Truck Cargo"};

		Reporter.log("Comparing Motor Truck Cargo values");
		Map<String, String> MTCDataFromPDF = quoteReader.getMTCData(quotePDFData, mtcYearlyLabelsToScrap, mtcPremiumDetailLabelsToScrap);
		System.out.println("MTC Data : " + MTCDataFromPDF);
		assertion.assertEquals(MTCDataFromPDF.get("Yearly"), quoteResults.get("MTC_Yearly"), "MTC Yearly");
		assertion.assertEquals(MTCDataFromPDF.get("Policy Fee"), quoteResults.get("MTC_Policy Fee"), "MTC Policy Fee");
		assertion.assertEquals(MTCDataFromPDF.get("Broker Fee"), quoteResults.get("MTC_Broker Fee"), "MTC Broker Fee");
		assertion.assertEquals(MTCDataFromPDF.get("Surplus Lines Tax"), quoteResults.get("MTC_Surplus Lines Tax"), "MTC Surplus Lines Tax");
		assertion.assertEquals(MTCDataFromPDF.get("Stamping Fee"), quoteResults.get("MTC_Stamping Fee"), "MTC Stamping Fee");
		assertion.assertEquals(MTCDataFromPDF.get("Underwriting Fee"), quoteResults.get("MTC_Underwriting Fee"), "MTC Underwriting Fee");
		//assertion.assertEquals(APDDataFromPDF.get("SLAS Transaction Fees"), quoteResults.get("APD_SLAS Transaction Fees"), "APD SLAS Transaction Fees");
		assertion.assertEquals(MTCDataFromPDF.get("Motor Truck Cargo"), quoteResults.get("MTC_PD_Motor Truck Cargo"), "MTC PD Motor Truck Cargo");  // PD : Premium detail table
		assertion.assertEquals(MTCDataFromPDF.get("Premium Subtotal"), quoteResults.get("MTC_PD_Premium Subtotal"), "MTC PD Premium Subtotal");

		// TGC
		String tgcPremiumDetailLabelsToScrap[] = {  "Policy Fee", "Broker Fee", "Underwriting Fee", "Surplus Lines Tax", "Stamping Fee"};

		Reporter.log("Comparing Truckers General Liability premium detail values");
		Map<String, String> TGCDataFromPDF = quoteReader.getTGCData(quotePDFData, tgcPremiumDetailLabelsToScrap);
		System.out.println("TGC Data : " + TGCDataFromPDF);

		assertion.assertEquals(TGCDataFromPDF.get("Truckers General Liability Premium"), quoteResults.get("TGC_Truckers General Liability Premium"), "TGC Truckers General Liability Premium");
		assertion.assertEquals(TGCDataFromPDF.get("Policy Fee"), quoteResults.get("TGC_Policy Fee"), "TGC Policy Fee");
		assertion.assertEquals(TGCDataFromPDF.get("Broker Fee"), quoteResults.get("TGC_Broker Fee"), "TGC Broker Fee");
		assertion.assertEquals(TGCDataFromPDF.get("Underwriting Fee"), quoteResults.get("TGC_Underwriting Fee"), "TGC Underwriting Fee");
		assertion.assertEquals(TGCDataFromPDF.get("Surplus Lines Tax"), quoteResults.get("TGC_Surplus Lines Tax"), "TGC Surplus Lines Tax");
		assertion.assertEquals(TGCDataFromPDF.get("Stamping Fee"), quoteResults.get("TGC_Stamping Fee"), "TGC Stamping Fee");
		//assertion.assertEquals(TGCDataFromPDF.get("SLAS Transaction Fees"), quoteResults.get("TGC_SLAS Transaction Fees"), "TGC SLAS Transaction Fees");
		assertion.assertEquals(TGCDataFromPDF.get("Total Cost"), quoteResults.get("TGC_Total Cost"), "TGC Total cost");

		// NTL
		String ntlPremiumDetailLabelsToScrap[] = {  "Policy Fee", "Broker Fee", "Underwriting Fee", "Surplus Lines Tax", "Stamping Fee"};


		Reporter.log("Comparing Non-Trucking Liability premium detail values");
		Map<String, String> NTLDataFromPDF = quoteReader.getNTLData(quotePDFData, ntlPremiumDetailLabelsToScrap);
		System.out.println("NTL Data : " + NTLDataFromPDF);
		assertion.assertEquals(NTLDataFromPDF.get("Non-Trucking Liability Premium"), quoteResults.get("NTL_Non-Trucking Liability Premium"), "NTL Non-Trucking Liability Premium");
		assertion.assertEquals(NTLDataFromPDF.get("Policy Fee"), quoteResults.get("NTL_Policy Fee"), "NTL Policy Fee");
		assertion.assertEquals(NTLDataFromPDF.get("Broker Fee"), quoteResults.get("NTL_Broker Fee"), "NTL Broker Fee");
		assertion.assertEquals(NTLDataFromPDF.get("Underwriting Fee"), quoteResults.get("NTL_Underwriting Fee"), "NTL Underwriting Fee");
		assertion.assertEquals(NTLDataFromPDF.get("Surplus Lines Tax"), quoteResults.get("NTL_Surplus Lines Tax"), "NTL Surplus Lines Tax");
		assertion.assertEquals(NTLDataFromPDF.get("Stamping Fee"), quoteResults.get("NTL_Stamping Fee"), "NTL Stamping Fee");
		// assertion.assertEquals(NTLDataFromPDF.get("SLAS Transaction Fees"), quoteResults.get("NTL_SLAS Transaction Fees"), "NTL SLAS Transaction Fees");
		assertion.assertEquals(NTLDataFromPDF.get("Total Cost"), quoteResults.get("NTL_Total Cost"), "NTL Total Cost");

		assertion.assertAll();
	}

	public void validateQuoteDocAdditionalPremiumTaxes(String testCaseID) {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = testCaseID;
		Map<String, String> expectedQuoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);

		String valuesToRead[] = { "Automobile Physical Damage","Motor Truck Cargo","Non-Trucking Liability",
				"Premium Subtotal", "Surplus Lines Taxes" };

		// APT: Additional premium and taxes
		Reporter.log("Comparing [Additional Premium and Taxes] table values");
		Map<String, Map<String,String>> tableDataFromPDF = quoteReader.getAdditionalPremiumAndTaxesTableData(quotePDFData, valuesToRead);
		Gson gson = new Gson();
		//	System.out.println(gson.toJson(tableDataFromPDF));
		assertion.assertEquals(tableDataFromPDF.get("Automobile Physical Damage"), gson.fromJson(expectedQuoteResults.get("APT_Automobile Physical Damage"), LinkedHashMap.class), "APT Automobile Physical Damage");
		assertion.assertEquals(tableDataFromPDF.get("Motor Truck Cargo"), gson.fromJson(expectedQuoteResults.get("APT_Motor Truck Cargo"), LinkedHashMap.class), "APT Motor Truck Cargo");
		assertion.assertEquals(tableDataFromPDF.get("Non-Trucking Liability"), gson.fromJson(expectedQuoteResults.get("APT_Non-Trucking Liability"), LinkedHashMap.class), "APT Non-Trucking Liability");
		assertion.assertEquals(tableDataFromPDF.get("Premium Subtotal"), gson.fromJson(expectedQuoteResults.get("APT_Premium Subtotal"), LinkedHashMap.class), "APT Premium Subtotal");
		assertion.assertEquals(tableDataFromPDF.get("Surplus Lines Taxes"), gson.fromJson(expectedQuoteResults.get("APT_Surplus Lines Taxes"), LinkedHashMap.class), "APT Surplus Lines Taxes");

		assertion.assertAll();
	}

	public void validateQuoteDocReturnPremiumTaxes(String testCaseID) {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = testCaseID;
		Map<String, String> expectedQuoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);

		String valuesToRead[] = { "Automobile Physical Damage", "Motor Truck Cargo", "Truckers General Liability", "Non-Trucking Liability",
				"Premium Subtotal","Surplus Lines Taxes" };

		// APT: Additional premium and taxes
		Reporter.log("Comparing [Return Premium and Taxes] table values");
		Map<String, Map<String,String>> tableDataFromPDF = quoteReader.getReturnPremiumAndTaxesTableData(quotePDFData, valuesToRead);
		Gson gson = new Gson();
		//	System.out.println(gson.toJson(tableDataFromPDF));
		assertion.assertEquals(tableDataFromPDF.get("Automobile Physical Damage"), gson.fromJson(expectedQuoteResults.get("APT_Automobile Physical Damage"), LinkedHashMap.class), "APT Automobile Physical Damage");
		assertion.assertEquals(tableDataFromPDF.get("Motor Truck Cargo"), gson.fromJson(expectedQuoteResults.get("APT_Motor Truck Cargo"), LinkedHashMap.class), "APT Motor Truck Cargo");
		assertion.assertEquals(tableDataFromPDF.get("Truckers General Liability"), gson.fromJson(expectedQuoteResults.get("APT_Truckers General Liability"), LinkedHashMap.class), "APT Truckers General Liability");
		assertion.assertEquals(tableDataFromPDF.get("Non-Trucking Liability"), gson.fromJson(expectedQuoteResults.get("APT_Non-Trucking Liability"), LinkedHashMap.class), "APT Non-Trucking Liability");
		assertion.assertEquals(tableDataFromPDF.get("Premium Subtotal"), gson.fromJson(expectedQuoteResults.get("APT_Premium Subtotal"), LinkedHashMap.class), "APT Premium Subtotal");
		assertion.assertEquals(tableDataFromPDF.get("Surplus Lines Taxes"), gson.fromJson(expectedQuoteResults.get("APT_Surplus Lines Taxes"), LinkedHashMap.class), "APT Surplus Lines Taxes");

		assertion.assertAll();
	}

	public void validateNonPremiumBearingPremiumAndTaxesTableData(String testCaseID) {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = testCaseID;
		Map<String, String> expectedQuoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);

		String valuesToRead[] = {"Automobile Physical Damage", "Motor Truck Cargo", "Truckers General Liability", "Non-Trucking Liability",
				"Premium Subtotal", "Surplus Lines Taxes"};

		// APT: Additional premium and taxes
		Reporter.log("Comparing [Additional Non Premium and Taxes] table values");
		Map<String, Map<String, String>> tableDataFromPDF = quoteReader.NonPremiumBearingPremiumAndTaxesTableData(quotePDFData, valuesToRead);
		Gson gson = new Gson();
		//	System.out.println(gson.toJson(tableDataFromPDF));
		assertion.assertEquals(tableDataFromPDF.get("Automobile Physical Damage"), gson.fromJson(expectedQuoteResults.get("APT_Automobile Physical Damage"), LinkedHashMap.class), "APT Automobile Physical Damage");
		assertion.assertEquals(tableDataFromPDF.get("Motor Truck Cargo"), gson.fromJson(expectedQuoteResults.get("APT_Motor Truck Cargo"), LinkedHashMap.class), "APT Motor Truck Cargo");
		assertion.assertEquals(tableDataFromPDF.get("Truckers General Liability"), gson.fromJson(expectedQuoteResults.get("APT_Truckers General Liability"), LinkedHashMap.class), "APT Truckers General Liability");
		assertion.assertEquals(tableDataFromPDF.get("Non-Trucking Liability"), gson.fromJson(expectedQuoteResults.get("APT_Non-Trucking Liability"), LinkedHashMap.class), "APT Non-Trucking Liability");
		assertion.assertEquals(tableDataFromPDF.get("Premium Subtotal"), gson.fromJson(expectedQuoteResults.get("APT_Premium Subtotal"), LinkedHashMap.class), "APT Premium Subtotal");
		assertion.assertEquals(tableDataFromPDF.get("Surplus Lines Taxes"), gson.fromJson(expectedQuoteResults.get("APT_Surplus Lines Taxes"), LinkedHashMap.class), "APT Surplus Lines Taxes");

		assertion.assertAll();

	}

}
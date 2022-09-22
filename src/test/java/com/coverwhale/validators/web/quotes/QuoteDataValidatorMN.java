package com.coverwhale.validators.web.quotes;

import java.util.LinkedHashMap;
import java.util.Map;
import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.QuotePdfReader;
import com.google.gson.Gson;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class QuoteDataValidatorMN {


	public void validateQuoteDataForTC_13_01() {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_13_01";
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

		// AL
		String alYearlyLabelsToScrap[] = { "Policy Fee", "Broker Fee", "Surplus Lines Tax", "Stamping Fee", "Underwriting Fee" };
		String alPremiumDetailLabelsToScrap[] = { "Automobile Liability", "Premium Subtotal", };
		Reporter.log("Comparing Automobile Liability values");
		Map<String, String> ALDataFromPDF = quoteReader.getALData(quotePDFData, alYearlyLabelsToScrap, alPremiumDetailLabelsToScrap);
		System.out.println("AL Data : " + ALDataFromPDF);
		assertion.assertEquals(ALDataFromPDF.get("Yearly"), quoteResults.get("AL_Yearly"), "AL Yearly");
		assertion.assertEquals(ALDataFromPDF.get("Policy Fee"), quoteResults.get("AL_Policy Fee"), "AL Policy Fee");
		assertion.assertEquals(ALDataFromPDF.get("Broker Fee"), quoteResults.get("AL_Broker Fee"), "AL Broker Fee");
		assertion.assertEquals(ALDataFromPDF.get("Surplus Lines Tax"), quoteResults.get("AL_Surplus Lines Tax"), "AL Surplus Lines Tax");
		assertion.assertEquals(ALDataFromPDF.get("Stamping Fee"), quoteResults.get("AL_Stamping Fee"), "AL Stamping Fee");
		assertion.assertEquals(ALDataFromPDF.get("Underwriting Fee"), quoteResults.get("AL_Underwriting Fee"), "AL Underwriting Fee");
		assertion.assertEquals(ALDataFromPDF.get("Automobile Liability"), quoteResults.get("AL_PD_Automobile Liability"), "AL_PD Automobile Liability");  // PD : Premium detail table
		assertion.assertEquals(ALDataFromPDF.get("Premium Subtotal"), quoteResults.get("AL_PD_Premium Subtotal"), "AL_PD Premium Subtotal");

		assertion.assertAll();

	}

	public void validateQuoteDocAdditionalPremiumTaxes(String testCaseID) {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = testCaseID;
		Map<String, String> expectedQuoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);

		String valuesToRead[] = { "Auto Liability", "Premium Subtotal", "Policy Fees", "Broker Fees", "Underwriting Fees", "Surplus Lines Taxes", "Stamping Fees" };

		// APT: Additional premium and taxes
		Reporter.log("Comparing [Additional Premium and Taxes] table values");
		Map<String, Map<String,String>> tableDataFromPDF = quoteReader.NonPremiumBearingPremiumAndTaxesTableData(quotePDFData, valuesToRead);
		Gson gson = new Gson();
		//System.out.println(gson.toJson(tableDataFromPDF));
		assertion.assertEquals(tableDataFromPDF.get("Auto Liability"), gson.fromJson(expectedQuoteResults.get("APT_Auto Liability"), LinkedHashMap.class), "APT Auto Liability");
		assertion.assertEquals(tableDataFromPDF.get("Premium Subtotal"), gson.fromJson(expectedQuoteResults.get("APT_Premium Subtotal"), LinkedHashMap.class), "APT Premium Subtotal");
		assertion.assertEquals(tableDataFromPDF.get("Broker Fees"), gson.fromJson(expectedQuoteResults.get("APT_Broker Fees"), LinkedHashMap.class), "APT Broker Fees");
		assertion.assertEquals(tableDataFromPDF.get("Underwriting Fees"), gson.fromJson(expectedQuoteResults.get("APT_Underwriting Fees"), LinkedHashMap.class), "APT Underwriting Fees");
		assertion.assertEquals(tableDataFromPDF.get("Surplus Lines Taxes"), gson.fromJson(expectedQuoteResults.get("APT_Surplus Lines Taxes"), LinkedHashMap.class), "APT Surplus Lines Taxes");
		assertion.assertEquals(tableDataFromPDF.get("Stamping Fees"), gson.fromJson(expectedQuoteResults.get("APT_Stamping Fees"), LinkedHashMap.class), "APT Stamping Fees");

		assertion.assertAll();
	}


}
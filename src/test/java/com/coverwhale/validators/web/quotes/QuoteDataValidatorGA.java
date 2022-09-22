package com.coverwhale.validators.web.quotes;

import com.coverwhale.core.DataRecorder;
import com.coverwhale.core.QuotePdfReader;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class QuoteDataValidatorGA {
	
	public void validateQuoteDataForTC_11_01() {
		QuotePdfReader quoteReader = new QuotePdfReader();
		SoftAssert assertion = new SoftAssert();
		String testCaseId = "TC_11_01";
		Map<String, String> quoteResults = (Map<String, String>) DataRecorder.QUOTE_RESULT_CACHE.get(testCaseId); // those present in excel sheet
		String quotePDFData = quoteReader.getWholeQuotePDFText(testCaseId);
		
		
		// CTI
		
		String CTILabelsToScrap[] = { "Automobile Liability", "Automobile Physical Damage", "Motor Truck Cargo",
				"Truckers General Liability", "Non-Trucking Liability", "Total Cost" };
		
		Reporter.log("Comparing commercial truck insurance table values");
		// commercial truck insurance data
		Map<String, String> CTIDataFromPDF = quoteReader.getCommercialTruckInsuranceData(quotePDFData, CTILabelsToScrap);
		System.out.println("CTI Data : " + CTIDataFromPDF);
		assertion.assertEquals(CTIDataFromPDF.get("Automobile Liability"), quoteResults.get("CTI_Automobile Liability"), "CTI Automobile Liability");
		assertion.assertEquals(CTIDataFromPDF.get("Automobile Physical Damage"), quoteResults.get("CTI_Automobile Physical Damage"), "CTI Automobile Physical Damage");
		assertion.assertEquals(CTIDataFromPDF.get("Motor Truck Cargo"), quoteResults.get("CTI_Motor Truck Cargo"), "CTI Motor Truck Cargo");
		assertion.assertEquals(CTIDataFromPDF.get("Truckers General Liability"), quoteResults.get("CTI_Truckers General Liability"), "CTI Truckers General Liability");
		assertion.assertEquals(CTIDataFromPDF.get("Non-Trucking Liability"), quoteResults.get("CTI_Non-Trucking Liability"), "CTI Non-Trucking Liability");
		assertion.assertEquals(CTIDataFromPDF.get("Total Cost"), quoteResults.get("CTI_Total Cost"), "CTI Total Cost");

		// AL
		 String alYearlyLabelsToScrap[] = { "Policy Fee", "Broker Fee", "Surplus Lines Tax", "Stamping Fee", "Underwriting Fee" }; 
		 String alPremiumDetailLabelsToScrap[] = { "Automobile Liability", "Premium Subtotal", "Medical Payments" };
		
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
		assertion.assertEquals(ALDataFromPDF.get("Medical Payments"), quoteResults.get("AL_PD_Medical Payments"), "AL PD_Medical Payments");  // PD : Premium detail table
		assertion.assertEquals(ALDataFromPDF.get("Premium Subtotal"), quoteResults.get("AL_PD_Premium Subtotal"), "AL_PD Premium Subtotal");
		
		
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
		
		// MTC
		String mtcYearlyLabelsToScrap[] = { "Policy Fee", "Broker Fee", "Surplus Lines Tax","Stamping Fee"};
		String mtcPremiumDetailLabelsToScrap[] = { "Premium Subtotal"};
		
		Reporter.log("Comparing Motor Truck Cargo values");
		Map<String, String> MTCDataFromPDF = quoteReader.getMTCData(quotePDFData, mtcYearlyLabelsToScrap, mtcPremiumDetailLabelsToScrap);
		System.out.println("MTC Data : " + MTCDataFromPDF);
		assertion.assertEquals(MTCDataFromPDF.get("Yearly"), quoteResults.get("MTC_Yearly"), "MTC Yearly");
		assertion.assertEquals(MTCDataFromPDF.get("Policy Fee"), quoteResults.get("MTC_Policy Fee"), "MTC Policy Fee");
		assertion.assertEquals(MTCDataFromPDF.get("Broker Fee"), quoteResults.get("MTC_Broker Fee"), "MTC Broker Fee");
		assertion.assertEquals(MTCDataFromPDF.get("Surplus Lines Tax"), quoteResults.get("MTC_Surplus Lines Tax"), "MTC Surplus Lines Tax");
		assertion.assertEquals(MTCDataFromPDF.get("Stamping Fee"), quoteResults.get("MTC_Stamping Fee"), "MTC Stamping Fee");
		
		assertion.assertEquals(MTCDataFromPDF.get("Motor Truck Cargo"), quoteResults.get("MTC_PD_Motor Truck Cargo"), "MTC PD Motor Truck Cargo");  // PD : Premium detail table
		assertion.assertEquals(MTCDataFromPDF.get("Premium Subtotal"), quoteResults.get("MTC_PD_Premium Subtotal"), "MTC PD Premium Subtotal");
		
		assertion.assertAll();
	}

}

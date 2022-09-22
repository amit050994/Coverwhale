package com.coverwhale.core;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.coverwhale.utils.common.Constants.PDF_DOWNLOAD_PATH;

/**
 * This class will be used to read all the quote documents.
 *
 * NOTE : [Yearly]  label will be by default extracted for all types. AL,APD and MTC. So you don't need to give it as an input
 * @author jaikant
 *
 */
public class QuotePdfReader {


	private static final Logger LOGGER = LoggerFactory.getLogger(QuotePdfReader.class);
	public static Map<String, String> QUOTE_PDF_MAP = new HashMap<String, String>();

	public File getPDFDocument(String quoteNumber) {
		LOGGER.info("Getting quote document for quote number : {}", quoteNumber);
		File directory = new File(PDF_DOWNLOAD_PATH);
		File[] files = directory.listFiles(File::isFile);
		long lastModifiedTime = Long.MIN_VALUE;
		File chosenFile = null;

		if (files != null) {
			for (File file : files) {
				if (file.lastModified() > lastModifiedTime) {
					chosenFile = file;
					lastModifiedTime = file.lastModified();
				}
			}
		}

		return chosenFile != null && chosenFile.getName().contains(quoteNumber) ? chosenFile : null;
	}

	public String getWholeQuotePDFText(String testCaseId) {
		String QUOTE_PDF_TEXT = "";
		try (PDDocument document = PDDocument.load(getPDFDocument(QUOTE_PDF_MAP.get(testCaseId)))) {
			document.getClass();

			if (!document.isEncrypted()) {

				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper tStripper = new PDFTextStripper();
				QUOTE_PDF_TEXT = tStripper.getText(document);
			}}
		catch (Exception e) {
			LOGGER.error("Got exception {} while reading quote pdf document for test Id {}", e.getMessage(), testCaseId);
		}

		return QUOTE_PDF_TEXT;
	}


	// for CTI
	public Map<String, String> getCommercialTruckInsuranceData(String quotePDFData, String commercialInsuranceLabels[]) {
		Map<String, String> policyData = new LinkedHashMap<>();
		for (String label : commercialInsuranceLabels) {
			if (label.equals("Total Cost")) {
				policyData.put(label, quotePDFData.split(label)[2].split("\n")[0].trim());
			} else {
				policyData.put(label, quotePDFData.split(label)[1].split("\n")[0].trim());
			}
		}

		return policyData;
	}

	// for AL
	public Map<String, String> getALData(String wholePdf, String alYearlyLabels[], String alPremiumDetailLabels[]) {
		String textToSplit = wholePdf.split("Commercial Automobile Liability")[1];
		Map<String, String> alData = new LinkedHashMap<>();
		for (String label : alYearlyLabels) {
			alData.put(label, textToSplit.split(label)[1].split("\n")[0].split(" ")[1].trim());
		}

		// getting yearly cost
		alData.put("Yearly", textToSplit.split("ID")[1].split("\n")[1].trim());
		String premiumDetailText = textToSplit.split("Premium Detail")[1];

		for (String label : alPremiumDetailLabels) {
			String value = premiumDetailText.split(label)[1].split("\n")[0].trim();
			if (value.contains(")"))
				value = value.split("\\)")[1].trim();
			alData.put(label, value);
		}

		return alData;
	}

	// for APD
	public Map<String, String> getAPDData(String wholePdf, String apdYearlyLabels[], String apdPremiumDetailLabels[]) {
		String textToSplit = wholePdf.split("Automobile Physical Damage")[2];
		Map<String, String> apdData = new LinkedHashMap<>();
		for (String label : apdYearlyLabels) {
			apdData.put(label, textToSplit.split(label)[1].split("\n")[0].split(" ")[1].trim());
		}

		// getting yearly cost
		apdData.put("Yearly", wholePdf.split("Automobile Physical Damage")[3].split("ID")[1].split("\n")[1].trim());

		String premiumDetailText = "Automobile Physical Damage" + wholePdf.split("Automobile Physical Damage")[3].split("Premium Detail")[0];
		apdData.put("Automobile Physical Damage", premiumDetailText.split("\n")[0].split("\\)")[1].trim());
		for (String label : apdPremiumDetailLabels) {
			String value = premiumDetailText.split(label)[1].split("\n")[0].trim();
			if (value.contains(")"))
				value = value.split("\\)")[1].trim();
			apdData.put(label, value);
		}


		return apdData;
	}

	// for MTC
	public Map<String, String> getMTCData(String wholePdf, String mtcYearlyLabels[], String mtcPremiumDetailLabels[]) {
		String textToSplit = wholePdf.split("Motor Truck Cargo")[2];
		Map<String, String> mtcData = new LinkedHashMap<>();
		for (String label : mtcYearlyLabels) {
			mtcData.put(label, textToSplit.split(label)[1].split("\n")[0].split(" ")[1].trim());
		}

		// getting yearly cost
		mtcData.put("Yearly", wholePdf.split("Motor Truck Cargo")[3].split("ID")[1].split("\n")[1].trim());

		String premiumDetailText = "Motor Truck Cargo"+ wholePdf.split("Motor Truck Cargo")[3].split("Premium Detail")[0];
		mtcData.put("Motor Truck Cargo", premiumDetailText.split("\n")[0].split("\\)")[1].trim());
		for (String label : mtcPremiumDetailLabels) {
			String value = premiumDetailText.split(label)[1].split("\n")[0].trim();
			if (value.contains(")"))
				value = value.split("\\)")[1].trim();
			mtcData.put(label, value);
		}

		return mtcData;
	}

	// for TGC
		public  Map<String, String> getTGCData(String wholePdf, String tgcPremiumDetailLabels[]) {
			Map<String, String> tgcData = new LinkedHashMap<>();

			String premiumDetailText = wholePdf.split("Truckers General Liability")[3];
			tgcData.put("Truckers General Liability Premium", premiumDetailText.split("\nPremium:")[1].split(" ")[1]);
			tgcData.put("Total Cost", premiumDetailText.split("ID")[1].split("\n")[1].trim());
			for (String label : tgcPremiumDetailLabels) {
				String value = premiumDetailText.split(label)[1].split("\n")[0].split(" ")[1].trim();
				if (value.contains(")"))
					value = value.split("\\)")[1].trim();
				tgcData.put(label, value);
			}

			return tgcData;
		}

		// for NTL
		public Map<String, String> getNTLData(String wholePdf, String ntlPremiumDetailLabels[]) {
			Map<String, String> ntlData = new LinkedHashMap<>();

			String premiumDetailText = wholePdf.split("Non-Trucking Liability")[3];
			ntlData.put("Non-Trucking Liability Premium", premiumDetailText.split(" Premium:")[1].split("\n")[1].split(" ")[0].trim());
			ntlData.put("Total Cost", premiumDetailText.split("ID")[1].split("\n")[1].trim());
			for (String label : ntlPremiumDetailLabels) {
				String value = premiumDetailText.split(label)[1].split("\n")[0].split(" ")[1].trim();
				if (value.contains(")"))
					value = value.split("\\)")[1].trim();
				ntlData.put(label, value);
			}

			return ntlData;
		}

	/**
	 *  It will read the big table, Additional premium and taxes table in quote document after each endorsement.
	 *  For labels that contains brackets (), are put in if condition as they have different split logic as compared to other labels present in table.
	 *  You can see that in the method
	 */
		public Map<String, Map<String,String>> getAdditionalPremiumAndTaxesTableData(String wholePdf, String labelToRead[]) {
			Map<String, Map<String,String>> data = new HashMap<>();

			String additionalPremiumTableText = wholePdf.split("Additional Premium and Taxes")[1];
			String labelData[] = {};
			for (String label : labelToRead) {
				System.out.println(label);
				if (label.equals("Surplus Lines Taxes") || label.equals("Fire Marshal Tax") || label.equals("Stamping Fees")) {
					labelData = additionalPremiumTableText.split(label)[1].split("\n")[1].split("\\)")[1].trim().split(" ");
				} /** else if (label.equals("Stamping Fees")) {
					labelData = additionalPremiumTableText.split("Stamping Fees")[1].split("\n")[0].split("\\)")[1].trim().split(" ");
				}**/ else {
					labelData = additionalPremiumTableText.split(label)[1].split("\n")[0].trim().split(" ");
				}

				Map<String, String> tableColumnsData = new LinkedHashMap<String, String>();
				tableColumnsData.put("Prior Annual Cost", labelData[0]);
				tableColumnsData.put("New Annual Cost", labelData[1]);
				tableColumnsData.put("Endorsement Cost", labelData[2]);
				data.put(label, tableColumnsData);
			}

			return data;
		}

	public Map<String, Map<String,String>> NonPremiumBearingPremiumAndTaxesTableData(String wholePdf, String labelToRead[]) {
		Map<String, Map<String,String>> data = new HashMap<>();

		String nonPremiumBearingTableText = wholePdf.split("Non-Premium Bearing Endorsement")[1];
		String labelData[] = {};
		for (String label : labelToRead) {
			System.out.println(label);
			if (label.equals("Surplus Lines Taxes") || label.equals("Fire Marshal Tax") || label.equals("Stamping Fees")) {
				labelData = nonPremiumBearingTableText.split(label)[1].split("\n")[1].split("\\)")[1].trim().split(" ");
			} /** else if (label.equals("Stamping Fees")) {
			 labelData = nonPremiumBearingTableText.split("Stamping Fees")[1].split("\n")[0].split("\\)")[1].trim().split(" ");
			 }**/ else {
				labelData = nonPremiumBearingTableText.split(label)[1].split("\n")[0].trim().split(" ");
			}

			Map<String, String> tableColumnsData = new LinkedHashMap<String, String>();
			tableColumnsData.put("Prior Annual Cost", labelData[0]);
			tableColumnsData.put("New Annual Cost", labelData[1]);
			tableColumnsData.put("Endorsement Cost", labelData[2]);
			data.put(label, tableColumnsData);
		}

		return data;
	}

	public Map<String, Map<String,String>> getReturnPremiumAndTaxesTableData(String wholePdf, String labelToRead[]) {
		Map<String, Map<String,String>> data = new HashMap<>();

		String ReturnPremiumTableText = wholePdf.split("Return Premium and Taxes")[1];
		String labelData[] = {};
		for (String label : labelToRead) {
			System.out.println(label);
			if (label.equals("Surplus Lines Taxes") || label.equals("Fire Marshal Tax") || label.equals("Stamping Fees")) {
				labelData = ReturnPremiumTableText.split(label)[1].split("\n")[1].split("\\)")[1].trim().split(" ");
			} /** else if (label.equals("Stamping Fees")) {
			 labelData = ReturnPremiumTableText.split("Stamping Fees")[1].split("\n")[0].split("\\)")[1].trim().split(" ");
			 }**/ else {
				labelData = ReturnPremiumTableText.split(label)[1].split("\n")[0].trim().split(" ");
			}

			Map<String, String> tableColumnsData = new LinkedHashMap<String, String>();
			tableColumnsData.put("Prior Annual Cost", labelData[0]);
			tableColumnsData.put("New Annual Cost", labelData[1]);
			tableColumnsData.put("Endorsement Cost", labelData[2]);
			data.put(label, tableColumnsData);
		}

		return data;
	}
}
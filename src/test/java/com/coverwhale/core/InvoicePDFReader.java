package com.coverwhale.core;

import static com.coverwhale.utils.common.Constants.PDF_DOWNLOAD_PATH;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvoicePDFReader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InvoicePDFReader.class);

	// TODO log this map on execution finish to show the invoice document number for each test
	public static Map<String, String> INVOICE_DOC_MAP = new HashMap<String, String>();

	public static Map<String, String> getPolicyData(String wholePdfText, String alPolicyLabels[]) {
		Map<String, String> policyData = new LinkedHashMap<>();
		for (String label : alPolicyLabels) {
			policyData.put(label, wholePdfText.split(label)[1].split("\n")[0].trim());
		}

		return policyData;
	}

	/**
	 * 
	 * @param testCaseId
	 * @param policy
	 * @param valuesToScrapFromPdf
	 */
	public static Map<String, String> getInvoiceData(String testCaseId, String policy, String[] valuesToScrapFromPdf) {
		System.out.println("Getting Invoice data for test case id: " + testCaseId + "and policy: " + policy);
		Map<String, String> policyData = new HashMap<String, String>();

		try (PDDocument document = PDDocument.load(getPDFDocument(INVOICE_DOC_MAP.get(testCaseId)))) {
			document.getClass();

			if (!document.isEncrypted()) {

				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper tStripper = new PDFTextStripper();
				String pdfFileInText = tStripper.getText(document);
				String alText = pdfFileInText.split("INVOICE : " + policy + " Policy")[1];
				policyData = getPolicyData(alText, valuesToScrapFromPdf);

				return policyData;
			}

		} catch (IOException e) {
			System.out.println("Got exception while reading pdf document " + e.getMessage());
		}

		return policyData;
	}
	
	public static File getPDFDocument(String invoiceNumber) {
		LOGGER.info("Gettinhg invoice document for invoice number : {}", invoiceNumber);
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
		
		return chosenFile !=null && chosenFile.getName().contains(invoiceNumber)? chosenFile : null;
	}

}

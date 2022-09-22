package com.coverwhale.crawler.invoicedoc;

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

public class InvoiceDocReaderForCrawler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceDocReaderForCrawler.class);

	// TODO log this map on execution finish to show the invoice document number for each test
	public static Map<String, String> INVOICE_DOC_CRAWLER_MAP = new HashMap<String, String>();

	public static Map<String, String> getPolicyData(String policy, String wholePdfText, String policyLabels[]) {
		Map<String, String> policyData = new LinkedHashMap<>();
		for (String label : policyLabels) {
			try {
				String actualLabel = label.split(policy + "_")[1];
				policyData.put(label, wholePdfText.split(actualLabel)[1].split("\n")[0].trim());
			} catch (Exception e) {
				LOGGER.error("Error while reading label {} for policy {} ", label, policy);
			}
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

		try (PDDocument document = PDDocument.load(getPDFDocument(INVOICE_DOC_CRAWLER_MAP.get(testCaseId)))) {
			document.getClass();

			if (!document.isEncrypted()) {

				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper tStripper = new PDFTextStripper();
				String pdfFileInText = tStripper.getText(document);
				String alText = pdfFileInText.split("INVOICE : " + policy + " Policy")[1];
				policyData = getPolicyData(policy, alText, valuesToScrapFromPdf);

				return policyData;
			}

		} catch (Exception e) {
			System.out.println("Got exception while reading pdf document " + e.getMessage());
		}

		return policyData;
	}
	
	public static File getPDFDocument(String invoiceNumber) {
		LOGGER.info("Getting invoice document for invoice number : {}", invoiceNumber);
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

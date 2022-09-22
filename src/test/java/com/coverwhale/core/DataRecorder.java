package com.coverwhale.core;

import static com.coverwhale.utils.common.Constants.CONFIG_FOLDER_PATH;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coverwhale.utils.common.ExcelUtils;

/**
 * This class is responsible for recording the data from the excel data file
 * Also recording locators from provided packages.
 * 
 * @author Jaikant
 *
 */
public class DataRecorder {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataRecorder.class);
	public static final String dataFilePath = CONFIG_FOLDER_PATH + File.separator + "TestData.xlsx";

	public static Map<String, Object> TC_MAPPING_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> PROFILES_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> QUOTES_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> SUBMISSION_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> INSURED_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> PRODUCER_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> LIMITS_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> OPERATIONS_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> RADIUS_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> CARGO_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> TERMINAL_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> VEHICLES_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> TRAILERS_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> DRIVERS_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> LOSSES_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> RATES_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> SUMMARY_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> ADMIN_RATES_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> ADMIN_FEES_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> INVOICE_RESULT_CACHE = new LinkedHashMap<>();
	public static Map<String, Object> QUOTE_RESULT_CACHE = new LinkedHashMap<>();
	
	

	/**
	 * It will record all the data from data sheets in respective maps.
	 */
	public static void recordData() {
		TC_MAPPING_CACHE = ExcelUtils.getSheetData(dataFilePath, "TC_MAPPING");

		PROFILES_CACHE = ExcelUtils.getSheetData(dataFilePath, "Profile");
		DRIVERS_CACHE = ExcelUtils.getSheetData(dataFilePath, "Drivers");
		QUOTES_CACHE = ExcelUtils.getSheetData(dataFilePath, "Quote");
		SUBMISSION_CACHE = ExcelUtils.getSheetData(dataFilePath, "Submission");
		INSURED_CACHE = ExcelUtils.getSheetData(dataFilePath, "Insured");
		PRODUCER_CACHE = ExcelUtils.getSheetData(dataFilePath, "Producer");
		LIMITS_CACHE = ExcelUtils.getSheetData(dataFilePath, "Limits");
		OPERATIONS_CACHE = ExcelUtils.getSheetData(dataFilePath, "Operations");
		RADIUS_CACHE = ExcelUtils.getSheetData(dataFilePath, "Radius");
		CARGO_CACHE = ExcelUtils.getSheetData(dataFilePath, "Cargo");
		TERMINAL_CACHE = ExcelUtils.getSheetData(dataFilePath, "Terminals");
		VEHICLES_CACHE = ExcelUtils.getSheetData(dataFilePath, "Vehicles");
		TRAILERS_CACHE = ExcelUtils.getSheetData(dataFilePath, "Trailers");
		RATES_CACHE = ExcelUtils.getSheetData(dataFilePath, "Rates");
		LOSSES_CACHE = ExcelUtils.getSheetData(dataFilePath, "Losses");
		SUMMARY_CACHE = ExcelUtils.getSheetData(dataFilePath, "Summary");
		ADMIN_RATES_CACHE = ExcelUtils.getSheetData(dataFilePath, "AdminRates");
		ADMIN_FEES_CACHE = ExcelUtils.getSheetData(dataFilePath, "AdminFees");
		INVOICE_RESULT_CACHE = ExcelUtils.getSheetData(dataFilePath, "InvoiceResult");
		QUOTE_RESULT_CACHE = ExcelUtils.getSheetData(dataFilePath, "QuoteResult");

	}

	/**
	 * It will return test case data based on its test id or TC_ID as defined in
	 * TC_MAPPING sheet.
	 * 
	 * @param tcId test case id e.g "TC_1"
	 * @return test data map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getTestData(String tcId) {
		LOGGER.info("Getting test data for TestId : {}", tcId);
		Map<String, Object> tcMappingData = ((Map<String, Object>) TC_MAPPING_CACHE.get(tcId)).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));;
		
		tcMappingData.put("Profile", PROFILES_CACHE.get(tcMappingData.get("Profile")));
		tcMappingData.put("Drivers", DRIVERS_CACHE.get(tcMappingData.get("Drivers")));
		tcMappingData.put("Quote", QUOTES_CACHE.get(tcMappingData.get("Quote")));
		tcMappingData.put("Submission", SUBMISSION_CACHE.get(tcMappingData.get("Submission")));
		tcMappingData.put("Insured", INSURED_CACHE.get(tcMappingData.get("Insured")));
		tcMappingData.put("Producer", PRODUCER_CACHE.get(tcMappingData.get("Producer")));
		tcMappingData.put("Limits", LIMITS_CACHE.get(tcMappingData.get("Limits")));
		tcMappingData.put("Operations", OPERATIONS_CACHE.get(tcMappingData.get("Operations")));
		tcMappingData.put("Radius", RADIUS_CACHE.get(tcMappingData.get("Radius")));
		tcMappingData.put("Cargo", CARGO_CACHE.get(tcMappingData.get("Cargo")));
		tcMappingData.put("Terminals", TERMINAL_CACHE.get(tcMappingData.get("Terminals")));
		tcMappingData.put("Vehicles", VEHICLES_CACHE.get(tcMappingData.get("Vehicles")));
		tcMappingData.put("Trailers", TRAILERS_CACHE.get(tcMappingData.get("Trailers")));
		tcMappingData.put("Rates", RATES_CACHE.get(tcMappingData.get("Rates")));
		tcMappingData.put("Summary", SUMMARY_CACHE.get(tcMappingData.get("Summary")));
		tcMappingData.put("AdminRates", ADMIN_RATES_CACHE.get(tcMappingData.get("AdminRates")));
		tcMappingData.put("AdminFees", ADMIN_FEES_CACHE.get(tcMappingData.get("AdminFees")));
		tcMappingData.put("InvoiceResult", INVOICE_RESULT_CACHE.get(tcMappingData.get("InvoiceResult")));
		
		// TEMP fix , we are getting an empty key value pair in our data.
		// TODO Debug it more to see what is happening. For the moment we are good and there is no problem
		tcMappingData.entrySet().removeIf(e -> StringUtils.isBlank(e.getKey()));

		 // just for debugging purpose
//		Gson gson = new Gson();
//		String json = gson.toJson(tcMappingData);
//		System.out.println(json);
		// LOGGER.info(json);

		return tcMappingData;
	}

}

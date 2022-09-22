package com.coverwhale.reporter.extent;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** Work under construction for this  // TODO
 * @author Jaikant
 *
 */
public class ExcelReporter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelReporter.class);
	public static Map<String,String> TEST_RESULT_MAP = new HashMap<>();
	private static final String INVOICE_CRAWLER_DATA_SHEET_LOCATION  = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config" + File.separator + "InvoiceCrawlerData.xlsx";
	public static int scenarioIdCellNo;
	public static int executionResultCellNo;
	public static Map<String, Integer> headerMap = new HashMap<>();
	
	
	public static void fillResults(Map<String,Map<String, String>> TEST_RESULT_MAP) {
		XSSFWorkbook workbook = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(INVOICE_CRAWLER_DATA_SHEET_LOCATION);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			LOGGER.error("" + "Exception occurred while reading excel workbook : {}", e.getMessage());
		}
		XSSFSheet sheet = workbook.getSheet("Summary");
		Map<String,Map<String,String>> tcMappingData = getSheetData(INVOICE_CRAWLER_DATA_SHEET_LOCATION, "Summary");
		List <String> tcIds = new ArrayList<>(tcMappingData.keySet());

		
		Iterator<Row> iterator = sheet.iterator();
		int testIdCounter = 0;
		while (iterator.hasNext()) {
			Map<String,String> submissionResult = TEST_RESULT_MAP.get(tcIds.get(testIdCounter));
			Row currentRow = iterator.next();
			short minColIx = currentRow.getFirstCellNum(); // get the first column index for a row
			short maxColIx = currentRow.getLastCellNum(); // get the last column index for a row
			if (currentRow.getRowNum() == 0) {
				for (short colIx = minColIx; colIx < maxColIx; colIx++) { // loop from first to last index
					Cell cell1 = currentRow.getCell(colIx); // get the cell
					headerMap.put(cell1.getStringCellValue(), cell1.getColumnIndex()); // add the cell contents (name of column)
				}
			}
			
			if (!(currentRow.getRowNum() == 0)) {
			System.out.println(currentRow.getRowNum());
			
			headerMap.entrySet().forEach(header -> {
				int cellIndex = header.getValue();
				String headerKey = header.getKey();
				if (currentRow.getCell(cellIndex) == null) {
					currentRow.createCell(cellIndex);
				} if (submissionResult != null && submissionResult.get(header.getKey()) != null) {
					currentRow.getCell(cellIndex).setCellValue(submissionResult.get(header.getKey()));
				} 
				else {
					if (headerKey.equals("Id") || headerKey.equals("SubmissionId") || headerKey.equals("TransactionId")) {
					} else {
						currentRow.getCell(cellIndex).setCellValue("");
					}

				}
			});
			testIdCounter++;
			}
		}
		try {
			fileInputStream.close();
			FileOutputStream output_file =new FileOutputStream(INVOICE_CRAWLER_DATA_SHEET_LOCATION); 
			workbook.write(output_file);
			output_file.close();
		} catch (Exception e) {
			LOGGER.error("Exception while writing results to excel file : {}", e.getMessage());
		}
		
	}
	
	public static Map<String, Map<String, String>> getSheetData(String workBookLocation, String sheetName) {
		LOGGER.info("Getting data of sheet: {} from workbook: {}", sheetName, workBookLocation);
		
		Map<String, Map<String, String>> sheetData = new LinkedHashMap<>();
		
		File inputFile = new File(workBookLocation);
		FileInputStream fileInputStream;
		XSSFWorkbook workbook = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while reading excel workbook : {}", e.getMessage());
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Map<String, Integer> headerMap = new LinkedHashMap<String, Integer>(); // Create map of headers with [name,index] as key value pair
		XSSFRow headerRow = sheet.getRow(0); // Get first row

		short minColIx = headerRow.getFirstCellNum(); // get the first column index for a row
		short maxColIx = headerRow.getLastCellNum(); // get the last column index for a row
		for (short colIx = minColIx; colIx < maxColIx; colIx++) { // loop from first to last index
			XSSFCell cell = headerRow.getCell(colIx); // get the cell
			headerMap.put(cell.getStringCellValue(), cell.getColumnIndex()); // add the cell contents (name of column)
		}

		// getting all headers in a list
		List<String> headerValues = headerMap.keySet().stream().collect(Collectors.toList());
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Map<String, String> rowData = new LinkedHashMap<>();
			if (row.getRowNum() != 0) {
				IntStream.range(0, headerMap.size()).forEach(index -> {
					row.getCell(index, MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellType(CellType.STRING);
					rowData.put(headerValues.get(index), row.getCell(index).getStringCellValue());
				});
				// putting every row's first column value as key and rest as value in key-value
				// pair (colName,colValue)
				sheetData.put(rowData.entrySet().stream().findFirst().get().getValue(), rowData);
			}
		}
		LOGGER.info("Recorded Sheet Data Successfully. : {}", sheetData);
		
		return sheetData;
	}
	
}

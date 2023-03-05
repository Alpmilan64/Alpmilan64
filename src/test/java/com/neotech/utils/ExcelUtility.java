package com.neotech.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {



	private static Workbook book;
	private static Sheet sheet;

	private static void openExcel(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();

			/*
			 *  Step 1 :: This method will create inputStream and it will
			 *  load everything  to this book object  **  book = new XSSFWorkbook(fis);**
			 */
		}
	}

	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
		/*
		 *  This Method will load the sheet how many rows and 
		 *  colums we have and get the DATA from specific place
		 */
	}

	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	private static int colCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}

	private static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	// Return a 2D-Object Array
	public static Object[][] excelIntoArray(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);
		// This will open the Excel and read sheet

		int rows = rowCount();
		int cols = colCount(0);

		// I used row - 1 to skip the header
		Object[][] data = new Object[rows - 1][cols];

		// Iterating rows
		// Started from 1 to skip the header
		for (int row = 1; row < rows; row++) {

			// Iterating columns
			for (int col = 0; col < cols; col++) {

				// Read from excel into 2D-Object Array
				data[row - 1][col] = cellData(row, col);
			}

		}

		// return the object that has been filled
		return data;
	}
    
	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		List<Map<String, String>> list = new ArrayList<>();

		for (int row = 1; row < rowCount(); row++) {
			// for each data row I will create a Map
			Map<String, String> rowMap = new LinkedHashMap<>();

			// fill the Map
			for (int col = 0; col < colCount(row); col++) {
				String key = cellData(0, col);
				String value = cellData(row, col);
				rowMap.put(key, value);
			}

			// add the Map to the list
			list.add(rowMap);
		}

		return list;
	}


}

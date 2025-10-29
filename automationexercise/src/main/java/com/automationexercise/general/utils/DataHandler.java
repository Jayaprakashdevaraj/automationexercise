package com.automationexercise.general.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHandler {
	
//	public static Object[][] getData(String FileName,String sheetName) {
		public static Object[][] getData(String FileName,String sheetName) {
		XSSFWorkbook workbook;
		String[][] data = null;
		try {
			workbook = new XSSFWorkbook("src/main/resources/data/"+FileName+".xlsx");
			//workbook = new XSSFWorkbook("src/main/resources/data/AutomationExerciseTestData.xlsx");
			//XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];
			DataFormatter formatter = new DataFormatter();
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < columnCount; j++) {
					//data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return data;
	}

}
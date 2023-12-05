package com.Titorialasninja.qa.utils;

import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Utilities {
	
	
	
	public static final int IMPLICIT_WAIT_TIME=20;
	
	public static final int PAGE_LOAD_TIME=20;
	
	public static String GenerateEmailWithTimestamp() {
		
		Date date=new Date();	
		String timestamp =date.toString().replace(" ", "_").replace(":", "_");
		return "amtoori"+timestamp+"@gmail.com";
	}

//	public static void getTestDatafromExcel(String sheetName) {
//		
//		String excel_path="C:\\Users\\Rahul Rathore\\eclipse-workspace\\TutorialNinjaProj\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\TotorialsninjaTestData.xlsx";
//		try {
//			
//		FileInputStream fis=new FileInputStream(excel_path);
//		XSSFWorkbook workbook=new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheet(sheetName);
//		int rows=sheet.getLastRowNum();
//		int cols=sheet.getRow(0).getLastCellNum();
//		
//		Object [][] data=new Object[rows][cols];
//		
//		for(int i=0; i<rows; i++) {
//			
//			XSSFRow row=sheet.getRow(i+1);
//			
//			for(int j=0; j<cols; j++) {
//				
//				XSSFCell cell=row.getCell(j);
//				org.apache.poi.ss.usermodel.CellType celltype= cell.getCellType();
//				
//				switch(celltype) {
//				
//				
//				
//				
//				}
//			}
//		}
//		
//		
//		
//		}catch(Throwable e) {
//			
//			e.printStackTrace();
//		}
	

}

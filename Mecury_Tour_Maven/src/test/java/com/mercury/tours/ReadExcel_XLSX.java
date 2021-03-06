package com.mercury.tours;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel_XLSX {
	
	//private static Sheet ExcelWSheet;
	//private static Workbook ExcelWBook;
	
	private static XSSFSheet ExcelWSheet; //---changes 1 and 2 for xlsx
	private static XSSFWorkbook ExcelWBook;
	
	
	
	//this method is to read the test data from the excel
	
	public String[][] getExcelData(String fileName,String sheetName) throws EncryptedDocumentException, IOException{
		String[][] arrayExcelData = null; // 
		FileInputStream ExcelFile = new FileInputStream(fileName);  //change for xlsx
		ExcelWBook = new XSSFWorkbook(ExcelFile); 
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		
		int totalNoOfRows = ExcelWSheet.getLastRowNum();
		int totalNoOfCols_0 = ExcelWSheet.getRow(0).getLastCellNum();
		arrayExcelData = new String[totalNoOfRows][totalNoOfCols_0]; 
		
		for(int i =0;i< totalNoOfRows;i++){
			int totalNoOfCols = ExcelWSheet.getRow(i).getLastCellNum();
			
			for(int j = 0;j< totalNoOfCols_0;j++){
				arrayExcelData[i][j] = ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		
		System.out.println(arrayExcelData);
		return arrayExcelData;
		
		
		
		
		
	}
	

}

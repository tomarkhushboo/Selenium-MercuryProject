package com.mercury.tours;

import org.testng.annotations.DataProvider;

public class Application_Test_Data {
 //this class is only to hold test data
	
	@DataProvider(name="Login")
	
	public Object[][] getDataFromDataProvider(){
		return new Object[][]{
			{"testing","testing"},
			{"dixit","dixit"},
			{"testabhi","testabhi"},
	
		
	};
}
	
	//-----this is to read excel data---
	
	@DataProvider(name = "LoginDataXLS")
	
	public Object[][] ExcelXls() throws Exception{
		ReadExcel_XLS excel = new ReadExcel_XLS();
		Object[][] testObjArray = excel.getExcelData("C:\\Users\\user1\\Desktop\\khushboo\\Mecury_Tour_Maven\\Mercury_Tours.xls","Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
		
	}
	
//-----this is to read excel data---
	
	@DataProvider(name = "LoginDataXLSX")
	public Object[][] ExcelXlSX() throws Exception{
		ReadExcel_XLSX excel = new ReadExcel_XLSX();
		Object[][] testObjArray = excel.getExcelData("C:\\Users\\user1\\Desktop\\khushboo\\Mecury_Tour_Maven\\FlightTestData.xlsx","TestData");
		System.out.println(testObjArray);
		return testObjArray;	
}
	
}

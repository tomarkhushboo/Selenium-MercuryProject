package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataFromExcel_XLSX extends Application_Test_Data {
	ChromeDriver driver;
	@BeforeTest
	
	public void LaunchApp() {
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\user1\\Desktop\\khushboo\\Mecury_Tour_Maven\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "LoginDataXLSX")
	public void LoginApp(String uname ,String password) throws Exception{
		 driver.findElement(By.linkText("SIGN-ON")).click();
		 driver.findElement(By.name("userName")).sendKeys(uname);
		 driver.findElement(By.name("password")).sendKeys(password);
		 driver.findElement(By.name("login")).click();
		 Thread.sleep(9000);
		 driver.findElement(By.linkText("SIGN-OFF")).click();
		 
	}
	

}

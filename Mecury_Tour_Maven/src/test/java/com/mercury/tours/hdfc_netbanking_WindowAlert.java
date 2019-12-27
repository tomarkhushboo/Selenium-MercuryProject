package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class hdfc_netbanking_WindowAlert  {
	ChromeDriver driver; // global variable

		@BeforeTest //predefined

		public void LaunchBrowser(){
			
			 //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			String absolutePath = System.getProperty("user.dir");
			String filePath = absolutePath+"\\Drivers"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filePath);
			
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://netbanking.hdfcbank.com/netbanking/");

	}
		
		@Test
		
		public void hdfc_login() throws InterruptedException{
			
//			driver.switchTo().frame("login_page");
//			//driver.switchTo().frame("#0");
//			WebElement userName = driver.findElement(By.cssSelector("input[name ='fldLoginUserId']"));
//			userName.sendKeys("1000");
//			WebElement btn = driver.findElement(By.xpath("//img[@src ='/gif/continue_new1.gif?v=1']"));
//			btn.click();
//			
//			Thread.sleep(3000);
//			//driver.switchTo().defaultContent();
//			
//			//driver.switchTo().frame("login_page");
//			WebElement pass = driver.findElement(By.cssSelector("input[ name = 'fldPassword']"));
//			pass.sendKeys("Test@1");
			
			driver.switchTo().frame("login_page");
			WebElement btn = driver.findElement(By.xpath("//img[@src ='/gif/continue_new1.gif?v=1']"));
			btn.click();
			String Act = driver.switchTo().alert().getText();
			String Exp = ("Customer ID  cannot be left blank.");
			Assert.assertEquals(Act, Exp);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
			
			
			
			
			
		}
		

}

package com.mercury.tours;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Mercury_SignOn_ScreenShotEx {
	
	WebDriver driver;
	String absolutePath = System.getProperty("user.dir");
	String filePath = absolutePath+"\\ScreenShot";
	
@Test	
public void Sign_on_Sucessful_login() {
		
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	 driver.findElement(By.linkText("SIGN-ON")).click();
	 driver.findElement(By.name("userName")).sendKeys("testing");
	 driver.findElement(By.name("password")).sendKeys("testing");
	 driver.findElement(By.name("logins")).click();
	
		
	} 		

@AfterMethod

public void teardown(ITestResult result) throws IOException{
	if(ITestResult.FAILURE == result.getStatus()){
		File Browsersceenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(Browsersceenshot,new File("C:\\Users\\user1\\Desktop\\khushboo\\Mecury_Tour_Maven\\ScreenShot\\error.png"));
		FileUtils.copyFile(Browsersceenshot,new File(filePath +"/"+result.getName()+"_"+System.nanoTime()));
	
	}
	
	driver.quit();
	
}

		

	

}

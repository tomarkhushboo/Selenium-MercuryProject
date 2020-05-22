package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


public class Parameter_TestNG_XML {

	WebDriver driver; // global variable

	@Test	
	@Parameters({"uname","upass"})
	public void Login(String uname,String upass) {


		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(upass);
		driver.findElement(By.name("login")).click();
	} 		

	@BeforeTest //predefined

	public void LaunchBrowser(){

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		//String absolutePath = System.getProperty("user.dir");
		//String filePath = absolutePath+"\\Drivers"+"\\chromedriver.exe";
		//System.setProperty("webdriver.chrome.driver", filePath);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");


	}

	@AfterTest //post defined

	public void closeBrowser(){
		driver.quit();
	}

}
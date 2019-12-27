package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Headless_Browser {
	ChromeDriver driver;
	ChromeOptions options ; //to change any configuration option is used

	
	
  @Test
  public void Sign_On() {
	  
	  driver.findElement(By.linkText("SIGN-ON")).click();
		 driver.findElement(By.name("userName")).sendKeys("testing");
		 driver.findElement(By.name("password")).sendKeys("testing");
		 driver.findElement(By.name("login")).click();
  }
  @BeforeTest
  public void LaunchBrowser() {
	  options = new ChromeOptions();
	  options.setHeadless(false);
	  //incognit mode set hadless false
	  options.addArguments("incognito");
	  String absolutePath = System.getProperty("user.dir");
		String filePath = absolutePath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
}

  @AfterTest
  public void CloseBrowser() {
		driver.quit();
  }

}

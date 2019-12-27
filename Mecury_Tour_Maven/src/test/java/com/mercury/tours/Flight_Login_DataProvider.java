package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flight_Login_DataProvider extends Application_Test_Data {
	
	ChromeDriver driver;
	

@Test(dataProvider = "Login")
public void Sign_on(String uname, String password){
	
	//driver.get(url);
	driver.findElement(By.linkText("SIGN-ON")).click();
	driver.findElement(By.name("userName")).sendKeys(uname);
	driver.findElement(By.name("password")).sendKeys(uname);
	driver.findElement(By.name("login")).click();
	driver.findElement(By.linkText("SIGN-OFF")).click();
	
}

@BeforeTest //predefined

public void LaunchBrowser(){
	
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	}
}

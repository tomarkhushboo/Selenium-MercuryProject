package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Mercury_Sign_On_GetText {
	
@Test	
public void Sign_on_Sucessful_login() throws InterruptedException{
		
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 ChromeDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	 driver.findElement(By.linkText("SIGN-ON")).click();
	 driver.findElement(By.name("userName")).sendKeys("testing");
	 driver.findElement(By.name("password")).sendKeys("testing");
	 driver.findElement(By.name("login")).click();
	 Thread.sleep(6000);
	 
	 //validate actual and expected sing off page
	
	 WebElement element = driver.findElement(By.linkText("SIGN-OFF"));
	 String actValue = element.getText();
	 String expeValue = "SIGN-OFF";
	 System.out.println("current text: " +actValue);
	 Assert.assertEquals(actValue, expeValue);
	 
	 
	 //validate expected and current url
	 
	 String expUrl = "http://newtours.demoaut.com/mercuryreservation.php";
	 String actUrl = driver.getCurrentUrl();
	 System.out.println("current  url: " +actUrl);
	 Assert.assertEquals(actUrl, expUrl);
	 
	 //validate the title of current page
	 
	 String expTitle = "Find a Flight: Mercury Tours:";
	 String actTilte = driver.getTitle();
	 System.out.println("current page title: " +actTilte);
	 Assert.assertEquals(actTilte, expTitle);
	 element.click();
	 driver.quit();
		} 		
		

	

}

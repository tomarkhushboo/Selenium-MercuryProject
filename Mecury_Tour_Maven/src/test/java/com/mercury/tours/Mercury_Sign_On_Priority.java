package com.mercury.tours;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_Sign_On_Priority {
	ChromeDriver driver; // global variable
	

	
	@BeforeTest //predefined

	public void LaunchBrowser(){
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		}
	
	//login page
	
	 @Test(priority =1)
	public void Sign_on_Sucessful_login() throws InterruptedException{
		

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
	// element.click();
	 
	 //to verify whether round trip selected or not
	 
	 String Radio1 = driver.findElement(By.xpath("//input[@value = 'roundtrip']")).getAttribute("checked");
	 
	 if(Radio1.equalsIgnoreCase("true")){
		 System.out.println("RoundTrip Selected");
	 }
	 }
	 
	 //----------------selecting flight from depart page-----------------------------------
	 
	 @Test(priority =2)
	 
	 private void SearchFlight() throws InterruptedException {
		 
		 WebElement Radio = driver.findElement(By.xpath("//input[@value = 'oneway']"));
		 Radio.click();
		Assert.assertEquals(Radio.isSelected(), true);
		Thread.sleep(1000);
		
		//validate dropdown 
		
		Select selectPass = new Select(driver.findElement(By.name("passCount")));
		selectPass.selectByValue("4");
		
		Select SelectDep = new Select(driver.findElement(By.name("fromPort")));
		SelectDep.selectByValue("London");
		
		Select selectArr = new Select(driver.findElement(By.name("toPort")));
		selectArr.selectByValue("Paris");
		
	    //to validate business class
		
		WebElement busiRadio = driver.findElementByCssSelector("input[value='Business']");
		busiRadio.click();
		Assert.assertEquals(busiRadio.isSelected(), true);
		
		Select selectAir = new Select(driver.findElement(By.name("airline")));
		selectAir.selectByVisibleText("Blue Skies Airlines");
		
		Thread.sleep(2000);
		
		WebElement but = driver.findElement(By.name("findFlights"));
		but.click();
	 }
			
			
	
	 
	
	//--------------to validate depart page---------------------------
	 
	 @Test(priority = 3)
	 
	
private void DepartPage() {
	WebElement depart = driver.findElementByXPath("//td[@class = 'title']//font[contains(text(),'DEPART')]");
	String act = depart.getText();
	System.out.println(depart.getText());
	Assert.assertEquals("DEPART", act);
		
	}


@AfterTest //post defined

private void closeBrowser() {
	driver.quit();
	
} 		
		

	

}

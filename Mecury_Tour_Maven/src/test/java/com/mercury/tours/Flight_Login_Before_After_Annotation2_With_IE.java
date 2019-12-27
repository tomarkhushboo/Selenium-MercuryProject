//create program using relative path

package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Flight_Login_Before_After_Annotation2_With_IE {
	InternetExplorerDriver driver; // global variable
	
@Test	
public void Sign_on_Sucessful_login() {
		
	 
	 driver.findElement(By.linkText("SIGN-ON")).click();
	 driver.findElement(By.name("userName")).sendKeys("testing");
	 driver.findElement(By.name("password")).sendKeys("testing");
	 driver.findElement(By.name("login")).click();
	 } 		
@BeforeTest //predefined

public void LaunchBrowser(){
	
	 //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	String absolutePath = System.getProperty("user.dir");
	String filePath = absolutePath+"\\Drivers"+"\\IEDriverServer.exe";
	System.setProperty("webdriver.ie.driver", filePath);
	
	 driver = new InternetExplorerDriver();
	 driver.manage().window().maximize();
	 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	 
	 
}

@AfterTest //post defined

public void closeBrowser(){
	driver.quit();
}
		

	

}

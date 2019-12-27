package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sibling_xpath_ex {
	
	WebDriver driver;
	
	@BeforeTest //predefined

	public void LaunchBrowser(){
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		}
	
	@Test
	public void Sign_on() throws InterruptedException{
		driver.navigate().to("http://newtours.demoaut.com/mercuryreservation.php");
		//following sibling
		driver.findElement(By.xpath("//td[@width='67']//following-sibling::td[1]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@width='77']//preceding-sibling::td[1]/a")).click();
	}

}

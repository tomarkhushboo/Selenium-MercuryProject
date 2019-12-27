package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mouse_hover_Action  {
	ChromeDriver driver; // global variable

		@BeforeTest //predefined

		public void LaunchBrowser(){
			
			 //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			String absolutePath = System.getProperty("user.dir");
			String filePath = absolutePath+"\\Drivers"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filePath);
			
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://www.yatra.com/");

	}
		
		@Test
		
		public void mouse_hover_action() throws InterruptedException{
			
			WebElement element = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.id("signInBtn")).click();
			
		}
		

}

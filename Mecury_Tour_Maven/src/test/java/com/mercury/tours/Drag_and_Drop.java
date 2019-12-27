package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Drag_and_Drop  {
	ChromeDriver driver; // global variable

		@BeforeTest //predefined

		public void LaunchBrowser() throws InterruptedException{
			
			 //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			String absolutePath = System.getProperty("user.dir");
			String filePath = absolutePath+"\\Drivers"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filePath);
			
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
			 Thread.sleep(5000); //wait for 5 sec 

	}
		
		@Test
		
		public void mouse_hover_action() throws InterruptedException{
			
			//find element to be draged
			WebElement drag = driver.findElement(By.id("draggable"));
			//find element to be droped
			WebElement drop = driver.findElement(By.id("droppable"));
			Actions action = new Actions(driver);
			action.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(5000);
			driver.quit();
			
			
		}
		

}

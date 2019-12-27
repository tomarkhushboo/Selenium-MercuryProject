package com.mercury.tours;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Navigate_All_links  {
	ChromeDriver driver; // global variable

		@BeforeTest //predefined

		public void LaunchBrowser(){
			 
			 //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			String absolutePath = System.getProperty("user.dir");
			String filePath = absolutePath+"\\Drivers"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filePath);
			
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://www.google.co.in");

	}
		
		@Test
		
		public void navigateToAllLinks() throws InterruptedException{
			
			List<WebElement> linksize = driver.findElements(By.tagName("a")); //all the links
			int linkcount = linksize.size(); //size of the links
			System.out.println(linkcount);
			String[] links = new String[linkcount];
			System.out.println("Total no of links Available: " +linkcount); //print all the links
			
			for(int i = 0;i<linkcount;i++){
				links[i] = linksize.get(i).getAttribute("href");
				System.out.println(links[i]);
			} // gets the href (url) of each index and store it to links string array
			
			//navigate to each links in webpage and get title of that link
			
			for(int i =0; i<linkcount;i++){
				driver.navigate().to(links[i]);
				System.out.println(driver.getTitle());
				driver.navigate().back();
			}
			
			driver.close();
			
			
			
		}
		

}

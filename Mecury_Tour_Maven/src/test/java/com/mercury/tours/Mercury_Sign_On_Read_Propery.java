package com.mercury.tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mercury_Sign_On_Read_Propery {
	
@Test	
public void Sign_on_Sucessful_login() throws IOException {
		
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\user1\\Desktop\\khushboo\\Mecury_Tour_Maven\\chromedriver.exe");
	 ChromeDriver driver = new ChromeDriver();
	 
	 File file = new File("C:\\Users\\user1\\Desktop\\khushboo\\Mecury_Tour_Maven\\Mercury_tours.properties");
	Properties prop = new Properties();
	 FileInputStream fileInput = new FileInputStream(file);
	 prop.load(fileInput);
	 
	 
	 driver.manage().window().maximize();
	 driver.get(prop.getProperty("URL"));
	 driver.findElement(By.linkText(prop.getProperty("lsignon"))).click();
	 driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys("testing");
	 driver.findElement(By.name(prop.getProperty("Inuserpass"))).sendKeys("testing");
	 driver.findElement(By.name("login")).click();
	 driver.quit();
		
	} 		
		

	

}

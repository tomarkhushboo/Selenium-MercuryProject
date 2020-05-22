package com.mercury.tours;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_Sign_On_Using_RobotClass {
	
WebDriver driver;

@BeforeTest //predefined

public void LaunchBrowser(){
	
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	driver.get("https://gofile.io/?t=uploadFiles");
	}

	
@Test
	public void testUpload() throws InterruptedException {

		String absolutePath = System.getProperty("user.dir");
		String filePath = absolutePath+"\\Images\\preassesment result.png";
		System.out.println(filePath);
		//driver.navigate().refresh();
		driver.findElement(By.id("btnChooseFiles")).click();
		uploadFile(filePath);
		Thread.sleep(6000);
		}
	
	public static void uploadFile(String fileLocation){
		try {
			
			//upload file through robot Api
			
			StringSelection ss = new StringSelection(fileLocation);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			//native key stroke for  ctrl , v , enter keys
			
			Robot robo = new Robot();
			robo.delay(1000);
			
			//press ctrl + v
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			
			// release ctrl + v
			
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_V);
			
			//press enter
			
			robo.delay(1000);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			robo.delay(1000);
			
			
			
			
			
		} catch (Exception exp) {
			// TODO: handle exception
			exp.printStackTrace();
		}
	}
	
	@AfterTest //post defined

private void closeBrowser() {
	driver.quit();		
		

	

}
}
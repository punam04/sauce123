package com.SauceDemo.TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.SauceDemo.POMClasses.LoginPagePOMClass;
import com.SauceDemo.utilityClass.ScreenShotClass;

public class TestBaseClass 
{
	 public WebDriver driver;

	 Logger log=Logger.getLogger("SauceDemoProject2");
	 
	 @Parameters ("browserName")
	 @BeforeMethod
	public void setUp( String browserName) throws IOException 
	
	{
		 if(browserName.equals("Chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver","./DriverFiles\\chromedriver.exe");	

			 driver=new ChromeDriver();
			 
			 PropertyConfigurator.configure("log4j.properties");
			log.info("browser is opened");
	
		 }
		 else
		 {
			 System.setProperty("webdriver.gecko.driver","./DriverFiles\\geckodriver.exe");	

			 driver=new FirefoxDriver();
			log.info("browser is opened");
	 
	 }
		
			
		 
		driver.manage().window().maximize();
		log.info("browser is maximized");

		driver.get("https://www.saucedemo.com/");
		log.info("sauceDemo URL IS opened");
		
		ScreenShotClass.TakescreenshotMethod("browserName", driver);
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login page find and action perform
		LoginPagePOMClass x=new LoginPagePOMClass(driver);
		
		
		x.SendUsername();
		log.info("username is entered");
		
		x.sendPassword();
		log.info("password is entered");
		
		x.LoginButtonClick();
		log.info("clicked on loginbutton");
		
		ScreenShotClass.TakescreenshotMethod("saucedemologinpage",driver);
	}
	@AfterMethod
	public void tearDown()
	{
	   driver.close();
		log.info("broser is closed");
	}
}

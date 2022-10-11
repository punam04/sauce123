package com.SauceDemo.TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.LoginPagePOMClass;
import com.SauceDemo.utilityClass.ScreenShotClass;

public class TC01_verifyLoginFunctionality extends TestBaseClass 
{
	

		@Test
		public void verifyLoginFunctionality() throws IOException
		{
		
		System.out.println("apply validation");
		String expectedTitle="Swag Labs";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		ScreenShotClass.TakescreenshotMethod("loginpage", driver);
		
		
		
		
		
		
		
		
		
		}
	}



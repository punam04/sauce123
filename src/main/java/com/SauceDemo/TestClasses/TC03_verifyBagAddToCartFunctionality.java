package com.SauceDemo.TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.HomePOMClass;
import com.SauceDemo.POMClasses.LoginPagePOMClass;
import com.SauceDemo.utilityClass.ScreenShotClass;

public class TC03_verifyBagAddToCartFunctionality extends TestBaseClass
{
	
				
    @Test
	public void verifyBagAddToCartFunctionality() throws InterruptedException, IOException
	{
	HomePOMClass hp=new HomePOMClass(driver);
	

	
	hp.ClickOnAddToCart();
	System.out.println("Bag product selected");
	
	ScreenShotClass.TakescreenshotMethod("addtocartPage", driver);
	
//	validation
	 String ExpectedProduct="1";
	
	String actualProduct=hp.GetTextFromShoppingCart();
	System.out.println("actual product-->"+actualProduct);

	
	
	System.out.println("apply validation");
	
	Assert.assertEquals(actualProduct, ExpectedProduct);
	}  		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}			
	
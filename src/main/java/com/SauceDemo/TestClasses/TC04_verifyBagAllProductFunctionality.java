package com.SauceDemo.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.HomePOMClass;
import com.SauceDemo.utilityClass.ScreenShotClass;


public class TC04_verifyBagAllProductFunctionality extends TestBaseClass 
{
	
    @Test(priority=0, invocationCount=1)
	public void AddAllBagProduct() throws IOException
	{
		HomePOMClass hp=new HomePOMClass (driver);
		hp.clickAllproduct();
		System.out.println("all products are selected");
		ScreenShotClass.TakescreenshotMethod("AllBagProduct", driver);			
	    
		//	validation			
		String ExpectedProduct="6";
		
		String actualProduct=hp.GetTextFromShoppingCart();
		System.out.println("actual product-->"+actualProduct);

		Assert.assertEquals(actualProduct, ExpectedProduct);
		}  
		
	}


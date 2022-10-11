package com.SauceDemo.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClasses.HomePOMClass;
import com.SauceDemo.utilityClass.ScreenShotClass;

public class TC06_VerifyCheckoutFunctionality extends TestBaseClass
{
@Test	
public void verifyCheckoutFunctionality() throws InterruptedException, IOException
{
	HomePOMClass hp=new HomePOMClass(driver);
	
	hp.ClickOnAddToCart();
	hp.ClickOnShoppingCart();
	hp.verifyCheckoutFunctionality();
	hp.SendFirstName();
	hp.SendLastName();
	hp.sendPostalCode();
	hp.ClickOnContinue();
	hp.clickOnFinish();
	ScreenShotClass.TakescreenshotMethod("checkOutpage", driver);
	
	System.out.println("apply validation");
	 String ActualResult=hp.GetTextFromCheckOutCompleted();
	 String ExpectedResult="CHECKOUT: COMPLETE!";
	 
	 Assert.assertEquals(ActualResult, ExpectedResult);
	
}
}

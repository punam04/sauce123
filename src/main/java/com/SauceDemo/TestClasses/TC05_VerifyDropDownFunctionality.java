package com.SauceDemo.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.SauceDemo.POMClasses.HomePOMClass;
import com.SauceDemo.utilityClass.ScreenShotClass;

public class TC05_VerifyDropDownFunctionality extends TestBaseClass
{
	@Test
	public void verifyDropDownFunctionality() throws InterruptedException, IOException
	{
		//	DropDownFunctionality
		HomePOMClass hp=new HomePOMClass (driver);
	    hp.clickOnDropDown();
	     
	    ScreenShotClass.TakescreenshotMethod("DropDownPage", driver);
	     //validation
  System.out.println("apply validation");
  String ActualResult=hp.GetTextFromDropDownOption();
  System.out.println("actual result-"+ActualResult);
  String Expectedresult="Price (high to low)";
	
	Assert.assertEquals(ActualResult, Expectedresult);
}
}
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

public class TC02_VerifyLogoutFunctionality extends TestBaseClass
{
	WebDriver driver;
	@Test
	public void LogoutFunctionality() throws IOException, InterruptedException 
			{
	

			HomePOMClass y=new HomePOMClass(driver);
			
			y.ClickMenuButton();
			y.clicklogoutButton();
			ScreenShotClass.TakescreenshotMethod("saucedemologout",driver);
			
 
	System.out.println("apply  the validation");
	String ExpectedTitle="Swag Labs";
	String ActualTitle=driver.getTitle();
	System.out.println(ActualTitle);
	
	Assert.assertEquals(ActualTitle, ExpectedTitle);
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


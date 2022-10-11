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

public class AllTestCases 
{
	 public WebDriver driver;
		@BeforeMethod
		public void setUp() throws IOException
		
		{
			System.setProperty("webdriver.chrome.driver","C:\\selenium files\\chromedriver.exe");	

			 driver=new ChromeDriver();
			System.out.println("browser is opened");

			driver.manage().window().maximize();
			System.out.println("browser is maximized");

			driver.get("https://www.saucedemo.com/");
			System.out.println("sauceDemo URL IS opened");
			
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//Login page find and action perform
			LoginPagePOMClass x=new LoginPagePOMClass(driver);
			
			
			x.SendUsername();
			System.out.println("username is entered");
			
			x.sendPassword();
			System.out.println("password is entered");
			
			x.LoginButtonClick();
			System.out.println("clicked on loginbutton");
			
			ScreenShotClass .TakescreenshotMethod("saucedemologinpage",driver);
		}
		
		@Test(priority=1)
		public void verifyLoginFunctionality()
		{
		
		System.out.println("apply validation");
		String expectedTitle="Swag Labs";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		}
		
		@Test(priority=2)
		public void LogoutFunctionality() throws IOException, InterruptedException 
				{
		

				HomePOMClass y=new HomePOMClass(driver);
				
				y.ClickMenuButton();
				y.clicklogoutButton();
				ScreenShotClass.TakescreenshotMethod("saucedemologout",driver);
				
	 
		System.out.println("apply  the validation");
		String ExpectedTitle="Swag Labs";
		String ActualTitle=driver.getTitle();
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
				}
		
	    @Test(priority=3)
		public void verifyBagAddToCartFunctionality() 
		{
		HomePOMClass hp=new HomePOMClass(driver);
		

		
		hp.ClickOnAddToCart();
		System.out.println("Bag product selected");
		
		
		
//		validation
		 String ExpectedProduct="1";
		
		String actualProduct=hp.GetTextFromShoppingCart();
		System.out.println("actual product-->"+actualProduct);

		
		System.out.println("apply validation");
		
		Assert.assertEquals(actualProduct, ExpectedProduct);
		}
	    
	    @Test(enabled=false)
		public void AddAllBagProduct()
		{
			HomePOMClass hp=new HomePOMClass (driver);
			hp.clickAllproduct();
			System.out.println("all products are selected");
							
		    
			//	validation			
			String ExpectedProduct="6";
			
			String actualProduct=hp.GetTextFromShoppingCart();
			System.out.println("actual product-->"+actualProduct);

			Assert.assertEquals(actualProduct, ExpectedProduct);
			} 
	    @Test(priority=5)
		public void verifyDropDownFunctionality() throws InterruptedException
		{
			//	DropDownFunctionality
			HomePOMClass hp=new HomePOMClass (driver);
		    hp.clickOnDropDown();
		     
		
		     //validation
	  System.out.println("apply validation");
	  String ActualResult=hp.GetTextFromDropDownOption();
	  System.out.println("actual result-"+ActualResult);
	  String Expectedresult="Price (high to low)";
		
		Assert.assertEquals(ActualResult, Expectedresult);
	}
	    @Test(priority=4)	
	    public void verifyCheckoutFunctionality() throws InterruptedException
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
	    	
	    	System.out.println("apply validation");
	    	 String ActualResult=hp.GetTextFromCheckOutCompleted();
	    	 String ExpectedResult="CHECKOUT: COMPLETE!";
	    	 
	    	 Assert.assertEquals(ActualResult, ExpectedResult);
	    	
	    }
		
		@AfterMethod
		public void tearDown()
		{
		driver.close();
			System.out.println("broser is closed");
		
	}

}

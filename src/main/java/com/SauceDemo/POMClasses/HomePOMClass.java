package com.SauceDemo.POMClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePOMClass 
{
	
//	1.WebDriver driver declare
//	2.element find by @FindBy Annotation
// 3.create a method to perform a action on element
//	4. constructor create
	
//	driver declared
   public static WebDriver driver;
   Select s;
  
//menu button
@FindBy(xpath="//button[@id='react-burger-menu-btn']")
WebElement MenuButton;

public void ClickMenuButton()
{
	MenuButton.click();
}
//logout
@FindBy(xpath="//a[@id='logout_sidebar_link']")
WebElement logoutButton;

public void clicklogoutButton()
{
	logoutButton.click();
}

// create a constructor 
public HomePOMClass(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
s=new Select(dropDown);


}

//dropdown
@FindBy(xpath="//select[@class='product_sort_container']")
private WebElement dropDown;

   
public void clickOnDropDown()
{
	dropDown.click();
	s.selectByValue("hilo");
}

	@FindBy(xpath="//option[@value='hilo']")
	WebElement DropDown;
	
public String GetTextFromDropDownOption() 
{
	
	String DropDownOptions=DropDown.getText();
	return DropDownOptions;
}


//bagAddToCart Element
@FindBy(xpath="(//button[text()='Add to cart'])[1]")
private WebElement AddToCart;

public void ClickOnAddToCart()
{
	AddToCart.click();
}
@FindBy(xpath="//span[@class='shopping_cart_badge']")
WebElement shoppingcart;
 
public void ClickOnShoppingCart()
{
	shoppingcart.click();
}

//checkout
@FindBy(xpath="//button[@id='checkout']")
WebElement CheckoutButton;

public void verifyCheckoutFunctionality()
{
	CheckoutButton.click();
}

//Firstname
@FindBy(xpath="//input[@id='first-name']")
WebElement FirstName;

public void SendFirstName()
{
	FirstName.sendKeys("Hersh");
}

//last name

@FindBy(xpath="//input[@id='last-name']")
WebElement LastName;

public void SendLastName()
{
	LastName.sendKeys("mesh");
}

//postal code
@FindBy(xpath="//input[@id='postal-code']")
WebElement PostalCode;

public void sendPostalCode()
{
	PostalCode.sendKeys("442001");
}

//checkout continue 

@FindBy(xpath="//input[@id='continue']")
WebElement Continue;

public void ClickOnContinue()
{
	Continue.click();
	
}

//Finish button
@FindBy(xpath="//button[text()='Finish']")
WebElement Finish;

public void clickOnFinish()
{
	Finish.click();
}

//apply validation 
@FindBy(xpath="//span[text()='Checkout: Complete!']")
WebElement checkoutValidation;

public String GetTextFromCheckOutCompleted()
{
	String CheckoutCompleted=checkoutValidation.getText();
	return CheckoutCompleted;
}


//Shopping Cart
@FindBy(xpath="//a[@class='shopping_cart_link']")
 WebElement ShoppingCart;

public String GetTextFromShoppingCart()
{
	String totalProducts=ShoppingCart.getText();
	return totalProducts;
	
}
//multiple product element

@FindBy(xpath="//button[text()='Add to cart']")
 List<WebElement> allproducts;


public void clickAllproduct()
{
//	for(int i=0;i<allproducts.size();i++)
//	{
//		allproducts.get(i).click();
//	}
//	or
	for(WebElement i:allproducts)
	{
		i.click();
		
	}

	
	
}


}

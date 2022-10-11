package com.SauceDemo.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOMClass 
{
	
// 1 driver declared
WebDriver driver;
Actions act;

//2 find element
@FindBy(xpath="(//input[@class='input_error form_input'])[1]")
WebElement UserName;

//3 create method as per actin on element
// and add actin in that method
//username
 public void SendUsername()
 {
	 UserName.sendKeys("standard_user");
	 
 }
// password
@FindBy(xpath="(//input[@class='input_error form_input'])[2]")
WebElement Password;

public void sendPassword()
{
	Password.sendKeys("secret_sauce");
}

//loginButton

@FindBy(xpath="//input[@class='submit-button btn_action']")
WebElement login;

public void LoginButtonClick()
{
//	login.click();
	
//or
	act.click(login).perform();
	
}




//create a constructor
public LoginPagePOMClass(WebDriver driver) 
{
this.driver=driver;

// selenium class
PageFactory.initElements(driver, this);
act=new Actions(driver);
















}
 
 
}

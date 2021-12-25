package com.OrangHRM.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(name="txtUsername")
    @CacheLookup
	WebElement username;
	
	@FindBy(name="txtPassword")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(name="Submit")
	@CacheLookup
	WebElement loginbtn;
	
	
	
	
	
	
	public void setUserName(String uname)
	{
		username.sendKeys(uname);
	}
	public void setpassword(String pass)
	{
		txtpassword.sendKeys(pass);
	}
	public void clicksubmit()
	{
		loginbtn.click();
	}
	
	
}




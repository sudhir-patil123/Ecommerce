package com.OrangHRM.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangHRM.PageObject.LoginPage;

public class Tc_LoginTest_002 extends BaseClass {
	
	@Test
	public void LoginDDT() throws InterruptedException, IOException
	{
		System.out.println(driver.getTitle());
		if(driver.getTitle()=="ghhg")
		{
			System.out.println("its Wrong");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setpassword(txtpassword);
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		/*if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			Thread.sleep(3000);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
	}
	private boolean isAlertPresent() {
		// TODO Auto-generated method stub
		return false;*/
	}
}
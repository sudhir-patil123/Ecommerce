package com.OrangHRM.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangHRM.PageObject.LoginPage;


public class Tc_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		System.out.println(driver.getTitle());
		
		//if(driver.getTitle().equals("Guru99 Bank Manager HomePage11343"))
		//{
		//	Assert.assertTrue(true);
		//}
		//else
		//{
		//	captureScreen(driver,"loginTest");
		//	Assert.assertTrue(false);
		//}
		
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		//logger.info("user name provided");
		lp.setpassword(txtpassword);
		lp.clicksubmit();
		
	}
	
	

}




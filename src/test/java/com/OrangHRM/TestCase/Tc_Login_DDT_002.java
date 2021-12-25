package com.OrangHRM.TestCase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangHRM.PageObject.LoginPage;
import com.OrangHRM.Utilities.XLUtils;

public class Tc_Login_DDT_002 extends BaseClass {
	
	 @Test(dataProvider = "LoginData")
	    public void loginData(String user, String pass) {
	        LoginPage lp = new LoginPage(driver);
	        lp.setUserName(user);
	        lp.setpassword(pass);
	        lp.clicksubmit();

	       /* if (isAlertPresent()) {
	            driver.switchTo().alert().accept();     //switch to alert window
	            driver.switchTo().defaultContent();     // focus on main window
	            logger.warn("Login failed");
	            Assert.fail();

	        } else {
	            Assert.assertTrue(true);
	            logger.warn("Login passed");
	            lp.clickLogout();
	            driver.switchTo().alert().accept();
	            driver.switchTo().defaultContent();
	        }*/
	    }

	    @DataProvider(name = "LoginData")
	    Object[][] getData() throws IOException {
	        String path = System.getProperty("user.dir") + "/src/test/java/com/OrangHRM/ExcelData/LoginData1.xlsx";
	        // C:\Users\aksha\eclipse-workspace\iNetBankingV5\src\test\java\test\data\LoginData.xlsx

	        int rowNum = XLUtils.getRowCount(path, "sheet1");
	        int colCount = XLUtils.getCellCount(path, "sheet1", 1);

	        String loginData[][] = new String[rowNum][colCount];

	        for (int i = 1; i <= rowNum; i++) {
	            for (int j = 0; j < colCount; j++) {
	                loginData[i - 1][j] = XLUtils.getCellData(path, "sheet1", i, j);
	            }
	        }
	        return loginData;
	    }
}
package com.OrangHRM.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.OrangHRM.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public static Logger logger;
	
	public String BaseUrl=readconfig.getapplicationUrl();
	public String username=readconfig.getusername();
	public String txtpassword=readconfig.getpassword();
	public static WebDriver driver;
	
	@Parameters("browser") 
	@BeforeClass
	public void setup(String br)
	{
		//logger=Logger.getLogger("OrangHRM");
		//PropertyConfigurator.configure("log4j.properties");
		
		  if(br.equals("chrome"))
		    {
		    	System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
			    driver= new ChromeDriver();
		    }
		    else if(br.equals("firefox"))
		    {
		    	System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
			    driver= new FirefoxDriver();
		    }
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.get(BaseUrl);
		    
		   // logger = Logger.getLogger("project Name");
		  //  PropertyConfigurator.configure("log4j.properties");




		}
	
		//@AfterClass
		//public void tearDown()
		//{
		///	driver.quit();
		//}
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		
	}
		public String randomestring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return(generatedstring);
		}
		
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
	}

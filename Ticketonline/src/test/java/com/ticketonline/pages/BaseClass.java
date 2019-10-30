package com.ticketonline.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ticketonline.utility.BrowserSetup;
import com.ticketonline.utility.ConfigDataProvider;
import com.ticketonline.utility.ExcelDataProvider;
import com.ticketonline.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setupSuit()
	{
		Reporter.log("setting up report & test getting started", true);
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		 
		 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/TOLreport"+Helper.getcurrenttime()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("setting up report & test can be started", true); 
	
	}
	@BeforeClass
	public void setup()
	{
		Reporter.log("browser getting started", true); 
		//driver =  BrowserSetup.startBrowser(driver, config.GetBrowser(), config.getURL());
		driver =  BrowserSetup.startBrowser(driver,"Chrome","https://cards.ticketonline.co.in/");
		Helper.CaptureScreenShot(driver);
		Reporter.log("browser started", true); 
	}
	
	
	@AfterClass
	public void teardown()
	{
		//BrowserSetup.quitbrowser(driver);
	}
	
	
	@AfterMethod
	public void teardownmethod(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.CaptureScreenShot(driver);
			System.out.println("capture on failure");
			try {
				logger.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				logger.pass("test pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			try {
				logger.skip("test pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	report.flush();	
	}
	

}

package com.ticketonline.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ticketonline.pages.BaseClass;
import com.ticketonline.pages.Cardorderhistorypage;
import com.ticketonline.pages.Loginpage;
import com.ticketonline.utility.Helper;

public class Orderhistorysearch extends BaseClass{

	
@Test(priority = 1)
public void Orderhistorysearchtest() throws Exception
{

//ExcelDataProvider excel = new ExcelDataProvider();
          //System.out.println(driver.getTitle());
//-----

logger = report.createTest("login to CRM");
          Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);
          logger.info("Start application");
          loginpage.logintoTOL(excel.getstringdata("Login", 0, 0),excel.getstringdata("Login", 0, 1));
          Thread.sleep(10000);
          
          logger.pass("Login successfull");
          Helper.CaptureScreenShot(driver);
         
          logger = report.createTest("ordrhistory search page");
          Cardorderhistorypage Orderhistorysearchpage = PageFactory.initElements(driver, Cardorderhistorypage.class);
          Orderhistorysearchpage.orderhistory();
          logger.pass("search test case compleated");
          Helper.CaptureScreenShot(driver);
          
          
          
          
          
          
  		
}
}
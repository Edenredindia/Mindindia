package com.ticketonline.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ticketonline.pages.BaseClass;
import com.ticketonline.pages.Cardorderhistorypage;
import com.ticketonline.pages.Loginpage;
import com.ticketonline.utility.Helper;

public class Orderhistorysearch extends BaseClass{

	
@Test(priority = 1)
public void Orderhistorysearchtest()
{

//ExcelDataProvider excel = new ExcelDataProvider();
          //System.out.println(driver.getTitle());
//-----

logger = report.createTest("login to CRM");
          Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);
          logger.info("Start application");
          loginpage.logintoTOL(excel.getstringdata("Login", 0, 0),excel.getstringdata("Login", 0, 1));
          logger.pass("Login successfull");
          Helper.CaptureScreenShot(driver);
          Cardorderhistorypage Orderhistorysearchpage = PageFactory.initElements(driver, Cardorderhistorypage.class);
          Orderhistorysearchpage.orderhistory();
          Helper.CaptureScreenShot(driver);
}
}
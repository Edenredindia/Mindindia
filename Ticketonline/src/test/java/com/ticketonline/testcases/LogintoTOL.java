package com.ticketonline.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ticketonline.pages.BaseClass;
import com.ticketonline.pages.Loginpage;
import com.ticketonline.utility.BrowserSetup;
import com.ticketonline.utility.ExcelDataProvider;
import com.ticketonline.utility.Helper;

public class LogintoTOL extends BaseClass{
	
	
	
@Test(priority = 1)
	public void loginapp()
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
              
	}

@Test(priority = 2)
public void logout()
{

//ExcelDataProvider excel = new ExcelDataProvider();
          //System.out.println(driver.getTitle());

logger = report.createTest("logout tol");
          
          logger.fail("Login successfull");
          
          
}

}

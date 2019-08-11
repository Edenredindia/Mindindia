package com.ticketonline.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSetup {
	
	public static WebDriver startBrowser(WebDriver driver,String BrowserName, String appurl )
	{
		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}
		else if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		else if(BrowserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/iedriverserver.exe");
			driver= new InternetExplorerDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		}
		
		else
		{
			System.out.println("We dont support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(300,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appurl);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		return driver;
	}
	public static void quitbrowser(WebDriver driver)
	   
	   {
		driver.quit();
	   }
	
	

}

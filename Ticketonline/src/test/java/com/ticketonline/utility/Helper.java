package com.ticketonline.utility;



import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	//screen shots, alerts,frames, windows sync issues, java script executer
	public static String CaptureScreenShot(WebDriver driver)
	{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String screenshotpath = System.getProperty("user.dir")+"/Screenshots/TOL"+getcurrenttime()+".png";
			 try {
				FileHandler.copy(src, new File ( screenshotpath));
			} catch (IOException e) {
				System.out.println("print screen fail"+e.getMessage());
			}
			 
			 return screenshotpath;
	}
	public static String getcurrenttime(){
	
		
		DateFormat cutomedate = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentDate = new Date();
		return cutomedate.format(currentDate);
	}
	
	
	
	
	
   
}

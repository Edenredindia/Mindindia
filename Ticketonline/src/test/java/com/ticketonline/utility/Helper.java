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
	
	public static String getdefaultdirectorylocation(){
		
		 String homedir = System.getProperty("user.home");
	        
	        
	        
	        //homedir vaiable used for getting download location
	        String downloadPath = homedir+"\\Downloads\\";
	        System.out.println(downloadPath);
	        return downloadPath;
	        
	    
	}
	
	
	public static File getLatestFilefromDir(String dirPath){
    File dir = new File(dirPath);
    File[] files = dir.listFiles();
    if (files == null || files.length == 0) {
        return null;
    }

    File lastModifiedFile = files[0];
    for (int i = 1; i < files.length; i++) {
       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
           lastModifiedFile = files[i];
       }
    }
    return lastModifiedFile;
    } 

    
	
	public static String getlatestfilename()
    {
	File getLatestFile = getLatestFilefromDir(getdefaultdirectorylocation());
    String fileName = getLatestFile.getName();
	return fileName;
    
	}
	
	
	
	
   
}

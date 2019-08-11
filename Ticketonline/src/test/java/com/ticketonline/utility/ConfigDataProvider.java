package com.ticketonline.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider(){
		File src= new File("./Config/Configuration.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			Properties pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Probelm in config file"+e.getMessage());
		}
	}
	
	



public String getDataFromConfig(String KeyToSearch)
{
	return pro.getProperty(KeyToSearch);
	
}
public String GetBrowser()
{
 //return pro.getProperty("Browser");
	return pro.getProperty("Browser");
}
public String getURL()
{
	return pro.getProperty("produrl");
}
}

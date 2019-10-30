package com.ticketonline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Cardorderhistorypage extends BaseClass{

	
	
	WebDriver Driver;
	
	public Cardorderhistorypage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	@FindBy(xpath = "//a[contains(@href,'/Order/create_order')][text()='Create Order']") WebElement Createorder ;
	@FindBy(xpath = "//a[contains(@href,'/Order/OrderList')][text()='Order Trace']") WebElement Orderhistory ;
	@FindBy(xpath = "//span[@title='Click to view search options']") WebElement Searchplusbutton ;
	@FindBy(xpath = "//input[@id='txtOrderNum']") WebElement OrderNo ;
	@FindBy(xpath = "//select[@class='prelogin_box1_field12'][@id='Month']") WebElement SelectMonth ;
	@FindBy(xpath = "//input[@name='Reset']") WebElement Search ;
	//input[@name='Reset']
	
	//select[@class='prelogin_box1_field12'][@id='Month']
	
	public void orderhistory()
	{
		Orderhistory.click();
		Searchplusbutton.click();
		Select dropdownmonth = new Select (driver.findElement(By.xpath("//select[@class='prelogin_box1_field12'][@id='Month']")));
		dropdownmonth.selectByIndex(1);
		Search.click();
		
		
		
		
	}
	
	
}

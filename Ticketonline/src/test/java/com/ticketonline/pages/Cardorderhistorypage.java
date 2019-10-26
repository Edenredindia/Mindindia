package com.ticketonline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cardorderhistorypage extends BaseClass{

	
	
	WebDriver Driver;
	
	public Cardorderhistorypage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	@FindBy(xpath = "//a[contains(@href,'/Order/create_order')][text()='Create Order']") WebElement Createorder ;
	@FindBy(xpath = "//a[contains(@href,'/Order/OrderList')][text()='Order Trace']") WebElement Orderhistory ;
	@FindBy(xpath = "//span[@class='//span[@title='Click to view search options']") WebElement Searchplusbutton ;
	@FindBy(xpath = "//input[@id='txtOrderNum']") WebElement OrderNo ;
	@FindBy(xpath = "//select[@class='prelogin_box1_field12'][@id='Month']") WebElement SelectMonth ;
	
	//select[@class='prelogin_box1_field12'][@id='Month']
	
	
}

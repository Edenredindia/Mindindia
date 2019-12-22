package com.ticketonline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Orderdetailpage extends BaseClass{

	
	
	WebDriver Driver;
	
	
	public Orderdetailpage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath = "//a[contains(text(),'View Proforma(Normal Invoice)')][@class='heading-logout-text1 left margin-bottom']") WebElement proformainvoice;
}

package com.ticketonline.pages;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ticketonline.utility.Helper;



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
	//@FindBy(xpath = "//a[@title='Click to view order details'][@xpath='1']") WebElement Ordernoselection ;
	@FindBy(xpath = "//a[contains(@href, '/Order/OrderDetail/')][@xpath='1']") WebElement Ordernoselection ;
	@FindBy(xpath = "//a[contains(text(),'View Proforma(Normal Invoice)')][@class='heading-logout-text1 left margin-bottom']") WebElement proformainvoice;
	//@FindBy(xpath = "//a[contains(text(),'View Proforma(Normal Invoice)')]") WebElement proformainvoice;
	
	//a[contains(@href, '/Order/OrderDetail/')][@xpath='1']
	//input[@name='Reset']
	
	//select[@class='prelogin_box1_field12'][@id='Month']
	//a[@class='tooltip'][@xpath='1'] = for orderno selection
	public void orderhistory() throws InterruptedException, Exception
	{
		
		Orderhistory.click();
		Searchplusbutton.click();
		Select dropdownmonth = new Select (driver.findElement(By.xpath("//select[@class='prelogin_box1_field12'][@id='Month']")));
		dropdownmonth.selectByIndex(1);
		Search.click();
		
		Thread.sleep(10000);
		
		Actions act  = new Actions (driver);
		
  		act.moveToElement(driver.findElement(By.xpath("/html/body/div[3]/div[4]/table/tbody/tr[1]/td/div/table[2]/tbody/tr[2]/td[1]/a"))).click().build().perform();
  		
			
  		 
  		proformainvoice.click();
  		Thread.sleep(5000);
  		Orderhistory.click();
  		Thread.sleep(5000);
  		driver.get(Helper.getdefaultdirectorylocation()+""+Helper.getlatestfilename());
  		
  		
  		
  		String Currentlink=driver.getCurrentUrl();
		URL url = new URL(Currentlink);
		InputStream is=url.openStream();
		BufferedInputStream fileParse=new BufferedInputStream(is);
		PDDocument document=null;
		document=PDDocument.load(fileParse);
		String pdfContent= new PDFTextStripper().getText(document);
		System.out.println(pdfContent);

  		
  		
  		
  		
  		
  		
		
	}
	
	
}

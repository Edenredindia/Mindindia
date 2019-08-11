package com.ticketonline.pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

	
	 WebDriver driver;
	public Loginpage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(name = "UserName" ) WebElement uname;
	@FindBy(name = "Password54" ) WebElement pass;
	@FindBy(className = "prelogin_box1_login_button") WebElement login;
	
	
	public  void logintoTOL(String UsernameApplication, String PasswordApplication)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uname.sendKeys(UsernameApplication);
		pass.sendKeys(PasswordApplication);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter captcha");
		String captcha = scan.nextLine();
		
		driver.findElement(By.name("CaptchaValue")).sendKeys(captcha);
		login.click();
		
		
	}
	
	
	


}

package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//page factory - OR -object repostery
	@FindBy(name="userId")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbutton;
	
	// Initialization of page objects 
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	// action performed with webelements
	
	public String validateloginpagetitle() {
		return driver.getTitle();
		
	}
	
	public  HomePage login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
	}
	

}

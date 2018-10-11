package com.pom.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.LoginPage;

public class LoginpageTest extends TestBase{
	LoginPage loginpage;
	
	public LoginpageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initializition();
		loginpage = new LoginPage();
	}
	@Test
	public void logintests() {
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit(); 
	}
	
	

}

package com.pom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pom.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\learning\\POM\\com.learning.pom\\src\\main\\java\\com\\pom\\config\\config.properties");
			prop.load(ip);
		}catch (FileNotFoundException p) {
			p.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
	public static void initializition() throws InterruptedException {
		
		String browsername= prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Apps\\driver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Apps\\driver\\firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else {
			System.out.println("Enter the correct Browser you want to run the tests");
		}
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
		
	}
	
	
	
	

}

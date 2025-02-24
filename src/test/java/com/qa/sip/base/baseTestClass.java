package com.qa.sip.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.sip.factory.DriverFactory;
import com.qa.sip.pages.HomePage;
import com.qa.sip.pages.LoginPage;

public class baseTestClass {

	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginpage;
	protected Properties prop;
	protected HomePage homePage;
	
	@BeforeTest
	public void setup() throws InterruptedException {
	    try {
	        df = new DriverFactory();  // Initializes prop in constructor
	        prop = df.getProp();  // Get initialized properties
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to initialize DriverFactory: " + e.getMessage());
	    }

	    driver = df.initDriver();  // No need to pass prop explicitly
	    loginpage = new LoginPage(driver);
	}



	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

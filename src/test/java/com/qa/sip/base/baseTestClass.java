package com.qa.sip.base;

import java.io.FileNotFoundException;
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
		df = new DriverFactory();
		try {
			prop=df.initProp();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

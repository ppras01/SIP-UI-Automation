package com.qa.sip.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.sip.errors.AppError;
import com.qa.sip.exceptions.BrowserExceptions;

public class DriverFactory {

	WebDriver driver;
	Properties prop;

	public WebDriver initDriver(Properties prop) throws InterruptedException {

		String browserName = prop.getProperty("browser");

		System.out.println("The browser name is: " + browserName);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println(AppError.INVALID_BROWSER_MESSAGE);
			throw new BrowserExceptions("INVALID BROWSER" + browserName);

		}

		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		return driver;
	}

	/**
	 * This method is use to initialise the properties from config file
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public Properties initProp() throws FileNotFoundException {

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config/config.properties");

		if (inputStream == null) {
			throw new FileNotFoundException("config.properties file not found!");
		}

		Properties prop = new Properties();
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}
}

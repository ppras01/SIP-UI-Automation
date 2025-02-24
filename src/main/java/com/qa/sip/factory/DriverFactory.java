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

import com.qa.sip.exceptions.BrowserExceptions;
import com.qa.sip.exceptions.FrameworkException;

public class DriverFactory {

	private WebDriver driver;
	private Properties prop;
	public static String isEleHighLight;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	// Constructor ensures prop is initialized
	public DriverFactory() {
		try {
			this.prop = initProp();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found!", e);
		}
	}

	public WebDriver initDriver() throws InterruptedException {
		if (prop == null) { // Ensure prop is initialized
			throw new IllegalStateException("Properties file is not initialized!");
		}

		String browserName = prop.getProperty("browser");
		if (browserName == null) {
			throw new IllegalStateException("Browser name is missing in properties file!");
		}

		System.out.println("The browser name is: " + browserName);
		isEleHighLight = prop.getProperty("highlight");

		browserOptions browserOptions = new browserOptions(prop);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			tldriver.set(new ChromeDriver(browserOptions.chromeOptions()));
			break;
		case "firefox":
			tldriver.set(new FirefoxDriver(browserOptions.firefoxOptions()));
			break;
		case "edge":
			tldriver.set(new EdgeDriver(browserOptions.edgeOptions()));
			break;
		default:
			throw new BrowserExceptions("INVALID BROWSER: " + browserName);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().window().setSize(new Dimension(1024, 768));
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver(); // getting threadlocal driver and returning it to acheive thread safety
	}

	public static WebDriver getDriver() {

		return tldriver.get();

	}

	private Properties initProp() throws FileNotFoundException {
		Properties prop = new Properties();
		String envName = System.getProperty("env");
		System.out.println("Running the tests on: " + (envName != null ? envName : "default") + " environment");

		InputStream inputStream = null;

		if (envName == null) {
			inputStream = getClass().getClassLoader().getResourceAsStream("config/qa_config.properties");
		} else {
			switch (envName.toLowerCase().trim()) {
			case "qa":
				inputStream = getClass().getClassLoader().getResourceAsStream("config/qa_config.properties");
				break;
			case "prod":
				inputStream = getClass().getClassLoader().getResourceAsStream("config/prod_config.properties");
				break;
			case "preprod":
				inputStream = getClass().getClassLoader().getResourceAsStream("config/preprod_config.properties");
				break;
			default:
				throw new FrameworkException("PLEASE PASS A CORRECT ENVIRONMENT NAME");
			}
		}

		if (inputStream == null) {
			throw new FileNotFoundException("config.properties file not found!");
		}

		try {
			prop.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties file", e);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return prop;
	}

	public Properties getProp() {
		if (prop == null) {
			throw new IllegalStateException("Properties file is not initialized!");
		}
		return prop;
	}
}

package com.qa.sip.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class browserOptions {

	private ChromeOptions co;
	private Properties prop;
	private EdgeOptions ed;
	private FirefoxOptions fo;

	public browserOptions(Properties prop) {
		this.prop = prop;

	}
	
	public ChromeOptions chromeOptions() {
		co=new ChromeOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			co.addArguments("--headless");
			System.out.println("Running chrome in headless mode-----");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			co.addArguments("--incognito");
			System.out.println("Running chrome in incognito mode-----");
		}
		return co;
		
	}
	
	public EdgeOptions edgeOptions() {
		ed=new EdgeOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			ed.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			ed.addArguments("--inPrivate");
		}
		return ed;
		
	}
	
	public FirefoxOptions firefoxOptions() {
		fo=new FirefoxOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			fo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			fo.addArguments("--incognito");
		}
		return fo;
		
	}
	
//	public ChromeOptions chromeOptions() {
//	    co = new ChromeOptions();
//
//	    if (Boolean.parseBoolean(prop.getProperty("headless"))) {
//	        co.addArguments("--headless=new"); // Improved headless mode
//	        System.out.println("Running Chrome in headless mode-----");
//	    }
//	    if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
//	        co.addArguments("--incognito");
//	        System.out.println("Running Chrome in incognito mode-----");
//	    }
//
//	    // Prevent detection as an automated browser
//	    co.addArguments("--disable-blink-features=AutomationControlled");
//	    co.addArguments("--disable-popup-blocking");
//	    co.addArguments("--remote-allow-origins=*");
//	    co.addArguments("--disable-features=SameSiteByDefaultCookies,CookiesWithoutSameSiteMustBeSecure");
//
//	    co.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//	    co.setExperimentalOption("useAutomationExtension", false);
//
//	    return co;
//	}
//	


}

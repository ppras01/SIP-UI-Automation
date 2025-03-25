package com.qa.sip.pages;

import java.sql.Time;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.sip.constants.appConstants;
import com.qa.sip.utilities.ElementUtil;

public class LoginPage {
	private WebDriver driver; // to perform actions, we need driver(need not to initialise in this class)
	ElementUtil ele;
	// private By locators

	private By loginId = By.xpath("//input[@id='username']");
	private By pwd = By.xpath("//input[@id='password']");
	private By termsOfUseLink = By.xpath("//*[@id=\"link-terms-of-use\"]");
	private By loginBtn = By.xpath("//input[@id='kc-login']");
	private By registerLink = By.id("//a[normalize-space()='Register']");
	private By BlackHawkLogo = By.xpath("//img[@id='CustomLogo']");
	private By SIP_text = By.id("LogoPlaceHolder");

	// public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementUtil(driver);

	}

	// public page actions/methods
	public String getPageTitleTest() {
		String loginPageTitle = ele.waitForTitleContainsAndReturn(appConstants.LOGIN_PAGE_TITLE,
				appConstants.DEFAULT_SHORT_TIMEOUT);
		System.out.println("Login Page Title is :" + loginPageTitle);
		return loginPageTitle;
	}

	public String getPageURLTest() {

		String url = ele.waitForURLContainsAndReturn(appConstants.LOGIN_PAGE_PARTIAL_URL,
				appConstants.DEFAULT_SHORT_TIMEOUT);
		System.out.println("Page URL is : " + url);
		return url;
	}

	public boolean isTermsOfUseLinkDisplayed() {
		return ele.waitForElementPresence(termsOfUseLink, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}

	public boolean isLogoExist() {

		return ele.waitForElementPresence(BlackHawkLogo, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();
	}

	//return next page class object if clicking on button navigates to another page
	public HomePage doLogin(String username, String password) throws InterruptedException {
		ele.waitForElementVisible(loginId, appConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(username);
		ele.doSendKeys(pwd, password);
		ele.waitForElementAndClick(loginBtn, appConstants.DEFAULT_MEDIUM_TIMEOUT);
		return new HomePage(driver);
	}
}

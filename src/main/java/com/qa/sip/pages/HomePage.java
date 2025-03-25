package com.qa.sip.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.sip.constants.appConstants;
import com.qa.sip.utilities.ElementUtil;

public class HomePage {

	private WebDriver driver; // to perform actions, we need driver(need not to initialise in this class)
	ElementUtil ele;
	// private By locators

	private By SIPLogo = By.xpath("//img[@class='css-kn46u7']");
	private By FindStoreLink = By
			.xpath("//a[@class='MuiTypography-root MuiTypography-h5 MuiTypography-noWrap css-ox4zjs']");
	private By DiscrepencyLink = By
			.xpath("//a[@class='MuiTypography-root MuiTypography-h5 MuiTypography-noWrap css-11wuo2x']");
	private By LogOutBtn = By.xpath("//button[@aria-label='Logout']//*[name()='svg']");
	private By ResetBtn = By.xpath("//img[@alt='reset']");
	private By SearchBtn = By.xpath("//button[@class='sc-blHHSb ieQNdY']");
	private By SearchMessageText = By.xpath("//p[@class='css-cvonvq']");
	private By DistributnPrtColumn = By.xpath("//div[contains(text(),'Distribution partner')]");
	private By DivisionCodeColumn = By.xpath("//div[contains(text(),'Division code')]");
	private By StoreCodeColumn = By.xpath("//div[contains(text(),'Store code')]");
	private By StoreNameColumn = By.xpath("//div[contains(text(),'Store name')]");
	private By AddressColumn = By.xpath("//div[contains(text(),'Address')]");
	private By StateColumn = By.xpath("//div[contains(text(),'State')]");
	private By CityColumn = By.xpath("//div[contains(text(),'City')]");
	private By ZipColumn = By.xpath("//div[contains(text(),'Zip')]");
	private By Headers = By.xpath("//div[@class='MuiBox-root css-ksg1uk']");
	

	// public constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementUtil(driver);

	}

	public String getHomePageTitleTest() {
		String ActHomePageTitle = ele.waitForTitleContainsAndReturn(appConstants.HOME_PAGE_TITLE,
				appConstants.DEFAULT_SHORT_TIMEOUT);
		return ActHomePageTitle;
	}

	public String getHomePageURLTest() {

		String url = ele.waitForURLContainsAndReturn(appConstants.LOGIN_PAGE_PARTIAL_URL,
				appConstants.DEFAULT_SHORT_TIMEOUT);
		System.out.println("Page URL is : " + url);
		return url;
	}

	public boolean isSipLogoDisplyed() {
		return ele.waitForElementPresence(SIPLogo, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}
	public boolean isResetBtnDisplyed() {
		return ele.waitForElementPresence(ResetBtn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}
	public boolean isDistributnPartnrColumnDisplyed() {
		return ele.waitForElementPresence(DistributnPrtColumn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}

	public boolean isDivisionCodeColumnDisplyed() {
		return ele.waitForElementPresence(DivisionCodeColumn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}

	public boolean isStoreNameDisplyed() {
		return ele.waitForElementPresence(StoreNameColumn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}

	public boolean isStoreCodeColumnDisplyed() {
		return ele.waitForElementPresence(StoreCodeColumn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}

	public boolean isStateColumnDisplyed() {
		return ele.waitForElementPresence(StateColumn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}
	
	public boolean isCityColumnDisplyed() {
		return ele.waitForElementPresence(CityColumn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}
	
	public boolean isZipColumnDisplyed() {
		return ele.waitForElementPresence(ZipColumn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}
	
	public boolean isAddressColumnDisplyed() {
		return ele.waitForElementPresence(AddressColumn, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}
	
	public boolean isDiscrepencyLinkDisplayed() {
		return ele.waitForElementPresence(DiscrepencyLink, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}

	public boolean isFindAStoreLinkDisplayed() {
		return ele.waitForElementPresence(FindStoreLink, appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();

	}
	public List<String> getColumnNameTest() {
		List<WebElement> header = ele.waitForElementsVisible(Headers, appConstants.DEFAULT_SHORT_TIMEOUT);
		List<String> headerList = new ArrayList<>();

		for (WebElement e : header) {
			String text = e.getText();
			headerList.add(text);
		}
		return headerList;
	}

	public int getColumnNameCountTest() {
		int header = ele.waitForElementsVisible(Headers, appConstants.DEFAULT_MEDIUM_TIMEOUT).size();
		return header;
	}
	
	public boolean isLogOutBtnDisplayed() {
		return ele.waitForElementPresence(LogOutBtn,appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();
		
	}
	
	public boolean isSearchBtnDisplayed() {
		return ele.waitForElementPresence(SearchBtn,appConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();
		
	}
 
	public String getHomePageSearchTextTest() {
		String ActHomePageText = ele.waitForElementPresence(SearchMessageText, appConstants.DEFAULT_SHORT_TIMEOUT).getText();
		return ActHomePageText;
	}
}

package com.qa.sip.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.sip.base.baseTestClass;
import com.qa.sip.constants.appConstants;

public class LoginPageTest extends baseTestClass {

	@Test
	public void loginPageTitleTest() {
		String actualtitle = loginpage.getPageTitleTest();
		Assert.assertEquals(actualtitle, appConstants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void loginPageURLTest() {
		String actualurl = loginpage.getPageURLTest();
		Assert.assertTrue(actualurl.contains(appConstants.LOGIN_PAGE_PARTIAL_URL));
	}

	@Test
	public void TermsOfUseLinkDisplayed() {

		Assert.assertTrue(loginpage.isTermsOfUseLinkDisplayed());
	}

	@Test
	public void isLogoExist() {

		Assert.assertTrue(loginpage.isLogoExist());
	}

	@Test(priority = Integer.MAX_VALUE)
	public void loginTest()  {
		try {
			homePage = loginpage.doLogin("johndoe", "abc123");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(homePage.getHomePageTitleTest(), appConstants.HOME_PAGE_TITLE);
	}
}

package com.qa.sip.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.sip.base.baseTestClass;
import com.qa.sip.constants.appConstants;

public class HomePageTest extends baseTestClass {

    @BeforeTest
    public void homePageSetup() {
        if (prop == null) {
            throw new IllegalStateException("Properties file is not initialized in HomePageTest!");
        }

        String userId = prop.getProperty("userid");
        String password = prop.getProperty("password");

        if (userId == null || password == null) {
            throw new IllegalStateException("User ID or Password is missing in properties file!");
        }

        try {
            homePage = loginpage.doLogin(userId, password);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

    @Test
    public void homePageTitleTest() {
        String actualTitle = homePage.getHomePageTitleTest();
        Assert.assertEquals(actualTitle, appConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageURLTest() {
        String actualURL = homePage.getHomePageURLTest();
        Assert.assertTrue(actualURL.contains(appConstants.LOGIN_PAGE_PARTIAL_URL));
    }

    @Test(enabled = false)
    public void columnSizeTest() {
        int columnSize = homePage.getColumnNameCountTest();
        Assert.assertEquals(columnSize, 10);
    }

    @Test(enabled = false)
    public void columnNameTest() {
        List<String> columnNames = homePage.getColumnNameTest();
        Assert.assertNotNull(columnNames, "Column names list is null");
    }

    @Test
    public void homeLogOutBtnTest() {
        Assert.assertTrue(homePage.isLogOutBtnDisplayed(), "Log Out Button is not present");
    }

    @Test
    public void homePageDistributnPrtnerColumnTest() {
        Assert.assertTrue(homePage.isDistributnPartnrColumnDisplyed());
    }

    @Test
    public void homeStoreCodeColumnTest() {
        Assert.assertTrue(homePage.isStoreCodeColumnDisplyed());
    }

    @Test
    public void homePageStoreNameColumnTest() {
        Assert.assertTrue(homePage.isStoreNameDisplyed());
    }

    @Test
    public void homeAddressColumnTest() {
        Assert.assertTrue(homePage.isAddressColumnDisplyed());
    }

    @Test
    public void homePageDivisionCodeColumnTest() {
        Assert.assertTrue(homePage.isDivisionCodeColumnDisplyed());
    }

    @Test
    public void homePageStateColumnTest() {
        Assert.assertTrue(homePage.isStateColumnDisplyed());
    }

    @Test
    public void homePageCityColumnTest() {
        Assert.assertTrue(homePage.isCityColumnDisplyed());
    }

    @Test
    public void homePageZipColumnTest() {
        Assert.assertTrue(homePage.isZipColumnDisplyed());
    }

    @Test
    public void homeSearchBtnTest() {
        Assert.assertTrue(homePage.isSearchBtnDisplayed(), "Search Button is not present");
    }
}

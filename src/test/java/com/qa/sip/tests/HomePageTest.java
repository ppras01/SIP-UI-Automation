package com.qa.sip.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.sip.base.baseTestClass;
import com.qa.sip.constants.appConstants;

public class HomePageTest extends baseTestClass{
	
	@BeforeTest
	public void homePage() {
	
			try {
				homePage= loginpage.doLogin(prop.getProperty("userid"), prop.getProperty("password"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//homepage reference variable from basetest
		
	}
		@Test
		public void homePageTitleTest() {
			String actualtitle = homePage.getHomePageTitleTest();
			Assert.assertEquals(actualtitle, appConstants.HOME_PAGE_TITLE);
		}


		@Test
		public void HomePageURLTest() {
			String actualurl = homePage.getHomePageURLTest();
			Assert.assertTrue(actualurl.contains(appConstants.LOGIN_PAGE_PARTIAL_URL));
		}

		@Test(enabled=false)
		public void ColumnSizeTest() {
			int columnSize=homePage.getColumnNameCountTest();
			Assert.assertEquals(columnSize, 10);
		}
		@Test(enabled=false)
		public void ColumnNameTest() {
			List<String> columnSize=homePage.getColumnNameTest();
			
		}
		@Test
		public void HomeLogOutBtnTest() {
			boolean actualurl = homePage.isLogOutBtnDisplayed();
			Assert.assertTrue(actualurl,"Log Out Button is not present");
		}
		
		@Test
		public void homePageDistributnPrtnerColumnTest() {
			boolean actColumnName=homePage.isDistributnPartnrColumnDisplyed();
			Assert.assertTrue(actColumnName);
		}
		
		@Test
		public void homeStoreCodeColumnColumnTest() {
			boolean actColumnName=homePage.isStoreCodeColumnDisplyed();
			Assert.assertTrue(actColumnName);
		}
		
		@Test
		public void homePageStoreNameColumnTest() {
			boolean actColumnName=homePage.isStoreNameDisplyed();
			Assert.assertTrue(actColumnName);
		}
		
		@Test
		public void homeAddressColumnTest() {
			boolean actColumnName=homePage.isAddressColumnDisplyed();
			Assert.assertTrue(actColumnName);
		}
		
		@Test
		public void homePageDivisionCodeColumnTest() {
			boolean actColumnName=homePage.isDivisionCodeColumnDisplyed();
			Assert.assertTrue(actColumnName);
		}
		
		@Test
		public void homePageStateColumnTest() {
			boolean actColumnName=homePage.isStateColumnDisplyed();
			Assert.assertTrue(actColumnName);
		}
		
		@Test
		public void homePageCityColumnTest() {
			boolean actColumnName=homePage.isCityColumnDisplyed();
			Assert.assertTrue(actColumnName);
		}
		
		@Test
		public void homePageZipColumnTest() {
			boolean actColumnName=homePage.isZipColumnDisplyed();
			Assert.assertTrue(actColumnName);
		}
		
		@Test
		public void HomeSearchBtnTest() {
			boolean actualurl = homePage.isSearchBtnDisplayed();
			Assert.assertTrue(actualurl,"Search Button is not present");
		}
		
}

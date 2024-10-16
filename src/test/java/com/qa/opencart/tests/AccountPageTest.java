package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void AccPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@Test(priority = 1)
	public void accPageTitleTest() {
		String acttitle= accPage.getAccPageTitle();
		Assert.assertEquals(acttitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		
	}
	
	@Test(priority = 2)
	public void accPageUrlTest() {
		String actUrl = accPage.getAccPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.ACCPOUNTS_PAGE_URL_FRACTION_VALUE));
	}
	@Test(priority = 3)
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.tologoutLinkExist());
	}
	@Test(priority = 4)
	public void accPageHeaderstest() {
		List<String> actualAccPageHeadersList = accPage.getAccountHeadersList();
		System.out.println("print actualAccPageHeadersList :" + actualAccPageHeadersList);
		Assert.assertEquals(actualAccPageHeadersList.size(), 4);
	}
	
	
	

}

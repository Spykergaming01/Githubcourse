package com.qa.opencart.tests;


import org.testng.Assert;
import org.testng.annotations.Test;


import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest 
{
	
	@Test(priority = 1)
	public void loginPageTitleTest() 
	{
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle,AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	@Test(priority = 2)
	public void loginPageTUrlTest() {
		String actualUrl = loginPage.getLoginPageUrl();
		
		Assert.assertTrue(actualUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isforgotPwdLinkExist());
	}
	@Test(priority = 4)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.tologoutLinkExist());
	}

}

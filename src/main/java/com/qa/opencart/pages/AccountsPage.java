package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By logoutLink =  By.linkText("Logout");
	private By accsHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
     public String getAccPageTitle() {
    	 String title = eleUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
    	 System.out.println("Acc page title :" + title);
    	 return title;
     }
     public String  getAccPageUrl() {
    	 String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCPOUNTS_PAGE_URL_FRACTION_VALUE);
    	 System.out.println("print Acc url :" + url); 
    	 return url;
      }
     public boolean tologoutLinkExist() {
    	return eleUtil.waitForElementVisible(logoutLink, AppConstants.DEFAULT_MEDIMUM_TIME_OUT).isDisplayed();
    	 
     }
     public boolean isSearchExist() {
     	return eleUtil.waitForElementVisible(search, AppConstants.DEFAULT_MEDIMUM_TIME_OUT).isDisplayed();
     	 
      }
     public List<String>  getAccountHeadersList() {
    	 List<WebElement> accHeadresList = eleUtil.waitForElementsVisible(accsHeaders, AppConstants.DEFAULT_MEDIMUM_TIME_OUT);
    	 List<String> accHeadresValList = new ArrayList<String>();
    	 
    	 for(WebElement e:accHeadresList ) {
    		String text = e.getText();
    		accHeadresValList.add(text);
    		 }
    	 return accHeadresValList;
     }
}

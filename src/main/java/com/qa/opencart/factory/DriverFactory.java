package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * this method is initilaizing the driver on the basis of given browser name
	 * @param browserName
	 * @return this returns the driver
	 */
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser").toLowerCase().trim();
		System.out.println("browser name is:"+ browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firfox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
			
	}
	
  /**
   * this method reading the properties from the .properties file
   * @return
   */
	public Properties intiProp() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
}

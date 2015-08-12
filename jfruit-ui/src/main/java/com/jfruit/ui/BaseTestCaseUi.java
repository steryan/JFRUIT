package com.jfruit.ui;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.jfruit.core.basetest.BaseTestCase;
import com.jfruit.core.config.CoreConfigEnums;

/**
 * BaseTestCaseUi - interaction with webdriver
 */
public class BaseTestCaseUi extends BaseTestCase
{
	
	// Logger for logging to console and file
	static Logger logger = LogManager.getLogger(BaseTestCaseUi.class.getName());
	
	WebDriver driver;
	WebDriverUtility webDriverUtil;
	
	/**
	 * beforeUiSuite
	 * 
	 * @throws IOException
	 */
	@BeforeSuite
	public void beforeUiSuite() throws IOException {
		logger.info("Before UI Suite");

		webDriverUtil = new WebDriverUtility();
		
		//Start browser through WebDriver
		driver = webDriverUtil.getDriver(
				BaseTestCase.getPropertyValue(CoreConfigEnums.BROWSER));
		
	}


	@AfterSuite
	public void afterSuite() {
		logger.info("After UI Suite");
	} 
	
//	public WebDriver getWebDriver(){
//		return this.driver;
//	}
   
}

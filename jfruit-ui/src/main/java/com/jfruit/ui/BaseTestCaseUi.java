package com.jfruit.ui;


import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.jfruit.core.basetest.BaseTestCase;

/**
 * BaseTestCaseUi - interaction with webdriver
 */
public class BaseTestCaseUi extends BaseTestCase
{
	
	// Logger for logging to console and file
	static Logger logger = LogManager.getLogger(BaseTestCaseUi.class.getName());
	
	/**
	 * beforeUiSuite
	 * 
	 * @throws IOException
	 */
	@BeforeSuite
	public void beforeUiSuite() throws IOException {
		logger.info("Before UI Suite");

		// Read the configuration file and load the configuration properties
		//CoreConfigUtil coreConfig = new CoreConfigUtil();
		//coreConfig.loadPropValues(coreConfigPropertiesFile);
		
		//Start browser through WebDriver
	}

	@AfterSuite
	public void afterSuite() {
		logger.info("After UI Suite");
	} 
	
   
}

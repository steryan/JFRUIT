package com.jfruit.core.basetest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jfruit.core.config.CoreConfigEnums;
import com.jfruit.core.config.CoreConfigUtil;

/**
 * BaseTestClass with Before and After suite methods
 * 
 * @author Stephen Ryan
 *
 */
@Test
public class BaseTestCase {

	//String coreConfigPropertiesFile = "jfruit-config.properties";

	static CoreConfigUtil coreConfig = new CoreConfigUtil();

	// Logger for logging to console and file
	static Logger logger = LogManager.getLogger(BaseTestCase.class.getName());

	/**
	 * beforeSuite
	 * 
	 * @throws IOException
	 */
	@Parameters({"config"})
	@BeforeSuite
	public void beforeSuite(@Optional("jfruit-config.properties") String config) throws IOException {
		logger.info("Before suite");

		logger.info("Working Directory = " +
	               System.getProperty("user.dir"));
		
		// Read the configuration file and load the configuration properties
	    logger.info("Loading Configuration Properties File: " + config);
		coreConfig.loadPropValues(config);

	}

	public static String getPropertyValue(CoreConfigEnums configElement) {

		return coreConfig.getPropValue(configElement.toString());
	}

	@AfterSuite
	public void afterSuite() {
		logger.info("After suite");
	}

}

package com.jfruit.application.jfruit_application;

//import junit.framework.Assert;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfruit.core.basetest.BaseTestCase;

/**
 * Hello world!
 *
 */
@Test
public class App extends BaseTestCase {

	// Logger for logging to console and file
	static Logger logger = LogManager.getLogger(App.class.getName());

	@Test
	public static void applicationTest(String[] args) {
		logger.info("Sample Application Test");

		Assert.assertTrue(true);
	}
}

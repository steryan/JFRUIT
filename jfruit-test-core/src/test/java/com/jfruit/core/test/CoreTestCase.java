package com.jfruit.core.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfruit.core.basetest.BaseTestCase;

@Test
public class CoreTestCase extends BaseTestCase {

	// Create a logger to append logs to file or console
	static Logger logger = LogManager.getLogger(CoreTestCase.class.getName());

	@Test
	public void loggingTestPass() {
		logger.info("Entering passing logging test");

		Assert.assertTrue(true);
	}

	// @Test
	// public void loggingTestFail(){
	// logger.info(": Entering fail logging test");
	//
	// Assert.assertTrue(false);
	// }

}

package com.jfruit.core.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * TestLogger to log to test execution status 
 */
public class BaseTestLogger implements ITestListener {

	// Get a log4j logger
	static Logger logger = LogManager.getLogger(BaseTestLogger.class.getName());

	public void onTestStart(ITestResult result) {
		logger.info("TEST START" + result);
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("TEST PASS" + result);
	}

	public void onTestFailure(ITestResult result) {
		logger.error("TEST FAIL: " + result);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn("TEST SKIPPED" + result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.warn("TEST FAILED WITHIN %" + result);

	}

	public void onStart(ITestContext context) {
		logger.info("START SUITE");
	}

	public void onFinish(ITestContext context) {
		logger.info("FINISH SUITE");
	}
}

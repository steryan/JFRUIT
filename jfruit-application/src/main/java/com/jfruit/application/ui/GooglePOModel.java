package com.jfruit.application.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jfruit.core.ui.BaseTestCaseUi;
import com.jfruit.core.ui.WebDriverUtility;

/**
 * Page Object Model for Google Home
 * 
 * @author stepryan
 *
 */
public class GooglePOModel extends BaseTestCaseUi {

	// Log4j console and file logger
	static Logger logger = LogManager.getLogger(GooglePOModel.class.getName());

	// Page identifiers
	private String url = "http://www.google.com";
	private String title = "Google";
	private String inputBoxIdentifier = "q";

	// Page method for loding page
	/**
	 * Open the google home page
	 * 
	 * @param driver
	 */
	public void loadPage(WebDriver driver) {
		logger.info("Loading page: " + url);
		// Navigate to the page
		WebDriverUtility.navigate(driver, url);
	}

	/**
	 * Implements google search functionality
	 * 
	 * @param driver
	 * @param searchString
	 */
	public void search(WebDriver driver, String searchString) {
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name(inputBoxIdentifier));

		// Enter something to search for
		element.sendKeys(searchString);

		// Now submit the form. WebDriver will find the form for us from the
		// element
		element.submit();
	}

}

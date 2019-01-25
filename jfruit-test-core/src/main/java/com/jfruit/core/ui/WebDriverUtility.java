package com.jfruit.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jfruit.core.basetest.BaseTestCase;
import com.jfruit.core.config.CoreConfigEnums;

public class WebDriverUtility {

	/*
	 * Return a WebDriver instance based on the browser
	 *
	 */
	public static WebDriver getDriver(String browser) {

		// WebDriver driver;
		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",BaseTestCase.getPropertyValue(CoreConfigEnums.CHROMEDRIVERLOCATION));
			return new ChromeDriver();
		}

		// If browser not set default to firefox
		return new FirefoxDriver();
	}

	public static void navigate(WebDriver driver, String url) {
		// Open Url
		driver.navigate().to(url);
	}

	public static void waitForPageToLoad(WebDriver driver, final String pageTitle, int timeout) {
		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds
		// TODO: Need to understand this code
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(pageTitle);
			}
		});

	}

	/*
	 * Close the browser
	 * 
	 */
	public static void closeBrowser(WebDriver driver) {

		// Close the browser
		driver.quit();
	}
}

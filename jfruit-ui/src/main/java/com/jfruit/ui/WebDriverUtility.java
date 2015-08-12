package com.jfruit.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility  {

	/* Return a Webdriver instance based on the browser 
	 *
	 */
	public WebDriver getDriver (String browser){

		//WebDriver driver;
		if (browser == "chrome"){
			return new ChromeDriver();
		} 

		// If browser not set default to firefox
		return new FirefoxDriver();
	}

	public void navigate(WebDriver driver, String url) {
		// Open Url
		driver.navigate().to(url);
	}

	public void waitforPageToLoad(WebDriver driver, final String pageTitle, int timeout){
	// Google's search is rendered dynamically with JavaScript.
	// Wait for the page to load, timeout after 10 seconds
	// TODO: Need to understand this code
	(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver d) {
			return d.getTitle().toLowerCase().startsWith(pageTitle);
		}
	});
	
	}


	/* Close the browser
	 * 
	 */
	public void closeBrowser(WebDriver driver){

		//Close the browser
		driver.quit();
	}
}


package com.jfruit.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfruit.core.test.CoreTestCase;

/**
 * Unit test for verifying BaseTestCaseUi
 */
@Test
public class UiTestCase extends BaseTestCaseUi
{
	
	// Create a logger to append logs to file or console
	static Logger logger = LogManager.getLogger(CoreTestCase.class.getName());
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	@Test
    public void UiTestCase( )
    {
		String searchString = "Cheese!";
		
        // Navigate to Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys(searchString);

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        logger.info("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        webDriverUtility.waitForPageToLoad(driver, searchString, 10);

        // Verify Google Search results 
        logger.info("Page title is: " + driver.getTitle());
        
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(searchString));
        
        //Close the browser
        webDriverUtility.closeBrowser(driver);
    }

}

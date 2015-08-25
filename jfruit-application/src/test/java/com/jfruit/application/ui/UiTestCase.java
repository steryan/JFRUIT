package com.jfruit.application.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.jfruit.application.ui.GooglePOModel;
import com.jfruit.core.test.CoreTestCase;
import com.jfruit.ui.BaseTestCaseUi;

/**
 * Exercise Google search functionality
 */
@Test
public class UiTestCase extends BaseTestCaseUi
{
	
	// Create a logger to append logs to file or console
	static Logger logger = LogManager.getLogger(CoreTestCase.class.getName());
	
    /**
     * Open google.com and 
     * Enter a search string in the text box
     * Click the search button 
     * Verify the title of the loaded page
     * @author Stephen Ryan  
     */
	@Test
    public void searchGoogle( )
    {
		logger.info("Starting searchGoogle test");
		//Text to enter in google search text box
		String searchString = "Cheese!";
		
		// Create an instance of the Google Page Object Model
		GooglePOModel googlePOMOdel = new GooglePOModel();
		
		// Load google.com
		googlePOMOdel.loadPage(driver);
		
		// Enter text and hit the search button
		googlePOMOdel.search(driver, searchString);
		        
        //Close the browser
        webDriverUtility.closeBrowser(driver);
        
		logger.info("End searchGoogle test");
    }

}

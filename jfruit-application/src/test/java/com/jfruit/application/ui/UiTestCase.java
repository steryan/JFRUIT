package com.jfruit.application.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.jfruit.application.ui.GooglePOModel;
import com.jfruit.core.test.CoreTestCase;
import com.jfruit.ui.BaseTestCaseUi;

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
    public void searchGoogle( )
    {
		String searchString = "Cheese!";
		
		GooglePOModel googlePOMOdel = new GooglePOModel();
		
		googlePOMOdel.loadPage(driver);
		
		googlePOMOdel.search(driver, searchString);
		        
        //Close the browser
        webDriverUtility.closeBrowser(driver);
    }

}

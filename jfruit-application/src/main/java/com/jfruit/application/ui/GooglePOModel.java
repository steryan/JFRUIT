package com.jfruit.application.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jfruit.ui.BaseTestCaseUi;
import com.jfruit.ui.WebDriverUtility;

public class GooglePOModel extends BaseTestCaseUi{

	private String url = "http://www.google.com";
	private String title = "Google";
	private String inputBoxIdentifier = "q";

	
	public void loadPage (WebDriver driver){
		// Navigate to the page 
		WebDriverUtility.navigate(driver, url);

		//Wait for page to load
//		WebDriverUtility.waitForPageToLoad(driver, title, 30);
	}

	
	public void search(WebDriver driver, String searchString) {
		
	    // Find the text input element by its name
		WebElement element = driver.findElement(By.name(inputBoxIdentifier));
		
	    // Enter something to search for
	    element.sendKeys(searchString);
	    
	    // Now submit the form. WebDriver will find the form for us from the element
	    element.submit();
	    

		
	}

}

package basetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * BaseTestClass with Before and After suite methods 
 * @author Stephen Ryan
 *
 */
@Test
public class BaseTestCase {
	
	//Create a logger to append logs to file or console 
	//TestLogger logger = new TestLogger();
	

	 static Logger logger = LogManager.getLogger(BaseTestCase.class.getName());
	
	/**
	 * beforeSuite 
	 */
	@BeforeSuite
	public void beforeSuite() {
		logger.info("Before suite:");
		
	}
	
	@AfterSuite
	public void afterSuite() {
		logger.info("After suite:");
	}

}

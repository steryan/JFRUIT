package basetest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import logging.TestLogger;

/**
 * BaseTestClass with Before and After suite methods 
 * @author Stephen Ryan
 *
 */
@Test
public class BaseTestCase {
	
	//Create a logger to append logs to file or console 
	TestLogger logger = new TestLogger();
	
	/**
	 * beforeSuite 
	 */
	@BeforeSuite
	public void beforeSuite() {
		
		logger.log("Before suite:");
		
	}
	
	@AfterSuite
	public void afterSuite() {
		logger.log("Before suite:");
	}

}

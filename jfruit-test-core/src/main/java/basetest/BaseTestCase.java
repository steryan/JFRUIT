package basetest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import config.CoreConfigUtil;

/**
 * BaseTestClass with Before and After suite methods
 * 
 * @author Stephen Ryan
 *
 */
@Test
public class BaseTestCase {

	// Create a logger to append logs to file or console
	// TestLogger logger = new TestLogger();

	 //String coreConfigPropertiesFile = "/src/main/resources/config/jfruit-config.properties";
	String coreConfigPropertiesFile = "jfruit-config.properties";

	static Logger logger = LogManager.getLogger(BaseTestCase.class.getName());

	/**
	 * beforeSuite
	 * 
	 * @throws IOException
	 */
	@BeforeSuite
	public void beforeSuite() throws IOException {
		logger.info("Before suite");

		// Read the configuration file and load the configuration properties
		CoreConfigUtil coreConfig = new CoreConfigUtil();
		coreConfig.loadPropValues(coreConfigPropertiesFile);
	}

	@AfterSuite
	public void afterSuite() {
		logger.info("After suite");
	}

}

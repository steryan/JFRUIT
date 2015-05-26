
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import basetest.BaseTestCase;


@Test
public class CoreTestCase extends BaseTestCase{
	
	//Create a logger to append logs to file or console 
	 static Logger logger = LogManager.getLogger(CoreTestCase.class.getName());
	
	@Test
	public void loggingTest(){
		logger.info(": Entering logging test");
		
	}

}

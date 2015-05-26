package logging;


import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * TestLogger to log to Console and to file 
 */
public class TestLogger implements ITestListener {
	
	
	//TODO - -implement using l4j2
	Logger LOGGER = Logger.getLogger("corelogger");	
	

	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}

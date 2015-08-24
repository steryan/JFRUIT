package com.jfruit.core.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Reads properties from the configuration file and makes them accessible from
 * getPropertyValue
 * @author sryan
 */
public class CoreConfigUtil {

	static Logger logger = LogManager.getLogger(CoreConfigUtil.class.getName());
	
	// Configuration store
	static Map<String, String> map = new HashMap<String, String>();

	/*
	 * Read properties from the configuration file and store them in a Map 
	 */
	public void loadPropValues(String propFileName) throws IOException {

		Properties prop = new Properties();

		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(propFileName);
		

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName
					+ "' not found in the classpath");
		}
		
		logger.info("================================");

		logger.info("Loading Configuration Properties");
		
		// load the properties into map for later retrieval
		setPropValue(CoreConfigEnums.BROWSER.toString(),prop.getProperty(CoreConfigEnums.BROWSER.toString()));
		setPropValue(CoreConfigEnums.SSHUSER.toString(),prop.getProperty(CoreConfigEnums.SSHUSER.toString()));
		setPropValue(CoreConfigEnums.SSHPASS.toString(),prop.getProperty(CoreConfigEnums.SSHPASS.toString()));
		setPropValue(CoreConfigEnums.SSHHOST.toString(),prop.getProperty(CoreConfigEnums.SSHHOST.toString()));
		
		logger.info("================================");


	}

	/*
	 * Add a property to the property store
	 */
	private void setPropValue(String propName, String propValue){

		logger.info("Storing: " + propName +": " + propValue);
		map.put(propName, propValue);

	}

	/*
	 * Retrieve a value from the properties store
	 * @return property value
	 */
	public String getPropValue(String propName){
		
		logger.info("Getting :" + propName +": " + map.get(propName));
		return map.get(propName);	
	}	
}

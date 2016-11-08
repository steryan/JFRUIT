# JFRUIT
Java Feature Regression User Iterative Testing Framework

Based on Java - TestNG and Maven. This is a feature regression framework for automating UI and core features.

IMPLEMENTED:

External Configuration: Properties can be passed into the framework through 
			jfruit-test-core/src/main/config/jfruit-config.properties
			
Properties can be accessed through the framework through the enum 
			jfruit-test-core/src/main/java/com/jfruit/core/config/CoreConfigEnums.java

Logging:		Log4j logging, Configuration is available from 
			jfruit-test-core/src/main/config/log4j2.xml
		
WebUI Automation:	BaseTestCaseUi provides WebDriver hook which tests extend to enable WebUi verification 


TODO:			

	1.Add test cases to verify to core to verify functionality
			
	2.Build with sonar/EclEmma-jCoCo

	3.Add TestNG suites to execute tests




BACKLOG:		
	Add docker client to manage containers. 
	
	  

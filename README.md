# JFRUIT
Java Feature Regression User Iterative Testing Framework

Based on Java - TestNG and Maven. This is a feature regression framework for automating UI and core features.

RUNNING:
When running with maven pass the Environment variable testNgSuite containing the suite name
e.g.
testNgSuite=src/test/resources/suites/Ui_Test_Suite.xml

mvn install

mvn test -DargLine="-Dconfig=Ui_Test.properties"jar


When running from TestNG under eclipse specify the properties file in the VM Arguments
VM arguments: -Dconfig=Ui_Test.properties

IMPLEMENTED:

External Configuration: Properties can be passed into the framework through 
			jfruit-test-core/src/main/config/jfruit-config.properties
			
Properties can be accessed through the framework through the enum 
			jfruit-test-core/src/main/java/com/jfruit/core/config/CoreConfigEnums.java

Logging:		Log4j logging, Configuration is available from 
			jfruit-test-core/src/main/config/log4j2.xml
		
WebUI Automation:	BaseTestCaseUi provides WebDriver hook which tests extend to enable WebUi verification 
			When using Chrome browser, chromedriver.exe is required http://chromedriver.chromium.org/downloads
			Set webdriverlocationn in jfruit-test-core/src/main/config/jfruit-config.properties

Docker Client: 		Docker Client Integration


TODO:			

	1.Add test cases to verify to core to verify functionality
			
	2.Build with sonar/EclEmma-jCoCo





BACKLOG:		
	1.Add docker client to manage containers. 

Defects:


	
	  

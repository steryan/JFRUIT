package com.jfruit.core.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfruit.core.basetest.BaseTestCase;
import com.jfruit.core.config.CoreConfigEnums;
import com.jfruit.core.utility.SshClient;

/**
 * Test executing a command via SSHClient
 * @author stepryan
 *
 */
public class SshClientTestCase extends BaseTestCase{
	
	// Create a logger to append logs to file or console
	static Logger logger = LogManager.getLogger(SshClientTestCase.class.getName());

	 /**
     * Test of sendCommand method, of class SSHManager.
     */
  @Test
  public void testSendCommand()
  {
	  
		logger.info("Entering SSH Client Test");

		// Load the configuration from jfruit-config.properties
		String sshUser  = BaseTestCase.getPropertyValue(CoreConfigEnums.SSHUSER);
		String sshPass = BaseTestCase.getPropertyValue(CoreConfigEnums.SSHPASS);
		String sshHost  = BaseTestCase.getPropertyValue(CoreConfigEnums.SSHHOST);

		logger.info("Using SSH User: " + sshUser);
		logger.info("Using SSH Pasword: " + sshPass);
		logger.info("Using SSH Host: " + sshHost);
		
     // Get the OS kernel version
     String command = "uname -r";

     logger.info("Executing remote command: " + command);

     //Connect to remote host
     SshClient instance = new SshClient(sshUser, sshPass, sshHost, "~/.ssh/known_hosts");
     String errorMessage = instance.connect();

     if(errorMessage != null)
     {
        System.out.println(errorMessage);
        Assert.fail();
     }

     String expResult = "3.16.0-43-generic";
     // call sendCommand for each command and the output 
     //(without prompts) is returned
     String result = instance.sendCommand(command);
     // close only after all commands are sent
     instance.close();
     
     // Verify the response matches the expected
     Assert.assertEquals(expResult, result.trim());
  }
}

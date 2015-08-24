package com.jfruit.core.utility;

/* 
 * SSHManager
 * 
 * @author 
 * @version 1.0
 */

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jfruit.core.basetest.BaseTestCase;

public class SshClient
{
	static Logger logger = LogManager.getLogger(BaseTestCase.class.getName());
	private JSch jschSSHChannel;
	private String strUserName;
	private String strConnectionIP;
	private int intConnectionPort;
	private String strPassword;
	private Session sesConnection;
	private int intTimeOut;

	private void doCommonConstructorActions(String userName, 
			String password, String connectionIP, String knownHostsFileName)
	{
		jschSSHChannel = new JSch();

		try
		{
			jschSSHChannel.setKnownHosts(knownHostsFileName);
		}
		catch(JSchException jschX)
		{
			logError(jschX.getMessage());
		}

		strUserName = userName;
		strPassword = password;
		strConnectionIP = connectionIP;
	}

	public SshClient(String userName, String password, 
			String connectionIP, String knownHostsFileName)
	{
		doCommonConstructorActions(userName, password, 
				connectionIP, knownHostsFileName);
		intConnectionPort = 22;
		intTimeOut = 60000;
	}

	public SshClient(String userName, String password, String connectionIP, 
			String knownHostsFileName, int connectionPort)
	{
		doCommonConstructorActions(userName, password, connectionIP, 
				knownHostsFileName);
		intConnectionPort = connectionPort;
		intTimeOut = 60000;
	}

	public SshClient(String userName, String password, String connectionIP, 
			String knownHostsFileName, int connectionPort, int timeOutMilliseconds)
	{
		doCommonConstructorActions(userName, password, connectionIP, 
				knownHostsFileName);
		intConnectionPort = connectionPort;
		intTimeOut = timeOutMilliseconds;
	}

	public String connect()
	{
		String errorMessage = null;

		try
		{
			sesConnection = jschSSHChannel.getSession(strUserName, 
					strConnectionIP, intConnectionPort);
			sesConnection.setPassword(strPassword);
			// UNCOMMENT THIS FOR TESTING PURPOSES, BUT DO NOT USE IN PRODUCTION
			sesConnection.setConfig("StrictHostKeyChecking", "no");
			sesConnection.connect(intTimeOut);
		}
		catch(JSchException jschX)
		{
			errorMessage = jschX.getMessage();
		}

		return errorMessage;
	}

	private void logError(String errorMessage)
	{

		logger.error(errorMessage);
	}

	private void logWarning(String warnMessage)
	{     
		logger.warn(warnMessage);
	}

	public String sendCommand(String command)
	{
		StringBuilder outputBuffer = new StringBuilder();

		try
		{
			Channel channel = sesConnection.openChannel("exec");
			((ChannelExec)channel).setCommand(command);
			InputStream commandOutput = channel.getInputStream();
			channel.connect();
			int readByte = commandOutput.read();

			while(readByte != 0xffffffff)
			{
				outputBuffer.append((char)readByte);
				readByte = commandOutput.read();
			}

			channel.disconnect();
		}
		catch(IOException ioX)
		{
			logWarning(ioX.getMessage());
			return null;
		}
		catch(JSchException jschX)
		{
			logWarning(jschX.getMessage());
			return null;
		}

		return outputBuffer.toString();
	}

	public void close()
	{
		sesConnection.disconnect();
	}

}
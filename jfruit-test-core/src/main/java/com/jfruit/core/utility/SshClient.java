package com.jfruit.core.utility;

/**
 * SSHClient for remote connections
 * @author Stephen Ryan
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

	/**
	 * Create JSch instance 
	 * @param userName
	 * @param password
	 * @param connectionIP
	 * @param knownHostsFileName
	 */
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

	/**
	 *  Connect to remote host on default port
	 * @param userName
	 * @param password
	 * @param connectionIP
	 * @param knownHostsFileName
	 */
	public SshClient(String userName, String password, 
			String connectionIP, String knownHostsFileName)
	{
		doCommonConstructorActions(userName, password, 
				connectionIP, knownHostsFileName);
		intConnectionPort = 22;
		intTimeOut = 60000;
	}

	// Connect to a remote host on a given port
	public SshClient(String userName, String password, String connectionIP, 
			String knownHostsFileName, int connectionPort)
	{
		doCommonConstructorActions(userName, password, connectionIP, 
				knownHostsFileName);
		intConnectionPort = connectionPort;
		intTimeOut = 60000;
	}

	/**
	 * Connect to a remote host on a given port with timeout
	 * @param userName
	 * @param password
	 * @param connectionIP
	 * @param knownHostsFileName
	 * @param connectionPort
	 * @param timeOutMilliseconds
	 */
	public SshClient(String userName, String password, String connectionIP, 
			String knownHostsFileName, int connectionPort, int timeOutMilliseconds)
	{
		doCommonConstructorActions(userName, password, connectionIP, 
				knownHostsFileName);
		intConnectionPort = connectionPort;
		intTimeOut = timeOutMilliseconds;
	}

	/**
	 *  Establish ssh connection
	 * @return error or null
	 */
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

	/**
	 *  Send a command via the SSH connection and return the output
	 * @param command
	 * @return command output
	 */
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

	/**
	 * Close the ssh session
	 */
	public void close()
	{
		sesConnection.disconnect();
	}

}
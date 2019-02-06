package com.jfruit.core.utility;

/**
 * Validate OS type Windows, MAc, Unix, Solaris
 * @author sryan
 *
 */
public class OsValidator {

// Retrieve OS name from host system
private static String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Test OS type
	 * @return True if Windows
	 */
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	/**
	 * Test OS type
	 * @return True if Mac
	 */
	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	/**
	 * Test OS type
	 * @return True if Unix
	 */
	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	/**
	 * Test OS type
	 * @return True if Sun
	 */
	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}

}

package com.jfruit.core.config;

/**
 * Configuration Enums
 * 
 * @author stepryan
 *
 */
public enum CoreConfigEnums {

	// Browser used to run UI tests
	BROWSER {
		@Override
		public String toString() {
			return "browser";
		}
	},
	// User for SSH login
	SSHUSER {
		@Override
		public String toString() {
			return "sshuser";
		}
		// Users password for SSH login
	},
	SSHPASS {
		@Override
		public String toString() {
			return "sshpass";
		}
	},
	// Host to SSH to
	SSHHOST {
		@Override
		public String toString() {
			return "sshhost";
		}
	}
}

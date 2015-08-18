package com.jfruit.core.config;

public enum CoreConfigEnums {

	BROWSER {
		@Override
		public String toString() { return "browser"; }
	},
	SSHUSER{
		@Override
		public String toString() { return "sshuser"; }
	},
	SSHPASS{
		@Override
		public String toString() { return "sshpass"; }
	},
	SSHHOST{
		@Override
		public String toString() { return "sshhost"; }
	}
}

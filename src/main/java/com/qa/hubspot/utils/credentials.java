package com.qa.hubspot.utils;

public class credentials {
	
	

	String appUsername;
	String appPassword;

	public credentials(String appUsername,String appPassword){
		this.appUsername = appUsername;
		this.appPassword = appPassword;
	}

	public String getAppUsername() {
		return appUsername;
	}

	public void setAppUsername(String appUsername) {
		this.appUsername = appUsername;
	}

	public String getAppPassword() {
		return appPassword;
	}

	public void setAppPassword(String appPassword) {
		this.appPassword = appPassword;
	}

}
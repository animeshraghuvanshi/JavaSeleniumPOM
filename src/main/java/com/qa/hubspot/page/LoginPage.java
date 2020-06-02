package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.credentials;

public class LoginPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	//1. Locators - By
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Page Actions
	
	public String getPageTitle(){
		return elementUtil.doGetPageTitle();
	}
	
	public boolean checkSignUpLink(){
		return elementUtil.doIsDsiplayed(signUpLink);
	}
	
	public HomePage doLogin(credentials userCred){
		elementUtil.waitForElementPresent(emailId);
		elementUtil.doSendKeys(emailId, userCred.getAppUsername());
		elementUtil.doSendKeys(password, userCred.getAppPassword());
		elementUtil.doClick(loginButton);
		return new HomePage(driver);
	}
	
	
}



package com.qa.hubspot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	WebDriver driver;
	
	public ElementUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getElement(By locator){
		WebElement element = null;
		try{
		element = driver.findElement(locator);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Some Exception occured while creating webelement....");
		}
		return element;
	}
	
	public String doGetPageTitle(){
		try{
			return driver.getTitle();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Some Exception occured while getting page title....");
		}
		return null;
		
	}
	
	public void doClick(By locator){
		try{
			getElement(locator).click();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Some Exception occured while clicking on the element....");
		}
	}
	
	public void doSendKeys(By locator,String value){
		try{
			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		}
		catch(Exception e){
			System.out.println("Some Exception occured while sending values....");
		}
	}
	
	public boolean doIsDsiplayed(By locator){
		try{
			return getElement(locator).isDisplayed();
		}
		catch(Exception e){
			System.out.println("Some Exception occured while displaying WebElement....");
		}
		return false;
		
	}
	
	public String doGetText(By locator){
		try{
			return getElement(locator).getText();
		}
		catch(Exception e){
			System.out.println("Some Exception occured while getting text....");
		}
		return null;
	}

	public void waitForElementPresent(By locator) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

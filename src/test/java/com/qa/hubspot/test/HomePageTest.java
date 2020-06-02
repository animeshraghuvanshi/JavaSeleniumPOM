package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.utils.credentials;

public class HomePageTest {
	
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	WebDriver driver;
	HomePage homePage;
	credentials userCred;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		
		BasePage basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(userCred);
		Thread.sleep(5000);
		
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title  = homePage.getHomePageTitle();
		System.out.println("Page Title is :" + title);
		Assert.assertEquals(title, "Account Setup | HubSpot");
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		String header = homePage.getHomePageHeader();
		System.out.println("Page Header is:" + header);
		Assert.assertEquals(header, "");
	}
	
	@Test(priority=3)
	public void verifyLoggedInUserAccountName(){
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println("User Account Name is:" + accountName);
		Assert.assertEquals(accountName, "");
	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}

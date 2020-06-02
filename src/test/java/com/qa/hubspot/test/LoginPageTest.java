package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.utils.credentials;

public class LoginPageTest {
	
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	WebDriver driver;
	credentials userCred;
	
	@BeforeTest
	public void setUp(){
		
		BasePage basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new credentials(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() throws InterruptedException{
		Thread.sleep(10000);
		
		String title = loginPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.checkSignUpLink());
	}
	
	@Test(priority=3)
	public void loginTest(){
		loginPage.doLogin(userCred);
	}
	
	//Ex:Negative test data
	@DataProvider
	public Object[][] getLoginInvalidData(){
		Object data [][] = {  {"test176@gmail.com","test"},
							   {"test263@gmail.com","abcd"},
							   {"   "},{"ajsjdfjf"}
							};
		return data;
	}
	
	@Test(priority=4, dataProvider="getLoginInvalidData")
	public void getNegativeTestCase(String username, String pwd){
		userCred.setAppUsername(username);
		userCred.setAppPassword(pwd);
		loginPage.doLogin(userCred);
		
	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}

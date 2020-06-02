package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(String browserName){
		System.out.println("Browser name is:"+ browserName );
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\ChromeDriverNew\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else{
			System.out.println("Browser name"+ browserName +"not found, please enter correct browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
		//driver.get(url);
		return driver;
		
	}
	
	
		public Properties init_properties(){
		prop = new Properties();
		
		String path = null;
		String env = null;
		
		try{
			env = System.getProperty("env");
			if(env.equals("qa")){
				path = "./src/main/java/com/qa/hubspot/config/qa.config.properties";
			}
			else if(env.equals("integration")){
				path = "./src/main/java/com/qa/hubspot/config/integration.config.properties";
			}
		}
		catch(Exception e){
			path = "/src/main/java/com/qa/hubspot/config/config.properties";
		}
		
		
		
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			System.out.println("some issue with config properties...Please correct your config...");
		}
			catch(IOException e){
				e.printStackTrace();
			}
		return prop;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



package com.lao.commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	
	public static Properties properties;
	public static WebDriver driver= null;
	
	Logger logger = Logger.getLogger(CommonFunctions.class);
	
	public Properties loadPropertyFile() throws IOException {
		
		FileInputStream streamReader = new FileInputStream("config.properties");
		properties = new Properties();	
		properties.load(streamReader);
		return properties;
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("Orange HRM test begins");
		logger.info("Loading the property file");
		loadPropertyFile();
		
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverLocation = properties.getProperty("driverlocation");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverLocation);
			logger.info("Launching chrome");
			driver = new ChromeDriver();
		}else{
			System.setProperty("webdriver.gecko.driver", driverLocation);
			logger.info("Launching Firefox");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		logger.info("Navigating to application");
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
	}
	
	@AfterSuite
	public void tearDown() {
		logger.info("Closing browser");
		//driver.quit();
		
	}

}

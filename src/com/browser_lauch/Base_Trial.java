package com.browser_lauch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Trial {
	static WebDriver driver;
	
	public static void browserLaunch(String browserName) {
		if (browserName.equalsIgnoreCase("chrome"));
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	public static void implicitWait (String iWait)  {
		if (iWait.equalsIgnoreCase(iWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	public static void getUrl (String url) {
	   if (url.equalsIgnoreCase(url));
	   driver.get(url);
	}	
	public static void findElement ( String element) {
		
		 
	
	
	

	}
}


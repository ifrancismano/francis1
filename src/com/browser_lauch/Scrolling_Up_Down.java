package com.browser_lauch;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling_Up_Down {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement amazon = driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
		jse.executeScript("arguments[0].scrollIntoView();", amazon); // element
		
		jse.executeScript("window.scrollTo(0,0)"); //top
		
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //bottom
		
		jse.executeScript("window.scrollTo(0,0)"); //top
		 
		jse.executeScript("window.scrollBy(0,4400)"); //coordinates
		
		jse.executeScript("window.scrollBy(0,-2400)"); //coordinates2
		
		jse.executeScript("window.scrollTo(0,0)"); //top
		
		
		
		
		
		
		
		driver.close();		
		
		
		
		
		
		
		
		
		
		
		
	}

}

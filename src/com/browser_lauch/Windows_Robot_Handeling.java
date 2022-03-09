package com.browser_lauch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Windows_Robot_Handeling { 
	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Actions drop = new Actions(driver);
		WebElement bestSeller = driver.findElement(By.linkText("Best Sellers"));
		drop.contextClick(bestSeller).perform();
		try {
			Robot z = new Robot();
			z.keyPress(KeyEvent.VK_DOWN);
			z.keyPress(KeyEvent.VK_ENTER);
			
		WebElement mobile = driver.findElement(By.linkText("Mobiles"));
		drop.contextClick(mobile).perform();
		z.keyPress(KeyEvent.VK_DOWN);
		z.keyPress(KeyEvent.VK_ENTER);
		
		Set<String> allwindows = driver.getWindowHandles();
	    System.out.println("allIds "+allwindows);
	    
		for(String order:allwindows) {	
			driver.switchTo().window(order);
			String title = driver.getTitle();
			System.out.println(title);
		
		List<String> lists = new ArrayList(allwindows);
		driver.switchTo().window(lists.get(0));
		
			
		}
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

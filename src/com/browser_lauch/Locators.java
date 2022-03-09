package com.browser_lauch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		
		WebDriver z = new ChromeDriver();
		z.get("https://www.facebook.com/");
		z.manage().window().maximize();
		String t = z.getTitle();
		System.out.println(t);
		String cu = z.getCurrentUrl();
		System.out.println(cu);
		
		WebElement fbbox1 = z.findElement(By.id("email"));
		fbbox1.sendKeys("francis_i");
        WebElement fbbox2 = z.findElement(By.id("pass"));
        fbbox2.sendKeys("unknown");
        WebElement button = z.findElement(By.name("login"));
        button.click();
        
	}

}

package com.browser_lauch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class X_Path {
	public static void main (String[] args ) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.xpath("//input[@type='text']"));
		login.sendKeys("francis");
		WebElement password = driver.findElement(By.xpath("//input[@name='password' and @type='password']"));
		password.sendKeys("12345678"+Keys.ENTER);
		
		
		
}
}
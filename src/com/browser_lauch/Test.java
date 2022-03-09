package com.browser_lauch;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
		login.click();
		WebElement signin = driver.findElement(By.id("mobile"));
		signin.click();
		signin.sendKeys("9840388576");
		WebElement button = driver.findElement(By.xpath("//a[@class='a-ayg']"));
		button.click();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("otp");
		String s = sc.nextLine();
		WebElement otp = driver.findElement(By.id("otp"));
		otp.click();
		otp.sendKeys(s);
		WebElement verify = driver.findElement(By.xpath("//a[@class='a-ayg']"));
		verify.click();
		
		
		
		
	}
}

package com.browser_lauch;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Weekend_Task {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //driver launch
		driver.get("https://www.google.com/search?q=automation+practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.xpath("//h3[.='Automation Practice']")).click();
		
		Actions act = new Actions(driver); //mouse over
		WebElement category = driver.findElement(By.xpath("(//a[.='Dresses'])[2]"));
		act.moveToElement(category).perform();
		driver.findElement(By.xpath("(//a[.='Evening Dresses'])[2]")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver; //scroll
		WebElement pic = driver.findElement(By.xpath("//img[@itemprop='image']"));
		jse.executeScript("arguments[0].scrollIntoView();", pic );
		driver.findElement(By.xpath("//a[@class='quick-view']")).click();
		
		driver.switchTo().frame(0); //frame
		driver.findElement(By.id("add_to_cart")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
		WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		
		jse.executeScript("arguments[0].scrollIntoView();", cart);//scroll
		act.moveToElement(cart).perform();
		WebElement viewCart = driver.findElement((By.xpath("//div[@class='cart_block block exclusive']")));
		
		File ss = viewCart.getScreenshotAs(OutputType.FILE); //screenshot
		File location = new File("./screenshot/dress.png");
	    try {
			FileUtils.copyFile(ss, location);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

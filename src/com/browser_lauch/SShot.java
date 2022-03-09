package com.browser_lauch;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SShot {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		File tss = new File("./screenshot/pic.png");
		FileUtils.copyFile(ss, tss);
		
		WebElement login = driver.findElement(By.xpath("(//input)[position()=1]"));
		login.sendKeys("francis");
		WebElement pass = driver.findElement(By.xpath("(//input)[last()]"));
		pass.sendKeys("xoxoxoxoxoxo");
		WebElement button = driver.findElement(By.xpath("//button[.='Log In']"));
		button.click();
		Thread.sleep(3000);
		WebElement TS = driver.findElement(By.xpath("//div[@class='gr27e  ']"));
		File ss1 = TS.getScreenshotAs(OutputType.FILE);
		File tss1 = new File("./screenshot/pic2.png");
		FileUtils.copyFile(ss1, tss1);
		
		
		driver.quit();
		
		
	}

}

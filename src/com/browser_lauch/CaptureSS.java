package com.browser_lauch;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CaptureSS {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException  {
		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		WebDriver edge = new EdgeDriver();
		edge.get("https://www.amazon.in/");
		edge.manage().window().maximize();
		edge.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		TakesScreenshot ss = (TakesScreenshot) edge;
		File ts = ss.getScreenshotAs(OutputType.FILE);
		File location = new File("./screenshot/pic1.png");
		FileUtils.copyFile(ts, location);
		
		WebElement boxss = edge.findElement(By.id("navFooter"));
		File ts2 =  boxss.getScreenshotAs(OutputType.FILE);
		File location2 = new File("./screenshot/pic2.png");
		FileUtils.copyFile(ts2, location2);
		
		WebElement elementss = edge.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
		File ts3 =  elementss.getScreenshotAs(OutputType.FILE);
		File location3 = new File("./screenshot/pic3.png");
		FileUtils.copyFile(ts3, location3);
		
		edge.quit();
		
		
		
		
	}

}

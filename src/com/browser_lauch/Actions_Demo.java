package com.browser_lauch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Demo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=automation+practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//mouse over
		driver.findElement(By.xpath("//h3[.='Automation Practice']")).click();
		
		Actions obj = new Actions(driver);
		WebElement dress = driver.findElement(By.xpath("(//a[.='Dresses'])[2]"));
		obj.moveToElement(dress).perform();
	    driver.findElement(By.xpath("(//a[.='Evening Dresses'])[2]")).click();
		
		//drag and drop
		driver.get("http://www.leafground.com/");
		driver.findElement(By.xpath("//img[@alt='drop']")).click();
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
//		obj.clickAndHold(source).perform(); 
//		obj.moveToElement(target).perform();
//		obj.release(target).perform();
		obj.dragAndDrop(source, target).perform();
		WebElement text = driver.findElement(By.xpath("//p[.='Dropped!']"));
		String getText = text.getText();
		System.out.println("Drag and Drop = "+getText);
		
		//drag and drop by
		driver.get("http://www.leafground.com/");
		driver.findElement(By.xpath("//h5[.='Draggable']")).click();
		WebElement source1 = driver.findElement(By.xpath("//p[.='Drag me around']"));
		Point location = source1.getLocation();
		int xValue = location.getX();
		int yValue = location.getY();
		System.out.println("Value of X = "+xValue);
		System.out.println("Value of Y = "+yValue);
		obj.dragAndDropBy(source1, xValue +'1', yValue +'1').perform();
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
	}

}

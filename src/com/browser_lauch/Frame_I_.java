package com.browser_lauch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_I_ {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.id("Click"));
		box1.click();
		String text = box1.getText();
        System.out.println(text);
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame(1);
        driver.switchTo().frame("frame2");
        WebElement box2 = driver.findElement(By.id("Click1"));
        box2.click();
        System.out.println(box2.getText());
        driver.switchTo().defaultContent();
        
//        driver.switchTo().frame(2);
        List<WebElement> fE = driver.findElements(By.id("frame"));
        int totalFrames = fE.size();
        System.out.println("total number of frames "+ totalFrames);




		driver.quit();
	}

}

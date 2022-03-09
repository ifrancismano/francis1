package com.browser_lauch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public  class Demo_Alert {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		WebDriver edge = new EdgeDriver();
		edge.get("http://demo.automationtesting.in/Alerts.html");
		edge.manage().window().maximize();
		edge.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement simpleAlert = edge.findElement(By.xpath("//a[text() = 'Alert with OK ']"));
		simpleAlert.click();
		WebElement button = edge.findElement(By.xpath("//button[@class='btn btn-danger']"));
		button.click();
		Alert accept = edge.switchTo().alert();
		accept.accept();
		
		WebElement confirmAlert = edge.findElement(By.xpath("//a [text()= 'Alert with OK & Cancel ']"));
		confirmAlert.click();
		WebElement button2 = edge.findElement(By.xpath("//button[text()='click the button to display a confirm box ']"));
		button2.click();
		Alert cancel = edge.switchTo().alert();
		cancel.dismiss();
		WebElement text = edge.findElement(By.xpath("//p[text()='You Pressed Cancel']"));
		String gettext = text.getText();
		System.out.println("confirmAlert = "+gettext);
		
		WebElement promptAlert = edge.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
		promptAlert.click();
		WebElement button3 = edge.findElement(By.xpath("//button[@onclick='promptbox()']"));
		button3.click();
		Alert accept1 = edge.switchTo().alert();
		accept1.sendKeys("Francis");
		accept1.accept();
		WebElement text3 = edge.findElement(By.id("demo1"));
		String text4 = text3.getText();
		System.out.println("promptAlert = "+text4);
		
		edge.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

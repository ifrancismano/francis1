package com.browser_lauch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_Demo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		WebElement singleD = driver.findElement(By.id("fruits"));
//		Select dropD = new Select(singleD);                 //single
//		boolean multiple = dropD.isMultiple();
//		 if(multiple == false) {
//			 dropD.selectByIndex(5);
//			 WebElement firstSelectedOption = dropD.getFirstSelectedOption();
//           System.out.println(singleD.getText());
//           System.out.println(firstSelectedOption.getText());
//           dropD.deselectByIndex(5);
//           System.out.println(firstSelectedOption.getText());
//		 }	
//		WebElement multiD = driver.findElement(By.id("superheros")); 
//		Select dropD2 = new Select(multiD);       //multiple
//		boolean multiple2 = dropD2.isMultiple();
//		if (multiple2== true) {
//			int size2 = dropD2.getOptions().size();
//		for (int i=0; i< size2 ; i++) {
//			if(i ==3 || i==4|| i==8||i==10 ) {
//				dropD2.selectByIndex(i);
//			}
//		}
//	}
//		List<WebElement> text = dropD2.getAllSelectedOptions();
//		for (WebElement z:text) {
//			System.out.println(z.getText());
//	}  //
		
//		WebElement program = driver.findElement(By.id("lang"));
//		Select programLang = new Select(program);
//		boolean multiple3 = programLang.isMultiple();
//		if (multiple3 == false ) {
//			programLang.selectByValue("java");
//			WebElement print = programLang.getFirstSelectedOption();
//			System.out.println("selected text "+print.getText());
//			
//			
//		}
		
}
}
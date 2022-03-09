package com.browser_lauch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");	


		WebDriver a =  new ChromeDriver();
		a.get("https://www.oneplus.in/");
		a.manage().window().maximize();
		String op = a.getTitle();
		System.out.println(op);
		
		a.navigate().to("https://www.apple.com/");
		String ap = a.getTitle();
		System.out.println(ap);
		String apUrl = a.getCurrentUrl();
		System.out.println(apUrl);
		
		a.navigate().to("https://www.croma.com/");
		String cr = a.getTitle();
		System.out.println(cr);
		String crUrl = a.getCurrentUrl();
		System.out.println(crUrl);
		
		a.navigate().back();
		a.navigate().back();
		a.navigate().refresh();
		a.close();
		
		



	}

}

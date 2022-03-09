package com.browser_lauch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Web_Table_Test {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement table = driver.findElement(By.id("customers"));
//		System.err.println("Table ");
//		String text = table.getText();
//		System.out.println(text);
		
		List<WebElement> headings = table.findElements(By.tagName("th"));
		System.err.println("headings");
		for (WebElement headings1:headings) {
		String htext = headings1.getText();
		System.out.println(htext);
		}
		List<WebElement> datas = table.findElements(By.tagName("td"));
		System.err.println("data");
		for (WebElement data:datas) {
		String dtext = data.getText();
		System.out.println(dtext);
		}
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.err.println("rows");
		for (WebElement data1:rows) {
		String rtext = data1.getText();
		System.out.println(rtext);
		}
		List<WebElement> row7 = table.findElements(By.xpath("//table[@id='customers']//tr[7]"));
		System.err.println("row7");
		for(WebElement row:row7 ) {
		String text2 = row.getText();	
	    System.out.println(text2);
			
		}
		
		
		
		
		
		
		driver.quit();	

}
}
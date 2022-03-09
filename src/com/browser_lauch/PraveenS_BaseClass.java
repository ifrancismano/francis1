package com.browser_lauch;



	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.InputMismatchException;
	import java.util.List;
	import java.util.Scanner;
	import java.util.Set;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptException;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.NoAlertPresentException;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.NoSuchFrameException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.SessionNotCreatedException;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.TimeoutException;
	import org.openqa.selenium.UnhandledAlertException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriverException;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class PraveenS_BaseClass {
		public static WebDriver driver;
		public static long timeouts=20;
		public static Alert alert;
		public static Select dropDown;
		public static Scanner sc;
		public static Robot a;
		public static Actions builder;
		public static JavascriptExecutor js;
		public static int x;
		public static int y;
		public static void browserLaunch(String browserName) {
			try {
				switch (browserName) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case "firefox":
					System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
					driver= new FirefoxDriver();
				case "edge":
					System.setProperty("webdriver.edge.driver", 
							"./Driver/msedgedriver.exe");
					driver = new EdgeDriver();
				default:
					System.err.println("Undefined Driver Name Please Check it");
					break;
				}
			}
			catch(IllegalStateException e) {
				System.err.println("Please to Check the System.setProperty Line Correctly");
			}
			catch(SessionNotCreatedException e) {
				System.err.println("Please to Check your's driver Version");
				System.err.println(e.getMessage());
			}
			catch(WebDriverException e) {
				System.err.println("Other Selenium Related Exception");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Other Java Related Exception");
				System.err.println(e.getMessage());
			}
			driver.manage().window().maximize();
		}
		public static void enterUrl(String url) {
			try {
				driver.get(url);
			} 
			catch (WebDriverException e) {
				System.err.println("I a from Selenium ==>Please to Check the Entered URL");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("I a from Java ==>Please to Check the Entered URL");
				System.err.println(e.getMessage());
			}
		}
		public static String getTitle() {
			return driver.getTitle();
		}
		public static String getCurrentUrl() {
			return driver.getCurrentUrl();
		}
		public static String getPageSource() {
			return driver.getPageSource();
		}
		public static String getWindowHandle() {
			return driver.getWindowHandle();
		}
		public static Set<String> getWindowHandles() {
			return driver.getWindowHandles();
		}
		public static void close() {
			try {
				driver.close();
			}
			catch(WebDriverException e) {
				System.err.println("I a from Selenium ==>May be the window or Tab is Already Closed");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("I a from Java ==>May be the window or Tab is Already Closed");
				System.err.println(e.getMessage());
			}
		}
		public static void quit() {
			driver.quit();
		}
		public static void Navigation(String moveMent,String url) {
			try {
				switch (moveMent) {
				case "t":
					driver.navigate().to(url);
					break;
				case "b":
					driver.navigate().back();
					break;
				case "f":
					driver.navigate().forward();
					break;
				case "r":
					driver.navigate().refresh();
					break;
				default:
					System.err.println("Undefined MoveMent Performed Please Check it ");
					break;
				}
			}
			catch (WebDriverException e) {
				System.err.println("I a from ==>Please to Check your Navigation Command");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("I am from Java ==>Please to Check your Navigation Command");
				System.err.println(e.getMessage());
			}
		}
		public static WebElement elementFinding(String Locator, String 
				Value) {
			switch (Locator) {
			case "id": {
				return driver.findElement(By.id(Value));
			}
			case "name": {
				return driver.findElement(By.name(Value));
			}
			case "tagName": {
				return driver.findElement(By.tagName(Value));
			}
			case"className": {
				return driver.findElement(By.className(Value));
			}
			case"xpath": {
				return driver.findElement(By.xpath(Value));
			}
			case"link": {
				return driver.findElement(By.linkText(Value));
			}
			case"partialLink": {
				return driver.findElement(By.partialLinkText(Value));
			}
			default:
				System.err.println("Undefined Locator please to Check it");
				break;
			}
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
			}
			catch(TimeoutException e) {
				System.err.println("The GivenTime is Over but the Element is Not to find ");
				System.err.println(e.getMessage());
			}
			catch (WebDriverException e) {
				System.err.println("I a from Selenium ==> May be you do Mistake in your Syntax Please to Check");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("I a from Java ==> May be you do Mistake in your Syntax Please to Check");
				System.err.println(e.getMessage());
			}
			return null;
		}
		public static List<WebElement> elementsFinding(String Locator, 
				String Value) {
			switch (Locator) {
			case "id": {
				return driver.findElements(By.id(Value));
			}
			case "name": {
				return driver.findElements(By.name(Value));
			}
			case "tagName": {
				return driver.findElements(By.tagName(Value));
			}
			case"className": {
				return driver.findElements(By.className(Value));
			}
			case"xpath": {
				return driver.findElements(By.xpath(Value));
			}
			case"link": {
				return driver.findElements(By.linkText(Value));
			}
			case"partialLink": {
				return driver.findElements(By.partialLinkText(Value)); 
			}
			default:
				System.err.println("Undefined Locator please to Check it");
				break;
			}
			return null;
		}
		public static void clear(WebElement element) {
			try {
				element.clear();
			}
			catch(NoSuchElementException e) {
				System.err.println("May be the Element is Not Found");
				System.err.println(e.getMessage());
			}
			catch (WebDriverException e) {
				System.err.println("Other Selenium Related Exception");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Other Java Related Exception");
				System.err.println(e.getMessage());
			}
		}
		public static void click(WebElement element) {
			try {
				element.click();
			}
			catch(NoSuchElementException e) {
				System.err.println("May be the Element is Not Found");
				System.err.println(e.getMessage());
			}
			catch (WebDriverException e) {
				System.err.println("Other Selenium Related Exception");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Other Java Related Exception");
				System.err.println(e.getMessage());
			}
		}
		public static void entertext(WebElement element, String text) {
			try {
				element.sendKeys(text);
			}
			catch(NoSuchElementException e) {
				System.err.println("May be the Element is Not Found");
				System.err.println(e.getMessage());
			}
			catch (WebDriverException e) {
				System.err.println("Other Selenium Related Exception");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Other Java Related Exception");
				System.err.println(e.getMessage());
			}
		}
		public static boolean visibleOrNot(WebElement element) {
			return element.isDisplayed();
		}
		public static boolean selectOrNot(WebElement element) {
			return element.isSelected();
		}
		public static boolean enableOrNot(WebElement element) {
			return element.isEnabled();
		}
		public static void submit(WebElement element) {
			try {
				element.submit();
			}
			catch(NoSuchElementException e) {
				System.err.println("May be the Element is Not Found");
				System.err.println(e.getMessage());
			}
			catch (WebDriverException e) {
				System.err.println("Other Selenium Related Exception");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Other Java Related Exception");
				System.err.println(e.getMessage());
			}
		}
		public static String getText(WebElement element) {
			return element.getText();
		}
		public static void alertBox(String typeOfAlert,String alertText) {
			try {
				switch (typeOfAlert.toLowerCase()) {
				case "simple": {
					alert=driver.switchTo().alert();
					alert.accept();
					break;
				}
				case "confirmAccept": {
					alert=driver.switchTo().alert();
					System.out.println(alert.getText());
					alert.accept();
					break;
				}
				case"confirmDimiss": {
					alert=driver.switchTo().alert();
					alert.dismiss();
					break;
				}
				case "promptAccept": {
					alert=driver.switchTo().alert();
					System.out.println(alert.getText());
					alert.sendKeys(alertText);
					alert.accept();
					break;
				}
				case"promptDismiss": {
					alert=driver.switchTo().alert();
					System.out.println(alert.getText());
					alert.dismiss();
					break;
				}
				default:
					System.out.println("Undefined Alert is to be Switched Please to Check it");
					break;
				}
			}
			catch(UnhandledAlertException e) {
				System.err.println("Please to Handle the Alert First After do Anything");
				System.err.println(e.getMessage());
			}
			catch (NoAlertPresentException e) {
				System.err.println("Please to Confrom The Alert is Present Or Not");
				System.err.println(e.getMessage());
			}
			catch (WebDriverException e) {
				System.err.println("Other Selenium Related Exception");
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Other Java Related Exception");
				System.err.println(e.getMessage());
			}
		}
		public static void frameByIndex(int enterTheIndex) {
			try {
				driver.switchTo().frame(enterTheIndex);
			}
			catch(NoSuchElementException e) {
				System.err.println("May be you're Element is inside the Frame");
				System.err.println(e.getMessage());
			}
			catch(NoSuchFrameException e) {
				System.err.println("Please Check your's Index Value");
				System.err.println(e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception ==> "+e.getMessage());
			}
		}
		public static void frameByString(String enterTheValue) {
			try {
				driver.switchTo().frame(enterTheValue);
			}
			catch(NoSuchElementException e) {
				System.err.println("May be you're Element is inside the Frame");
				System.err.println(e.getMessage());
			}
			catch(NoSuchFrameException e) {
				System.err.println("Please Check your's ID(or)Name Value");
				System.err.println(e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception==>"+e.getMessage());
			}
		}
		public static void frameByWebElement(WebElement 
				enterTheElemnetValue) {
			try {
				driver.switchTo().frame(enterTheElemnetValue);
			}
			catch(NoSuchElementException e) {
				System.err.println("May be you're Element is inside the Frame");
				System.err.println(e.getMessage());
			}
			catch(NoSuchFrameException e) {
				System.err.println("Please Check your's Element Value");
				System.err.println(e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception ==> "+e.getMessage());
			}
		}
		public static void getOutFromFrame(String directOrOneByOne) {
			if(directOrOneByOne.equalsIgnoreCase("direct")) {
				driver.switchTo().defaultContent();
			}
			else if(directOrOneByOne.equalsIgnoreCase("oneByOne")) {
				driver.switchTo().parentFrame();
			}
			else {
				System.err.println("Please to Check Your's Syntax");
			}
		}
		public static void singleDropDownByIndex(WebElement element, int 
				enterTheIndex) {
			try {
				dropDown=new Select(element);
			}
			catch(NoSuchElementException e) {
				System.err.println("Please to Check your's Element Value ==>"+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Java Related Exception ==>"+e.getMessage());
			}
			try {
				dropDown.selectByIndex(enterTheIndex);
			}
			catch(IndexOutOfBoundsException e) {
				System.err.println("Plesae to Check your's Index Value ==>"+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception ==>"+e.getMessage());
			}
		}
		public static void singleDropDownByValue(WebElement element, String 
				enterTheValue) {
			try {
				dropDown=new Select(element);
			}
			catch(NoSuchElementException e) {
				System.err.println("Please to Check your's Element Value ==>"+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Java Related Exception ==>"+e.getMessage());
			}
			try {
				dropDown.selectByValue(enterTheValue);
			}
			catch(Exception e) {
				System.err.println("Java Related Exception ==>"+e.getMessage());
			}
		}
		public static void singleDropDownByVisibleText(WebElement element, 
				String enterTheText) {
			try {
				dropDown=new Select(element);
			}
			catch(NoSuchElementException e) {
				System.err.println("Please to Check your's Element Value ==>"+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Java Related Exception ==>"+e.getMessage());
			}
			try {
				dropDown.selectByVisibleText(enterTheText);
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception ==>"+e.getMessage());
			}
		}
		public static void dropDownFunctions(String selectTheFunction) {
			switch(selectTheFunction) {
			case "getOptions" : {
				List<WebElement> allOptionsintheDropDown = 
						dropDown.getOptions();
				int dropDownSize = allOptionsintheDropDown.size();
				System.out.println("The Size of DropDown is "+dropDownSize);
				System.out.println("All Option In the DropDown is "+allOptionsintheDropDown);
				break;
			}
			case "firstSelect" : {
				WebElement firstSelectedOption = 
						dropDown.getFirstSelectedOption();
				System.out.println(firstSelectedOption.getText());
				break;
			}
			case "allSelect" : {
				List<WebElement> 
				allSelectedOptions=dropDown.getAllSelectedOptions();
				for(WebElement oneByOne : allSelectedOptions ) {
					System.out.println(oneByOne.getText());
				}
				break;
			}
			case "deselectall" : {
				dropDown.deselectAll();
				break;
			}
			default : 
				System.out.println("Undefined Function in the Select Class Please To Check it");
						break;
			}
		}
		public static void multipleDropDownByIndex(String 
				selectOrDeselect,WebElement element) {
			switch(selectOrDeselect) {
			case "selecting" : 
				dropDown=new Select(element);
				boolean isMultipleOrNot=dropDown.isMultiple();
				System.out.println("If the DropDown isMultipelOrNot "+isMultipleOrNot);
				if(isMultipleOrNot==true) {
					int sizeOfOptions = dropDown.getOptions().size();
					System.out.println("The SizoOfOptions "+sizeOfOptions);
					for(int i=0;i<sizeOfOptions;i++) {
						sc = new Scanner(System.in);
						System.err.println("Enter the Index Value Please");
						int indexValue = sc.nextInt();
						if(i==indexValue) {
							dropDown.selectByIndex(i);
							break;
						}
					}
				}
			case "deselecting" :
				dropDown=new Select(element);
				boolean isMultipleorNot=dropDown.isMultiple();
				System.out.println("If the DropDown isMultipelOrNot "+isMultipleorNot);
				if(isMultipleorNot==true) {
					int sizeOfOptions = dropDown.getOptions().size();
					System.out.println("The SizoOfOptions "+sizeOfOptions);
					for(int i=0;i<sizeOfOptions;i++) {
						sc = new Scanner(System.in);
						System.err.println("Enter the Index Value Please");
						int indexValue = sc.nextInt();
						if(i==indexValue) {
							dropDown.deselectByIndex(i);
							break;
						}
					}
				}
			}
		}
		public static void robotKey(int noOfTimes) {
			try {
				a = new Robot();
			}
			catch(AWTException e) {
				System.err.println("Please to Check your's Keyboard Action ==>"+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception ==>"+e.getMessage());
			}
			for(int i=1;i<=noOfTimes;i++) {
				a.keyPress(KeyEvent.VK_DOWN);
			}
			a.keyPress(KeyEvent.VK_ENTER);
		}
		public static void mouseActions(String options, WebElement element) 
		{
			try {
				builder = new Actions(driver);
			}
			catch (NullPointerException e) {
				System.err.println("May be The Driver is Not To Call Please to Check it ==>"+e.getMessage());
			}
			catch (Exception e) {
				System.out.println("Other Java Related Exception ==>"+e.getMessage());
			}
			try {
				switch (options.toLowerCase()) {
				case "mouse":
					builder.moveToElement(element).build().perform();
					break;
				case "rightclick":
					builder.contextClick(element).build().perform();
					break;
				case "clickandhold" :
					builder.clickAndHold(element).build().perform();
					break;
				case "release" :
					builder.release().build().perform();
					break;
				case "doubleclick":
					builder.doubleClick(element).build().perform();
					break;
				default:
					System.err.println("UnDefined Mouse Operation Please to Check it");
							break;
				}
			}
			catch(NoSuchElementException e) {
				System.err.println("The Element is Not to Find Correctly ==>Please to Check it "+e.getMessage());
			}
			catch (WebDriverException e) {
				System.err.println("Other Selenium Realted Exception ==> "+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Realted Exception ==>"+e.getMessage());
			}
		}
		public static void dragAndDrop(WebElement sourceElement, WebElement 
				targetElement) {
			try {
				builder= new Actions(driver);
			}
			catch(Exception e) {
				System.err.println("May be The Driver Not to Call or ==>"+e.getMessage());
			}
			builder.dragAndDrop(sourceElement, 
					targetElement).build().perform();
		}
		public static void location(WebElement element) {
			try {
				Point location = element.getLocation();
				x=location.getX();
				System.out.println("The X value is "+x);
				y=location.getY();
				System.out.println("The Y value is "+y);
			}
			catch(NoSuchElementException e) {
				System.err.println("The Element is Not Found ==> "+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Exception ==> "+e.getMessage());
			}
		}
		public static void dragAndDropBy(WebElement element) {
			try {
				int xValue = sc.nextInt();
				int yValue = sc.nextInt();
				builder.dragAndDropBy(element, x+xValue, y+yValue);
			}
			catch (InputMismatchException e) {
				System.err.println("Please to check your's Given Input ==> "+e.getMessage());
			}
			catch(NoSuchElementException e) {
				System.err.println("May be The Element is Not Found Please to Check ==> "+e.getMessage());
			}
			catch(Exception e) {
				System.out.println("Others ==> "+e.getMessage());
			}
		}
		public static void javaScriptExecutor(String script, WebElement 
				element) {
			js =(JavascriptExecutor)driver;
			try {
				if(script.equalsIgnoreCase("elementScroll")) {
					js.executeScript("arguments[0].scrollIntoView();", 
							element);
				}
				else if(script.equalsIgnoreCase("bottomScroll")) {
					js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				}
				else if(script.equalsIgnoreCase("topScroll")) {
					js.executeScript("window.scrollTo(0,0)");
				}
				else if(script.equalsIgnoreCase("click")) {
					js.executeScript("arguments[0].click()", element);
				}
			}
			catch (JavascriptException e) {
				System.err.println("May be You made Mistake in your's Script Please to Check ==> "+e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Other Exception ==> "+e.getMessage());
			}
		}
		public static void fullShot(String location) {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File inBrowser = ts.getScreenshotAs(OutputType.FILE);
			File inMyLocation = new File(location);
			try {
				FileHandler.copy(inBrowser, inMyLocation);
			}
			catch (IOException e) {
				System.err.println("Please to Check the File path ==> "+e.getMessage());
			}
			catch(WebDriverException e) {
				System.err.println("Other Java Related Exception ==> "+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception ==> "+e.getMessage());
			}
		}
		public static void elementShot(WebElement element,String location) 
		{
			File inBrowser=element.getScreenshotAs(OutputType.FILE);
			File inMyLocation = new File(location);
			try {
				FileHandler.copy(inBrowser, inMyLocation);
			}
			catch (IOException e) {
				System.err.println("Please to Check the File path ==> "+e.getMessage());
			}
			catch(NoSuchElementException e) {
				System.err.println("MayBe the Element is Undefined Please to Check ==> "+e.getMessage());
			}
			catch(WebDriverException e) {
				System.err.println("Other Java Related Exception ==> "+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception ==> "+e.getMessage());
			}
		}
		public static void windowHandling(Set<String> windowsId, int index) 
		{
			List<String> l = new ArrayList<String>(windowsId);
			try {
				driver.switchTo().window(l.get(index));
			}
			catch(IndexOutOfBoundsException e) {
				System.err.println("May be the index is out of the Given Value Please to Check ==> "+e.getMessage());
			}
			catch(NoSuchElementException e) {
				System.err.println("May be Window is Closed or Not Opened please to Check ==> "+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("Other Java Related Exception ==> "+e.getMessage());
			}
		}
		public static void explicitWait(String options,WebElement element) 
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			try {
				if(options.equalsIgnoreCase("click")) {
					wait.until(ExpectedConditions.elementToBeClickable(element));
				}
				else if(options.equalsIgnoreCase("select")) {
					wait.until(ExpectedConditions.elementToBeSelected(element));
				}
				else if(options.equalsIgnoreCase("visible")) {
					wait.until(ExpectedConditions.visibilityOf(element));
				}
			}
			catch(TimeoutException e) {
				System.err.println(e.getMessage());
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}



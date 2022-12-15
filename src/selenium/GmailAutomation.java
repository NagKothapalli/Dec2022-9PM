package selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class GmailAutomation {
	// 1.java.lang.IllegalStateException: The path to the driver executable must be
	// set by the webdriver.chrome.driver system property; for more information, see
	// https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver. The latest version
	// can be downloaded from https://chromedriver.storage.googleapis.com/index.html
	// 2.org.openqa.selenium.SessionNotCreatedException: Could not start a new
	// session. Response code 500. Message: session not created: This version of
	// ChromeDriver only supports Chrome version 108
	// Current browser version is 90.0.4430.212 with binary path C:\Program Files
	// (x86)\Google\Chrome\Application\chrome.exe
	// 3.org.openqa.selenium.WebDriverException: chrome not reachable , if the
	// current browser window got closed
	//4.junit.framework.ComparisonFailure: expected:<[A]mail> but was:<[G]mail>
	//5.Which type of class can not be inherited : final class can not be inherited , we can't extend  or we can not create object for the class
	//6.java.lang.NullPointerException : if we try to access an object whose value is empty
	//7.org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"*[name='identifier']"}
	String expectedValue = "Gmail";
	              //*****************Functions in different classes in selenium webdriver************************//
	//WebDriver : getTitle , getCurrentURL , get , getWindowHAndle , findElement ,
	//By : id , name , class , cssSelector , linkText , partialLinkText , tagName , xpath
	//WebElement : click , sendkeys , getText , getAttribute , clear ,
	//***********************************************************************************************************//
	String name = "Ram";
	WebDriver driver;
	public GmailAutomation()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Before
	public void launchApplication() {
		System.out.println(name.toUpperCase());
		System.out.println("Test Case : Launch Gmail Application");
		
		//ChromeDriver driver = new ChromeDriver();// this constructor will execute driver.exe file as a result an empty
													// chrome browser will be opened
		//int rollNum = 22; // Local Variable
		//WebDriver driver = new ChromeDriver(); //Local variable
		String sessionID = driver.getWindowHandle();
		System.out.println("Current Session ID :" + sessionID);
		driver.get("https://gmail.com"); // Every browser window will have a unique session id , this will be assigned
											// to the driver variable
		String actualTtitle = driver.getTitle();
		System.out.println("Title of the Application :" + actualTtitle);
		System.out.println("Current URL :" + driver.getCurrentUrl());
		Assert.assertEquals(expectedValue, actualTtitle);	
		//By myby = new By();		
		driver.findElement(By.name("identifier")).click();	
		//System.out.println(rollNum);
	}
	@Test
	public void loginToApplication()
	{
		System.out.println(name);
		By myby = By.name("identifier");
		WebElement element = driver.findElement(myby);
		String mylabel = element.getAttribute("aria-label");
		System.out.println("My Aria Label :" + mylabel);
		if(mylabel.equals("Email or phone"))
		{
			element.click();
			element.sendKeys("sddskjfdsfjdklgdf;");
			element.clear();
			element.sendKeys("nag022");
			String txt = element.getText();
			System.out.println("Text on the email field :" + txt);
		}
	}

}

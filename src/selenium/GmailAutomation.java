package selenium;

import java.util.List;

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
	//WebDriver : getTitle , getCurrentURL , get , getWindowHAndle , findElement , findElements
	//By : id , name , class , cssSelector , linkText , partialLinkText , tagName , xpath
	//WebElement : click , sendkeys , getText , getAttribute , clear , findElement , findElements
	//WebElements : Button , TextBox , Link , Radio Button , Check Box , DropDown , Calendar , Iframe , WebAlert , Multiple Windows
	//Events : Mouse operations - left click , right click , double click , hover , drag and drop
	//KeysBoard Events : Enter , Tab , Shift , Function keys 
	//***********************************************************************************************************//
	String name = "Ram";
	WebDriver driver;
	public GmailAutomation()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	//@Before
	public void launchRedBus()
	{
		driver.get("https://www.redbus.in/");
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
	
	//Xpath : XML path language which will be used to identify the webelement in a DOM uniquely
	//Static | Absolute | Fixed ,  It will start with /
	//Relative xpath is something like a SQL query , It will start with //
	    //select salary from Employees where empname='Ram'  -> 554543,56546,3434657
	    //select salary from Employees where fname='Ram' and lname='K'
	//Angular JS : ng-view , ng-model .......
	
	//tagname[@attribute = 'value']  Ex : //button[@jsname='Cuz2Ue']
	
	//tagname[text() = 'value']   Ex : //span[text()='Create account']    
	
	//tagname[contains(text() , 'value')]    Ex : //span[contains(text(),'Create')]
	
	//tagname[@attribute1 = 'value' and @attribute2 = 'value']  - Ex : //span[@class='VfPpkd-vQzf8d'  and @id='vQzf8d' ]
	
	//tagname[text() = 'value' and @attribute2 = 'value']  Ex : //span[@class='VfPpkd-vQzf8d'  and text()='Create account']
	
	@Test
	public void validateCreateAccountWithxpath()
	{
	 //	/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button/span
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button/span")).click();
	//driver.findElement(By.xpath("//span[text()='Create account']")).click();
		//driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d'  and text()='Create account']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
	}
	
	
	@Test
	public void loginToGmailApplication()
	{
		driver.findElement(By.id("identifierId")).sendKeys("nag022");
		driver.findElements(By.className("VfPpkd-vQzf8d")).get(1).click();
	}
	@Test
	public void validateForgotEmail()
	{
		//driver.findElements(By.tagName("button")).get(0).click();
		//driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//button[@jsname='Cuz2Ue']")).click();
	}
	
	@Test
	public void validateHelpOption()
	{
		driver.findElement(By.linkText("Help")).click();
	}
	
	@Test
	public void validateCreateAccount()
	{
		List<WebElement> elements = driver.findElements(By.className("VfPpkd-vQzf8d"));
		for(int i=0;i<elements.size();i++)
		{
			WebElement myelement = elements.get(i); //i =0
			String text = myelement.getText();
			System.out.println("Text on the object :" + text);
			if(text.equals("Create account"))
			{
				myelement.click();
				break;
			}			
		}
	}
	
	//Link : tagname : a  , href : url
	@Test
	public void findAllLinksInThePage()
	{
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links count :"+ allLinks.size());
		for(int i=0;i<allLinks.size();i++)
		{
			WebElement mylink = allLinks.get(i); //i =0
			String text = mylink.getAttribute("href");
			System.out.println(text);
		}
	}
	//Image :  tagname : img  , src : url
	@Test
	public void findAllImagesInThePage()
	{
		List<WebElement> allLinks = driver.findElements(By.tagName("img"));
		System.out.println("Total images count :"+ allLinks.size());
		for(int i=0;i<allLinks.size();i++)
		{
			WebElement mylink = allLinks.get(i); //i =0
			String text = mylink.getAttribute("src");
			System.out.println(text);
		}
	}
	@Test
	public void validateLearnMoreOption()
	{
		/*
		 * List<WebElement> elements = driver.findElements(By.tagName("a")); for(int
		 * i=0;i<elements.size();i++) { WebElement myelement = elements.get(i); //i =0
		 * String text = myelement.getText(); System.out.println("Text on the object :"
		 * + text); if(text.equals("Learn more")) { myelement.click(); break; } }
		 */
		
		//driver.findElement(By.linkText("Learn more")).click();
		driver.findElement(By.partialLinkText("Learn")).click();
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
		List<WebElement> elements = driver.findElements(By.className("VfPpkd-vQzf8d"));
		//WebElement nxtbtn = elements.get(1);
		//nxtbtn.click();
		for(int i=0;i<elements.size();i++)
		{
			WebElement myelement = elements.get(i); //i =0
			String text = myelement.getText();
			System.out.println("Text on the object :" + text);
			if(text.equals("Next"))
			{
				myelement.click();
				break;
			}
			
		}
		
	}

}

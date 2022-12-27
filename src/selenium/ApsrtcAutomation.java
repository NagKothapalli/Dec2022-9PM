package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ApsrtcAutomation
{
	//org.openqa.selenium.UnhandledAlertException: unexpected alert open: {Alert text : Please select end place.}
	//org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
	//org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
	WebDriver driver;
	public ApsrtcAutomation()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Before
	public void launchRedBus() throws IOException
	{
		//driver.get("https://www.apsrtconline.in/");//Hard coded data
		String url = readData("URL");
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test
	public void readPropertiesData() throws IOException
	{
		FileInputStream myfile = new FileInputStream("Data/ApsrtcData.properties");
		Properties prop = new Properties();
		prop.load(myfile);
		String myurl = prop.getProperty("URL");
		System.out.println("Given URL :" + myurl);
		System.out.println("Given Source :" + prop.getProperty("FromCity"));
		System.out.println("Given Destination :" + prop.getProperty("ToCity"));
	}
	
	public String readData(String key) throws IOException
	{
		FileInputStream myfile = new FileInputStream("Data/ApsrtcData.properties");
		Properties prop = new Properties();
		prop.load(myfile);
		String value = prop.getProperty(key);
		return value;
	}
	
	@Test
	public void bookBusTicket()
	{
		System.out.println("Test Case : Book Bus Ticket");
		driver.findElement(By.xpath("//input[@name='source']")).sendKeys("HYDERABAD");
		Actions actions = new Actions(driver);
		actions.pause(1000).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//input[@name='searchBtn']")).click();
		//driver.findElement(By.xpath("//input[@name='destination']")).sendKeys("GUNTUR");
		driver.switchTo().alert().accept(); // driver.switchTo().alert().dismiss(); driver.switchTo().alert().sendKeys("dffffsdddf");
		driver.findElement(By.xpath("//input[@name='destination']")).sendKeys("GUNTUR");
		actions.pause(1000).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//input[@name='searchBtn']")).click();
	}
	@Test
	public void bookBusTicket_WithActions() throws InterruptedException, IOException
	{
		System.out.println("Test Case : Book Bus Ticket");
		WebElement source = driver.findElement(By.xpath("//input[@name='source']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(source).click().sendKeys(readData("FromCity")).pause(1000).sendKeys(Keys.ENTER).build().perform();
		//actions.pause(1000).sendKeys(Keys.ENTER).build().perform();		
		WebElement destination = driver.findElement(By.xpath("//input[@name='destination']"));
		actions.moveToElement(destination).click().sendKeys(readData("ToCity")).pause(1000).sendKeys(Keys.ENTER).build().perform();
		//actions.pause(1000).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//input[@id='txtJourneyDate']")).click();
		WebElement jDate = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table//tbody//tr//a[text()='30']"));
		jDate.click();
		driver.findElement(By.xpath("//input[@name='searchBtn']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='returnDiscountModal']//input[@name='searchBtn']")).click();
		//jDate.click();
		String jdate  = readData("JDate");
		driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table//tbody//tr//a[text()='"+jdate+"']")).click();
	}
	@Test
	public void mouseOperations()
	{
		System.out.println("Test Case : Book Bus Ticket");
		WebElement fromCity = driver.findElement(By.xpath("//input[@name='source']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(fromCity).pause(1000).click().build().perform();//Mouse Hover , Click
		actions.moveToElement(fromCity).pause(1000).sendKeys("HYDERABAD").build().perform(); ////Mouse Hover , Enter Text
		actions.moveToElement(fromCity).pause(1000).doubleClick().build().perform(); ////Mouse Hover , Double Click
		actions.moveToElement(fromCity).pause(1000).contextClick().build().perform();//Mouse Hover , Right Click
	}
	@Test
	public void workWithMultipleWindows() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='TimeTable / Track']")).click();
		Set<String> myset = driver.getWindowHandles();
		System.out.println("Windows Count Before:" + myset.size());
		driver.findElement(By.xpath("//a[text()='All services Time Table & Tracking']")).click();
		myset = driver.getWindowHandles();
		System.out.println("Windows Count After :" + myset.size());
	    ArrayList<String> mylist = new ArrayList<String>(myset);
	    for(int i=0;i<mylist.size();i++) {
	    	System.out.println("Session ID :" + mylist.get(i));
	    }
	    System.out.println("Title of the first window :"+ driver.getTitle());
	    driver.switchTo().window(mylist.get(1));
	    System.out.println("Title of the second window :"+ driver.getTitle());
	    //driver.switchTo().defaultContent();
	    driver.close();
	    //driver.quit();
	    System.out.println(driver);
	    driver.switchTo().window(mylist.get(0));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[@title='Home']")).click();
	    driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package selenium;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusAutomation //extends ReadProperties
{
	WebDriver driver;
	ReadProperties myprop;//null
	public RedBusAutomation() throws IOException
	{
		System.setProperty("webdriver.chrome.driver",myprop.readData("DriverPath"));
		driver = new ChromeDriver();
	}
	@Before
	public void launchRedBus() throws IOException
	{
		myprop = new ReadProperties("Data/ApsrtcData.properties");
		//driver.get("https://www.redbus.in/");
		driver.get(myprop.readData("URL"));
		driver.manage().window().maximize();
	}
	@Test
	public void loginToApplication()
	{
		System.out.println("Test Case : Login To Application");
		driver.findElement(By.xpath("//div[@id='sign-in-icon-down']")).click();
		driver.findElement(By.xpath("//li[@id='signInLink']")).click();
		WebElement loginFrame = driver.findElement(By.xpath("//div[@class='modal']//iframe"));
		driver.switchTo().frame(loginFrame);
		driver.findElement(By.xpath("//input[@id='mobileNoInp']")).sendKeys("9959775757");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//i[@class='icon-close']")).click();
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("HYDERABAD");
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

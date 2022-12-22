package selenium;

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
	WebDriver driver;
	public ApsrtcAutomation()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Before
	public void launchRedBus()
	{
		driver.get("https://www.apsrtconline.in/");
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
	public void bookBusTicket_WithActions()
	{
		System.out.println("Test Case : Book Bus Ticket");
		WebElement source = driver.findElement(By.xpath("//input[@name='source']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(source).click().sendKeys("HYDERABAD").pause(1000).sendKeys(Keys.ENTER).build().perform();
		//actions.pause(1000).sendKeys(Keys.ENTER).build().perform();		
		WebElement destination = driver.findElement(By.xpath("//input[@name='destination']"));
		actions.moveToElement(destination).click().sendKeys("GUNTUR").pause(1000).sendKeys(Keys.ENTER).build().perform();
		//actions.pause(1000).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//input[@name='searchBtn']")).click();
	}

}

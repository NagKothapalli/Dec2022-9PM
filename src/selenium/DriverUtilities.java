package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DriverUtilities
{
	//utility functions / generic functions / common functions
	WebDriver driver;
	Actions actions;
	public DriverUtilities(WebDriver mydriver)
	{
		driver = mydriver;
		actions = new Actions(driver);
	}
	public void elementClick(WebElement element)
	{		
		actions.moveToElement(element).pause(1000).click().build().perform();
	}
	public void elementClick(String xpath)
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		//waitforelement
		if(element.isDisplayed())
		{
		   actions.moveToElement(element).pause(1000).click().build().perform();
		}
		else
		{
			System.out.println("Object is not Enabled");
		}
	}
	public void enterText(String xpath,String text)
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		//waitforelement
		if(element.isEnabled())
		    actions.moveToElement(element).click().pause(1000).sendKeys(text).build().perform();
		else
			System.out.println("Object is not Enabled");
	}
	public void clickEnter()
	{
		actions.pause(1000).sendKeys(Keys.ENTER).build().perform();
	}
	public void fixedWait(int seconds)
	{
		actions.pause(seconds*1000).build().perform();
	}
	public void doubleClick(String xpath)
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		//waitforelement
		if(element.isEnabled())
		    actions.moveToElement(element).doubleClick().build().perform();
		else
			System.out.println("Object is not Enabled");
	}
	public void rightClick(String xpath)
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		//waitforelement
		if(element.isEnabled())
		    actions.moveToElement(element).contextClick().build().perform();
		else
			System.out.println("Object is not Enabled");
	}

}

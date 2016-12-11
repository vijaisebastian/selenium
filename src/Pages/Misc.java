package Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Misc 
{

	
WebDriver driver;
	
	public Misc(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void handleIframe()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement iFrame= driver.findElement(By.id("edr_l_first"));
		boolean s=iFrame.isDisplayed();
		System.out.println(s);
		System.out.println("sasi");
		System.out.println(s);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("edr_l_first");
		By LocatorNo=By.linkText("No thanks");
		WebElement no=driver.findElement(LocatorNo);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		no.click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent(); 
		if(s==false)
		{
		
			 return;   
		}
	
	}
		
	public void QuitBrowser()
	{
		
		driver.close();
	}
}

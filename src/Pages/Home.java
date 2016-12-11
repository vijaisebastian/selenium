package Pages;
import utility.ExcelUtils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Home
{
	WebDriver driver;
	By LocatorSignIn=By.linkText("SIGN IN");
	public Home(WebDriver driver)
	{
		this.driver = driver;
	}
 public void clickLogin()
	  {
			WebElement SignIn=driver.findElement(LocatorSignIn);
		  SignIn.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
	public void fetchlink()
	{
		this.clickLogin();		
	}
}

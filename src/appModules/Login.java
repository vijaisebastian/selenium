package appModules;

import java.util.concurrent.TimeUnit;
import Pages.Home;
import Pages.Login_K;
import Pages.Misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelUtils;

public class Login 
{
	Login_K objLogin;
	Home objHomePage;	
	Misc objMisc;
	public String appUrl="https://www.simplybe.com/en-us/";
	public WebDriver driver;
		
		@BeforeTest
		public void  UrlSetUp()
		{
			driver= new FirefoxDriver();
			driver.get(appUrl);
			driver.manage().window().maximize();
				
		}
			
		@Test(priority=0)
		public void test_Home_Page_Appear_Correct()
		{
		
		objLogin = new Login_K(driver);
		objHomePage = new Home(driver);
		objMisc=new Misc(driver);
		objMisc.handleIframe();
		objHomePage.fetchlink();
		objLogin.loginToSBUS("vijaisebastian@gmail.com", "nextday1");
		objMisc.QuitBrowser();
		
		// go the next page
	
		//Verify home page
		
		}
		
}

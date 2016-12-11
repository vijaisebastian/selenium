package Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Login_K
{
	
	WebDriver driver;
	By j_username=By.id("j_username");
	By j_password=By.id("j_password");
	By btnSignin=By.id("btnSignin");
	
	public Login_K(WebDriver driver)
	{
		this.driver = driver;
	}
	//Set user name in textbox
	public void setUserName(String strUserName)
		{
		
		WebElement username=driver.findElement(j_username);
		username.sendKeys(strUserName);
		}
		
		//Set password in password textbox
		public void setPassword(String strPassword)
		
		
		{
			
			
			WebElement password=driver.findElement(j_password);
			password.sendKeys(strPassword);
		}
		
		//Click on login button
		public void clickLogin()
		{
			
		
			WebElement SignIn=driver.findElement(btnSignin);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			SignIn.click();
		}
	public void loginToSBUS(String strUserName,String strPasword)
	{
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();		
		
	}

}

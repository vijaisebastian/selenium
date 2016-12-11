package appModules;
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

public class Registration
{
	public String appUrl="https://www.simplybe.com/en-us/";
	public WebDriver driver;
	
	@BeforeTest
	public void  UrlSetUp()
	{
		driver= new FirefoxDriver();
		driver.get(appUrl);
		
	}
	@Test(priority=0)
	public void VerifyTitle()
	{
		String ActualHomePageTitle=driver.getTitle();
		String ExpectedHomePageTitle="Simply Be Plus Size Clothing | Free Shipping on Orders over $40";
		if (ActualHomePageTitle==ExpectedHomePageTitle)
		{
			System.out.println("Test passed");
		}
		else
		{
			
			System.out.println("Test failed");
		}
		
		
	}
	@Test(priority=1)
	public void handleIframe()
	{
		driver.switchTo().frame("edr_l_first");
		By LocatorNo=By.linkText("No thanks");
		WebElement no=driver.findElement(LocatorNo);
		no.click();
		System.out.println("Test failed unable to select iframe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent(); 
	}
	@Test(priority=2,dataProvider="Authentication")
	public void register(String sUserName,String sPassword) throws Exception
	{

		
		By LocatorSignIn=By.linkText("SIGN IN");
		WebElement SignIn=driver.findElement(LocatorSignIn);
		SignIn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		By LocatorNewOnlineCustomer=By.id("signin-new-customer-btn");
		WebElement NewOnlineCustomer=driver.findElement(LocatorNewOnlineCustomer);
		NewOnlineCustomer.click();
		
		By LocatortitleCode=By.id("titleCode");
		WebElement titleCode=driver.findElement(LocatortitleCode);
		Select SelectTitleCode = new Select(titleCode);
		SelectTitleCode.selectByValue("mr");
		
		By LocatorfirstName=By.id("firstName");
		WebElement firstName=driver.findElement(LocatorfirstName);
		firstName.sendKeys("firstname");
		
		By LocatorlastName=By.id("lastName");
		WebElement lastName=driver.findElement(LocatorlastName);
		lastName.sendKeys("lastname");
		
		By Locatoremail=By.id("email");
		WebElement email=driver.findElement(Locatoremail);
		email.sendKeys(sUserName);
		
		By LocatorreEmail=By.id("reEmail");
		WebElement reEmail=driver.findElement(LocatorreEmail);
		reEmail.sendKeys(sUserName);
		
		By Locatorpwd=By.id("pwd");
		WebElement pwd=driver.findElement(Locatorpwd);
		pwd.sendKeys("nextday1");
		
		By LocatorbtnRegister=By.id("btnRegister");
		WebElement btnRegister=driver.findElement(LocatorbtnRegister);
		btnRegister.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		By LocatorAddressCountry=By.id("address.country");
		WebElement Country=driver.findElement(LocatorAddressCountry);
		Select SelectCountry = new Select(Country);
		SelectCountry.selectByValue("US");
		
		By LocatorSddressLine1=By.id("address.line1");
		WebElement AddressLine1=driver.findElement(LocatorSddressLine1);
		AddressLine1.sendKeys("AddressLine1");
		
		By LocatorAddressTownCity=By.id("address.townCity");
		WebElement AddressTownCity=driver.findElement(LocatorAddressTownCity);
		AddressTownCity.sendKeys("AddressTownCity");
		
		By LocatorAddressProvinceCode=By.id("address.provinceCode");
		WebElement AddressProvinceCode=driver.findElement(LocatorAddressProvinceCode);
		Select SelectAddressProvinceCode = new Select(AddressProvinceCode);
		SelectAddressProvinceCode.selectByValue("AL");
		
		By LocatorAddressZipcode=By.id("address.zipcode");
		WebElement AddressZipcode=driver.findElement(LocatorAddressZipcode);
		AddressZipcode.sendKeys("50001");
		
		By LocatorpcaSaveAddress=By.id("pcaSaveAddress");
		WebElement pcaSaveAddress=driver.findElement(LocatorpcaSaveAddress);
		pcaSaveAddress.click();
		By LocatorSignOut=By.linkText("SIGN OUT");
		WebElement SignOut=driver.findElement(LocatorSignOut);
		SignOut.click();
		

				
		
	}
	@DataProvider
    public Object[][] Authentication() throws Exception
	{
         Object[][] testObjArray = ExcelUtils.getTableArray("C://vijai//selenium//HybrisUS//src//testData//TestData.xlsx","Sheet1");
         return (testObjArray);

	}
	
	@AfterTest
	public void QuitBrowser()
	{
		
		driver.close();
	}
    
  
}

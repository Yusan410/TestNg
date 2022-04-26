package TestCases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethod;

public class customerTest extends CommonMethod {
	
	@BeforeMethod
	public void setup() throws MalformedURLException  {
		
		
		BaseClass.getDriver().get(BaseClass.getProperty("customerfrontUrl"));
		BaseClass.getDriver().manage().window().maximize();
		BaseClass.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void custest() throws InterruptedException {
		
		cus.cookies.click();
		cus.loginUsername.sendKeys(BaseClass.getProperty("customerUsername"));
		cus.loginpassword.sendKeys(BaseClass.getProperty("cusTomerPassword"));
		//cus.cookies.click();
		Thread.sleep(3000);
		cus.loginbutton.click();
		//cus.loginbutton.click();
		//Thread.sleep(2000);
		
		
		//cus.loginbutton.click();
		
		
		
		
		
	}
	

}

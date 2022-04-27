package TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


import utilities.BaseClass;
import utilities.CommonMethod;

public class SupplierTest extends CommonMethod {
	
	public SupplierTest() {
		
		
		
		
	}
	
	public static WebDriver driver;
	
    @BeforeMethod
	public void setup() throws MalformedURLException    {

    	
          BaseClass.getDriver().get(BaseClass.getProperty("supplierBackEndUrl"));
          
         
	}
    @Test(priority=2,groups= {"Smoke"})// order of wiche test we run first 
    public void testCase() {
    	    	sup.usernamefile.sendKeys(BaseClass.getProperty("supplierUsername"));
  	sup.Password.sendKeys(BaseClass.getProperty("supplierPassword"));
   	sup.LoginButton.click();
    	
    	
    	
    	
    	
    
    }
    @Test(priority=1,enabled=false)
    public void testSelenium() {
    	
    	
    	System.out.println("Test Passed");
    	
    	
    }
	
	

}

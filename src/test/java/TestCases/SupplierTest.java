package TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;


import utilities.BaseClass;
import utilities.CommonMethod;

public class SupplierTest extends CommonMethod {
    @BeforeMethod
	public void setup() throws MalformedURLException    {

    	
          BaseClass.getDriver().get(BaseClass.getProperty("supplierBackEndUrl"));
	}
    @Test
    public void test() {
    	    	sup.usernamefile.sendKeys(BaseClass.getProperty("supplierUsername"));
  	sup.Password.sendKeys(BaseClass.getProperty("supplierPassword"));
   	sup.LoginButton.click();
    	
    	
    	
    	
    	
    	
    }
	
	

}

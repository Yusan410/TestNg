package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParraelTest {
	
	WebDriver driver;
	
	@Test
	public void chromeTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		
	}
	@Test
	public void SafaRiTest() {
		
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
		driver.get("https://www.google.com");
		
		
		
	}
	@AfterMethod
	public void test() {
		
		driver.quit();
		
		
	}
	
	
	

}

package Sucelab;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class saucelabTest {
	
	public static void main(String[] args) throws MalformedURLException {
		
		String username = "oauth-yissan517-94d2a";
		String access_key="3ae5837c-dec7-484e-a4ed-ab3a426276ce";
		
		String URL="http://"+username+":"+access_key+"@ondemand.saucelabs.com:80/wd/hub";
		
		
		//DesiredCapblities caps = DesiredCapblities.chrome();
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName", "Windows 11");
		browserOptions.setCapability("browserVersion", "100");
		Map<String, Object> sauceOptions = new HashMap<>();
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		WebDriver driver = new RemoteWebDriver(new URL(URL),browserOptions);
		driver.get("https://www.techcircleschool.com");
		driver.findElement(By.id("comp-jgnafhlz1label")).click();
		driver.quit();
	}
	
	

}

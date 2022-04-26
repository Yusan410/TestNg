package utilities;

import java.io.FileInputStream;
import java.net.MalformedURLException;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	// DRIVER CLASS
			public static WebDriver driver;

			public static WebDriver getDriver() throws MalformedURLException  {

				if (driver == null) {

					switch (BaseClass.getProperty("browser")) {

					case "firefox":
						WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();

						break;
					case "chrome":
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();

						break;
					case "safari":
						WebDriverManager.safaridriver().setup();
						driver = new SafariDriver();

						break;
					case "headless":
						
//						String username = "oauth-yissan517-94d2a";
//						String access_key="3ae5837c-dec7-484e-a4ed-ab3a426276ce";
//						
						//String URL="http://"+BaseClass.getProperty("saucelabUsername")+":"+BaseClass.getProperty("saucelabaccessKey")+"@ondemand.saucelabs.com:80/wd/hub";
						
						
						//DesiredCapblities caps = DesiredCapblities.chrome();
//				       //ChromeOptions browserOptions = new ChromeOptions();
//						ChromeOptions browserOptions = new ChromeOptions();
//						browserOptions.setCapability("platformName", "Windows 11");
//						browserOptions.setCapability("browserVersion", "100");
//						Map<String, Object> sauceOptions = new HashMap<>();
//						browserOptions.setCapability("sauce:options", sauceOptions);
//						
//					  driver = new RemoteWebDriver(new URL(ConTanst.sauceLabUrl),browserOptions);
						// code
						break;

					}
					PageInitilaizer.initilize();

				}
				
				//driver.get(BaseClass.getProperty("url"));

				return driver;
			}

			// close/quit browser
			public static void tearDown() {
				if (driver != null) {
					driver.close();
					// driver.quit();
					driver = null;
				}
			}

			// configReaderClass
			private static Properties configFile;

			static {

				try {
					String filePath = ConTanst.configuration_filepath;

					FileInputStream input = new FileInputStream(filePath);

					configFile = new Properties();
					configFile.load(input);

					input.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			public static String getProperty(String keyName) {
				return configFile.getProperty(keyName);
			}

		}

		






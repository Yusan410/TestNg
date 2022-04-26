package utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethod extends PageInitilaizer {

	
	/**
	 * Method that clears and sends keys
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method checks if radio/checkbox is enabled and clicks it
	 * 
	 * @param radioOrcheckbox
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> radioOrcheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrcheckbox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}
	
	
	/**
	 * Method that checks if text is there and then selects it
	 * 
	 * @param element
	 * @param textToSelect 
	 * Author: Shafkat ALi
	 */
	public static void selectDdText(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method that selects value by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDdIndex(WebElement element, int index) {

		try {
			Select select = new Select(element);
			int size = select.getOptions().size();

			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Methods that accept alerts and catches exception if alert is not present
	 * @throws MalformedURLException 
	 */
	public static void acceptAlert() throws MalformedURLException  {

		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods that dismiss alerts and catches exception if alert is not present
	 * @throws MalformedURLException 
	 */
	public static void dismissAlert() throws MalformedURLException {

		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methods that gets text of alert and catches exception if alert is not present
	 * 
	 * @return String alert text
	 * @throws MalformedURLException 
	 */
	public static String getAlertText() throws MalformedURLException {

		String alertText = null;

		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	/**
	 * Methods that sends text to alert and catches exception if alert is not
	 * present
	 * @throws MalformedURLException 
	 * 
	 */
	public static void sendAlertText(String text) throws MalformedURLException {
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void switchToFrame(String nameOrId) throws MalformedURLException {

		try {
			BaseClass.getDriver().switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebElement element) throws MalformedURLException {

		try {
			BaseClass.getDriver().switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(int index) throws MalformedURLException {

		try {
			BaseClass.getDriver().switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method switches focus to child window
	 * @throws MalformedURLException 
	 */
	public static void switchToChildWindow() throws MalformedURLException {
		String mainWindow = BaseClass.getDriver().getWindowHandle();
		Set<String> windows = BaseClass.getDriver().getWindowHandles();
		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				BaseClass.getDriver().switchTo().window(window);
				break;
			}
		}
	}

	
	public static WebDriverWait getWaitObject() throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), 10);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) throws MalformedURLException {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) throws MalformedURLException {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void click(WebElement element) throws MalformedURLException {
		waitForClickability(element);
		element.click();
	}

	public static JavascriptExecutor getJSObject() throws MalformedURLException {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		return js;
	}

	public static void jsClick(WebElement element) {
		try {
			getJSObject().executeScript("arguments[0].click();", element);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrollToElement(WebElement element) throws MalformedURLException {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 * @throws MalformedURLException 
	 */
	public static void scrollDown(int pixel) throws MalformedURLException {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 * @throws MalformedURLException 
	 */
	public static void scrollUp(int pixel) throws MalformedURLException {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}
	
	/**
	 * This Method will take a screenshot
	 * 
	 * @param filename
	 * @throws MalformedURLException 
	 */
	public static byte[] takeScreenshot(String filename) throws MalformedURLException {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = "" + filename + getTimeStemp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	public static String getTimeStemp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method will select a date from the calendar
	 * 
	 * @param element
	 * @param text
	 */

	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}

	/**
	 * This Method will take a screenshot
	 * 
	 * @param filename
	 * @throws MalformedURLException 
	 */
	public static void TakesScreenshot(String fileName) throws MalformedURLException {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshot/" + fileName + ".png"));
		} catch (IOException e) {
			System.out.println("Cannot take screenshot");
			// e.printStackTrace();
		}
	}
	

}

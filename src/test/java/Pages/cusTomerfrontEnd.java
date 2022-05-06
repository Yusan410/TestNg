package Pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class cusTomerfrontEnd {
	
	
	public cusTomerfrontEnd() throws MalformedURLException {
		
	PageFactory.initElements(BaseClass.getDriver(), this);
	
	
	
		
		
		
	}
	@FindBy(xpath="//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")
	private WebElement loginUsername;
	
	public WebElement loginUsername() {
		
		return loginUsername;
	}
	@FindBy(xpath="//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")
	public WebElement loginpassword;
	@FindBy(xpath="//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")
	public WebElement loginbutton;
	@FindBy(xpath="//*[@id=\"cookie_stop\"]")
	public WebElement cookies;
	
	
	
	

}

package Pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class supplierPages {
	
	public supplierPages() throws MalformedURLException {
		
		PageFactory.initElements(BaseClass.getDriver(),this);
		
	}
	@FindBy(xpath="//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[1]/label/input")
	private WebElement usernamefile;
	
	public WebElement usernmaefile() {
		
		return usernamefile;
		
	}
	@FindBy(xpath="//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[2]/label/input")
	public WebElement Password;
	@FindBy(xpath="//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[4]/button")
	public WebElement LoginButton;

}


//Yusan create new girt comand
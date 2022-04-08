package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPassword {

	WebDriver driver;
	public ResetPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(xpath="//h1")
	WebElement verifyPage;
	
	public WebElement getUserEmail() {
		return email;
	}
	
	public WebElement geth1Title() {
		return verifyPage;
	}
}

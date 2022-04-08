package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(name="commit")
	WebElement login;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	WebElement forgotPasswordLink;
	
	public WebElement emailTxt() {
		return email;
	}
	
	public WebElement passwdTxt() {
		return password;
	}
	
	public WebElement loginBtn() {
		return login;
	}
	
	public ResetPassword getforgotPassword() {
		forgotPasswordLink.click();
		ResetPassword resetPage = new ResetPassword(driver);
		return resetPage;
	}
}

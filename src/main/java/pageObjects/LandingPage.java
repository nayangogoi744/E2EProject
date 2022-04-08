package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//a/span[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	WebElement btn;
	
	@FindBy(xpath="//*[@id='content']/div/div/h2")
	WebElement title;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']")
	WebElement navbar;
	
	public LoginPage loginLink() {
		login.click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public WebElement noThanks() {
		return btn;
	}
	
	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getNavBar() {
		return navbar;
	}

	
	

}

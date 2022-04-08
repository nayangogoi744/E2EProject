package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ResetPassword;
import resources.Base;

public class HomePage extends Base{
	public WebDriver driver;
	private static Logger log = (Logger) LogManager.getLogger(HomePage.class.getName());
	@BeforeMethod
	public void initiateBrowser() throws IOException {
		driver = initializeDriver();
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.noThanks().click();
		log.info("Clicked the No Thanks Button");
		LoginPage lo = lp.loginLink();
		lo.emailTxt().sendKeys(username);
		lo.passwdTxt().sendKeys(password);
		lo.loginBtn().click();
		log.info("Clicked the login Button");
		
		ResetPassword rp = lo.getforgotPassword();
		log.info("Inside Reset Page");
		rp.getUserEmail();
		log.info("Entered email");
		Assert.assertEquals(rp.geth1Title().getText(), "Reset Password");
		
	}
		
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][2];
		obj[0][0]="nayan@gmail.com";
		obj[0][1]="pass";
		
		obj[1][0]="nayan123@gmail.com";
		obj[1][1]="passs";
		
		return obj;
	}
}

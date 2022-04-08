package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavBar extends Base{
	public WebDriver driver;
	private static Logger log = (Logger) LogManager.getLogger(ValidateNavBar.class.getName());
	@BeforeTest
	public void initiateBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void getNavBarDetail() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Verfied if the navigation is displayed");
	}
	
	@AfterTest
	public void tearDownBrowser() {
		driver.close();
	}
}

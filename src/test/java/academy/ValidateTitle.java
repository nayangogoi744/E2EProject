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

public class ValidateTitle extends Base{
	public WebDriver driver;
	private static Logger log = (Logger) LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void initiateBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to HomePage");
		
	}
	@Test
	public void validateTitle() throws IOException {
		LandingPage lp = new LandingPage(driver);
		System.out.println(lp.getTitle().getText());
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		log.info("Successfully validated the text");
	}
	@AfterTest
	public void tearDownBrowser() {
		driver.close();
	}
}

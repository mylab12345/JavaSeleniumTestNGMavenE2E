package ArijitSampleSpicejetSeleniumJava.E2EProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPageObjects;
import resources.Base;

public class ValidateHomePage extends Base {
	
	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(ValidateHomePage.class);
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		logger.info("Driver is initialized");
	}
	
	@Test
	public void validateHomePage() throws IOException {
		
		LandingPageObjects lp = new LandingPageObjects(driver);
		AssertJUnit.assertTrue(lp.getNavigationBar().isDisplayed());
		logger.info("Home Page is validated");
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
	}
	
}

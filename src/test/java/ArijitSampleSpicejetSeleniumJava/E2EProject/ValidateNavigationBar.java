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

public class ValidateNavigationBar extends Base {
	
	private static Logger log = LogManager.getLogger(ValidateNavigationBar.class.getName());
	
	public WebDriver driver;
	LandingPageObjects lp;
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
		
	}
	
	@Test(groups={"Smoke"})
	public void validateHomePage() throws IOException {
		lp = new LandingPageObjects(driver);
		AssertJUnit.assertEquals("FEATURED COURSES", lp.getTitle().getText());
		log.info("Navigation Bar is validated");
	}
	
	@Test(groups={"Smoke"})
	public void validateHeader() throws IOException {
		lp = new LandingPageObjects(driver);
		String title = lp.getHeader().getText();
		AssertJUnit.assertEquals("AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING", title);
		log.info("Header is validated");
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
	}
	
}

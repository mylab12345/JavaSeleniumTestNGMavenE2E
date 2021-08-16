package ArijitSampleSpicejetSeleniumJava.E2EProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import javax.swing.InternalFrameFocusTraversalPolicy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPageObjects;
import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObjects;
import resources.Base;

public class ForgotPasswordPage extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
	}
	
	@Test
	public void sendInstruction() {
		
		LandingPageObjects lp = new LandingPageObjects(driver);
		LoginPageObjects loginpage = lp.getLogin();
		ForgotPasswordPageObjects fppo = loginpage.getForgotPassword();
		
		fppo.getEmail().sendKeys("arijit05saha@gmail.com");
		fppo.getSendInstruction().click();
		String expectedUrl = "https://rahulshettyacademy.com/sign_in/password/new/index.php?email=arijit05saha%40gmail.com&commit=Send+Me+Instruction";
		AssertJUnit.assertEquals(expectedUrl, driver.getCurrentUrl());
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
	}

}

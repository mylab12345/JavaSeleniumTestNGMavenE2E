package ArijitSampleSpicejetSeleniumJava.E2EProject;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObjects;
import resources.Base;

public class Login extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test(dataProvider="getData")
	public void HomePageNavigation(String email, String password) throws IOException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
		
		LandingPageObjects lp = new LandingPageObjects(driver);
		LoginPageObjects loginpage = lp.getLogin();
		
		loginpage.getEmail().sendKeys(email);
		loginpage.getPassword().sendKeys(password);
		loginpage.getLogin().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		//row for  different types of data should run
		//col - how many values for each test
		Object[][] data = new Object[2][2];
		data[0][0] = "arijit05saha@gmail.com";
		data[0][1] = "asdf1234";
		//data[0][2] = "Good User";
		
		data[1][0] = "asphotos123@gmail.com";
		data[1][1] = "asdf12345";
		//data[1][2] = "Restricted User";
		
		return data;
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
	}

}

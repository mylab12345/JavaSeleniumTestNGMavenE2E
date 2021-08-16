package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	private By email = By.cssSelector("input[type='email']");
	private By passwrod = By.cssSelector("input[type='password']");
	private By login = By.cssSelector("input[value*='Log In']");
	private By forgotPassword = By.cssSelector("a[href*='password']");
	
	//Constructor of the class for the driver object
	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// ---- PAGE OBJECT METHODS ----- //
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passwrod);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public ForgotPasswordPageObjects getForgotPassword() {
		driver.findElement(forgotPassword).click();
		ForgotPasswordPageObjects fppo = new ForgotPasswordPageObjects(driver);
		return fppo;
	}

}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageObjects {
	
	public WebDriver driver;
	
	private By email = By.cssSelector("input[name='email']");
	private By sendInstrunctionsButton = By.cssSelector("input[type='submit']");
	
	//Constructor of the class for the driver object
	public ForgotPasswordPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getSendInstruction() {
		return driver.findElement(sendInstrunctionsButton);
	}
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {
	
	public WebDriver driver;
	
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//h2[text()='Featured Courses']");
	private By navBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	
	//Constructor of the class for the driver object
	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObjects getLogin() {
		driver.findElement(signIn).click();
		LoginPageObjects loginpage = new LoginPageObjects(driver);
		return loginpage;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}

}

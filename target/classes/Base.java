package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import okio.Options;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver InitializeDriver() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		String resourcesPath = projectPath + "\\src\\main\\java\\resources";
		String webdriversPath = projectPath + "\\src\\main\\java\\webdrivers";
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(resourcesPath+"\\data.properties");
		prop.load(fis);
		// String browser = prop.getProperty("browser");	// using properties file
		String browser = System.getProperty("browser");		// from maven
		System.out.println("Browser Name = " + browser);
		
		//Chrome
		if (browser.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", webdriversPath+"\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			if (browser.toLowerCase().contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		
		//Firefox
		else if (browser.toLowerCase().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", webdriversPath+"\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//IE
		else if (browser.toLowerCase().equals("ie")) {
			System.setProperty("webdriver.IEDriverServer.driver", webdriversPath+"\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//Putting Implicit Wait for universal wait to load every page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void getScreenshot(String testCaseName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFileName = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		try {
			FileUtils.copyFile(source,new File(destinationFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

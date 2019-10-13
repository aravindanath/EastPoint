package testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaUtils;

public class BaseTest {

	protected WebDriver driver;

	@BeforeClass
	public void launchBrowser() throws IOException {
		if (JavaUtils.getValue("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (JavaUtils.getValue("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().fullscreen();
		driver.get(JavaUtils.getValue("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	
//	@AfterClass
	public void closeBrowser() {
		
		driver.quit();
	}

}

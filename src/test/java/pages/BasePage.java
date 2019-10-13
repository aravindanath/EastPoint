package pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.github.javafaker.Faker;
import com.google.common.io.Files;

public class BasePage {

	private static WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public static void click(WebElement ele) {
		ele.click();
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void assertPageTitle(String actual, String expected) {
		Assert.assertEquals(actual, expected, " Mismatch in Actual vs Expected!");
	}

	public static void takeSnapShot() throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		System.out.println(d);
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = System.getProperty("user.dir") + "/test-output/";
		String filePath = path + screenshotFile;
		// Move image file to new destination
		File DestFile = new File(filePath);
		// Copy file at destination
		Files.copy(SrcFile, DestFile);

	}

	public static String captureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Output/screenShot.png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public static void assertPageTitle(String expected) {
		String actual = driver.getTitle();
		Reporter.log("Actual title: " + actual);
		Assert.assertEquals(actual, expected, " Mismatch in Actual vs Expected!");
	}

	/**
	 * @author aravindanathdm THis method is used to click on webelement
	 * @param element
	 */
	public static void actionClick(WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).build().perform();
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");

	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static long generateMobile() {
		long mob = (long) (Math.random() * 9999999999l);
		return mob;
	}

	public String getTodayDate() {
		Date d = new Date();
		return d.toString();
	}

	public void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void dragNDrop(WebElement src, WebElement tgt) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, tgt).build().perform();
	}
	
	
	
	public static String firstName() {
		Locale loc =  new Locale("en","IND");
		Faker faker =  new Faker(loc);
		String name = faker.name().firstName();
		return name;	
	}
	
	public static String lastName() {
		Locale loc =  new Locale("en","IND");
		Faker faker =  new Faker(loc);
		String name = faker.name().lastName();
		return name;	
	}
	
	public static String emailIDs() {
		Locale loc =  new Locale("en","US");
		Faker faker =  new Faker(loc);
		String emails = faker.internet().emailAddress();
		return emails;	
	}
	
	public static String companyNames() {
		Locale loc =  new Locale("en","IND");
		Faker faker =  new Faker(loc);
		String comp = faker.company().name();
		return comp;	
	}
}

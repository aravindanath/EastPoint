package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryFreePage  {
	
	
	private WebDriver driver;
	public TryFreePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	
	@FindBy(xpath="//*[text()='Try Free']")
	protected WebElement tryFree;
	
	@FindBy(css="#first-name")
	protected WebElement firstName;
	
	@FindBy(id="last-name")
	protected WebElement lastname;

	@FindBy(css="#email")
	protected WebElement emailId;
	
	@FindBy(css="#company")
	protected WebElement company;
	
	@FindBy(css="#start-trial-submit")
	protected WebElement submit;
	
	@FindBy(css="#go-to-login")
	protected WebElement gotoLogin;
	
	
	
	
 
	public void goToCreateAccount() {
		BasePage.click(tryFree);
 
	}

	public void createAccount(String fn,String ln,String email, String companyName) {
		
		firstName.sendKeys(fn);
		lastname.sendKeys(ln);
		emailId.sendKeys(email);
		company.sendKeys(companyName);
		BasePage.click(submit);
		
	}
	
	public void gotoLogin() throws InterruptedException {
		Thread.sleep(2000);
		gotoLogin.click();
	}
	
	
}

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testScripts.BaseTest;

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
	
	@FindBy(xpath="//*[contains(text(),'You are sending too many requests in a short time.') or contains(text(),'Cannot validate the specified e-mail address.')]")
	protected WebElement alertMsg;
	
	
 
	public void goToCreateAccount() {
		BasePage.click(tryFree);
 
	}

	public void createAccount(String fn,String ln,String email, String companyName) throws Exception {
		
		firstName.sendKeys(fn);
		lastname.sendKeys(ln);
		emailId.sendKeys(email);
		company.sendKeys(companyName);
		BasePage.click(submit);
		try {
			if(alertMsg.isDisplayed()) {
				BaseTest.test.fail(alertMsg.getText());
				Assert.fail(alertMsg.getText());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	public void gotoLogin() throws InterruptedException {
		Thread.sleep(2000);
		gotoLogin.click();
		
		
	}
	
	
}

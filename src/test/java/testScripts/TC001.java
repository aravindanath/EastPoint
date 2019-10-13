package testScripts;

import org.testng.annotations.Test;

import pages.BasePage;
import pages.TryFreePage;

public class TC001 extends BaseTest {

	@Test
	public void TC001() throws InterruptedException {
		TryFreePage tfp =  new TryFreePage(driver);
		tfp.goToCreateAccount();
		String email =BasePage.emailIDs();
		System.out.println(email);
		tfp.createAccount(BasePage.firstName(), BasePage.lastName(), email, BasePage.companyNames());
		tfp.gotoLogin();
		
	}

}

package testScripts;

import org.testng.annotations.Test;

import pages.BasePage;
import pages.TryFreePage;

public class TC001 extends BaseTest {

	@Test
	public void TC001() throws Exception {
		test = extent.createTest("TC001");
		TryFreePage tfp =  new TryFreePage(driver);
		test.info("User is on "+ driver.getCurrentUrl());
		tfp.goToCreateAccount();
		String email =BasePage.emailIDs();
		test.info(email);
		System.out.println(email);
		tfp.createAccount(BasePage.firstName(), BasePage.lastName(), email, BasePage.companyNames());
//		tfp.gotoLogin();
		//https://online.actitime.com/iyengar/login.do
		//https://online.actitime.com/iyengar/user/submit_tt.do
	}

}

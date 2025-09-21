package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC004_BlankUsername extends BaseClass {

	@Test(groups= {"regression","negative"})
	public void BlankUsername() {
		ExtentReport_OrangeHRM.getTest().info("Navigating to OrangeHRM login page");

		LoginPage loginpage = new LoginPage(getDriver());

		waitForElementTobeVisible(loginpage.return_username());
		ExtentReport_OrangeHRM.getTest().info("we keep username blank");

		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword(p.getProperty("validLoginPassword"));
		ExtentReport_OrangeHRM.getTest().info("Entered valid password");

		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on login button");

		waitForElementTobeVisible(loginpage.return_Required());
		String ActualErrormsg = loginpage.getErrorTestOfRequired();
		String ExpectedErrormsg = "Required";
		// boolean ActualErrormsg = loginpage.isVisible_Required();
		ExtentReport_OrangeHRM.getTest().info("Password field showing Actual error message: " + ActualErrormsg);
		ExtentReport_OrangeHRM.getTest().info("Password field showing Expected error message: " + ExpectedErrormsg);
		Assert.assertEquals(ActualErrormsg, ExpectedErrormsg);

	}

}

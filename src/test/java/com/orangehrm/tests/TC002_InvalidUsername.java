package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC002_InvalidUsername extends BaseClass {

	@Test(groups= {"regression", "negative"})
	public void InvalidUsername() {
		LoginPage loginpage = new LoginPage(getDriver());

		ExtentReport_OrangeHRM.getTest().info("Navigating to OrangeHRM login page");
		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername(p.getProperty("invalidLoginUsername"));
		ExtentReport_OrangeHRM.getTest().info("Entered Invalid username");

		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword(p.getProperty("validLoginPassword"));
		ExtentReport_OrangeHRM.getTest().info("Entered valid password");

		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on login button");

		waitForElementTobeVisible(loginpage.return_message_Invalidcredentials());
		String ActualErrormsg = loginpage.gettext_message_Invalidcredentials();
		String ExpectedErrormsg = "Invalid credentials";
		ExtentReport_OrangeHRM.getTest().info("Username field showing Actual error message: " + ActualErrormsg);
		ExtentReport_OrangeHRM.getTest().info("Username field showing Expected error message: " + ExpectedErrormsg);

		logger.info("Actual Error message" + ActualErrormsg);
		logger.info("Expected Error message" + ExpectedErrormsg);

		Assert.assertEquals(ActualErrormsg, ExpectedErrormsg);

	}

}

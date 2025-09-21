package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC003_InvalidPassword extends BaseClass {

	@Test(groups= {"regression","negative"})
	public void InvalidPassword() {
		ExtentReport_OrangeHRM.getTest().info("Navigating to OrangeHRM login page");

		LoginPage loginpage = new LoginPage(getDriver());

		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername(p.getProperty("validLoginUsername"));
		ExtentReport_OrangeHRM.getTest().info("Entered valid username");

		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword(p.getProperty("invalidLoginPassword"));
		ExtentReport_OrangeHRM.getTest().info("Entered Invalid password");

		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on login button");

		waitForElementTobeVisible(loginpage.return_message_Invalidcredentials());
		String ActualErrormsg = loginpage.gettext_message_Invalidcredentials();
		String ExpectedErrormsg = "Invalid credentials";
		ExtentReport_OrangeHRM.getTest().info("Password field showing Actual error message: " + ActualErrormsg);
		ExtentReport_OrangeHRM.getTest().info("Password field showing Expected error message: " + ExpectedErrormsg);

		Assert.assertEquals(ActualErrormsg, ExpectedErrormsg);
	}

}

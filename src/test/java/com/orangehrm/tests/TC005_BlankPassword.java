package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC005_BlankPassword extends BaseClass {

	@Test
	public void BlankPassword() {
		ExtentReport_OrangeHRM.getTest().info("Navigating to OrangeHRM login page");
		LoginPage loginpage = new LoginPage(driver);

		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("Admin");
		ExtentReport_OrangeHRM.getTest().info("Entered valid username");

		waitForElementTobeVisible(loginpage.return_password());
		ExtentReport_OrangeHRM.getTest().info("we keep password blank");

		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on login button");

		// waitForElementTobeVisible(loginpage.return_Required());
		// boolean ActualErrormsg = loginpage.isVisible_Required();

		// Assert.assertTrue(ActualErrormsg);
		
		waitForElementTobeVisible(loginpage.return_Required());
		String ActualErrormsg = loginpage.getErrorTestOfRequired();
		String ExpectedErrormsg = "Required";
		
		ExtentReport_OrangeHRM.getTest().info("Password field showing Actual error message: " + ActualErrormsg);
		ExtentReport_OrangeHRM.getTest().info("Password field showing Expected error message: " + ExpectedErrormsg);

		Assert.assertEquals(ActualErrormsg, ExpectedErrormsg);

	}

}

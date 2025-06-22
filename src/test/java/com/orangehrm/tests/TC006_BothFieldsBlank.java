package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC006_BothFieldsBlank extends BaseClass {

	@Test(groups= {"regression","negative"})
	public void BothFieldsBlank() {
		ExtentReport_OrangeHRM.getTest().info("Navigating to OrangeHRM login page");
		LoginPage loginpage = new LoginPage(getDriver());

		waitForElementTobeVisible(loginpage.return_username());
		ExtentReport_OrangeHRM.getTest().info("we keep username blank");
		
		waitForElementTobeVisible(loginpage.return_password());
		ExtentReport_OrangeHRM.getTest().info("we keep password blank");
	
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on login button");

//		waitForElementTobeVisible(loginpage.return_Required());
//		boolean ActualErrormsg = loginpage.isVisible_Required();
//
//		Assert.assertTrue(ActualErrormsg);
		
		waitForElementTobeVisible(loginpage.return_Required());
		String ActualErrormsg = loginpage.getErrorTestOfRequired();
		String ExpectedErrormsg = "Required";
		
		ExtentReport_OrangeHRM.getTest().info("Password field showing Actual error message: " + ActualErrormsg);
		ExtentReport_OrangeHRM.getTest().info("Password field showing Expected error message: " + ExpectedErrormsg);

		Assert.assertEquals(ActualErrormsg, ExpectedErrormsg);

	}

}

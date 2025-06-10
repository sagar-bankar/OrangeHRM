package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;

import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC001_ValidLogin extends BaseClass {

	@Test
	public void ValidLogin() {
		ExtentReport_OrangeHRM.getTest().info("Navigating to OrangeHRM login page");
		LoginPage loginpage = new LoginPage(driver);
		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("Admin");
		ExtentReport_OrangeHRM.getTest().info("Entered valid username");

		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword("admin123");
		ExtentReport_OrangeHRM.getTest().info("Entered valid password");

		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on login button");

		logger.info("Log in successfully done...");
		DashBoardPage dashboardpage = new DashBoardPage(driver);
		waitForElementTobeVisible(dashboardpage.return_Dashboardelement());
		ExtentReport_OrangeHRM.getTest().pass("Login successful. Dashboard is visible.");

		Assert.assertTrue(dashboardpage.isDisplayed_Dashboardelement());
	}

}

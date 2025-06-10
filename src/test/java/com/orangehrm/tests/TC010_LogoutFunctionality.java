package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC010_LogoutFunctionality extends BaseClass {

	@Test
	public void LogoutFunctionality() {
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

		DashBoardPage dashboardpage = new DashBoardPage(driver);

		waitForElementTobeVisible(dashboardpage.return_qAEngineer_dropdownbtn());
		dashboardpage.clickOn_qAEngineer_dropdownbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on profile dropdown ");

		waitForElementTobeVisible(dashboardpage.return_logout());
		dashboardpage.clickOn_logout();
		ExtentReport_OrangeHRM.getTest().info("Clicked on logout button");

		waitForElementTobeVisible(loginpage.return_submitbtn());
		ExtentReport_OrangeHRM.getTest().info(
				"we again on login page and login button status is visible or not: " + loginpage.isVisible_submitbtn());

		Assert.assertTrue(loginpage.isVisible_submitbtn());
	}

}

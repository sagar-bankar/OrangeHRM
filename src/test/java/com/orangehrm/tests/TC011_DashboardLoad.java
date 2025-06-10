package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC011_DashboardLoad extends BaseClass {

	@Test
	public void DashboardLoad() {

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
		waitForElementTobeVisible(dashboardpage.return_assignLeave());
		waitForElementTobeVisible(dashboardpage.return_myTimesheet());

		ExtentReport_OrangeHRM.getTest().info("We now on DashboardPage");
		boolean assign = dashboardpage.isVisible_assignLeave();
		ExtentReport_OrangeHRM.getTest().info("Dashboard tab is visible or not its staus:" + assign);
		
		boolean timesheet = dashboardpage.isVisible_myTimesheet();
		ExtentReport_OrangeHRM.getTest().info("My Timesheet tab is visible or not its staus:" + timesheet);

		Assert.assertTrue(assign == timesheet);
	}

}

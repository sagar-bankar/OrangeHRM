package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC016_NavigatetoUsers extends BaseClass {

	@Test
	public void NavigatetoUsers() {

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
		waitForElementTobeVisible(dashboardpage.return_admin());
		ExtentReport_OrangeHRM.getTest().info("we are in dashboard page");
		dashboardpage.clickOn_admin();
		ExtentReport_OrangeHRM.getTest().info("Clicked on Admin button");

		AdminPage adminpage = new AdminPage(driver);
		ExtentReport_OrangeHRM.getTest().info("Admin page total user account is: " + adminpage.getUserRowCount());

		Assert.assertTrue(adminpage.getUserRowCount() > 0);
	}

}

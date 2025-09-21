package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class TC015_ProfileDropdownCheck extends BaseClass {

	@Test(groups= {"regression","ui"})
	public void ProfileDropdownCheck() {

		ExtentReport_OrangeHRM.getTest().info("Navigating to OrangeHRM login page");

		LoginPage loginpage = new LoginPage(getDriver());
		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername(p.getProperty("validLoginUsername"));
		ExtentReport_OrangeHRM.getTest().info("Entered valid username");

		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword(p.getProperty("validLoginPassword"));
		ExtentReport_OrangeHRM.getTest().info("Entered valid password");

		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on login button");

		DashBoardPage dashboardpage = new DashBoardPage(getDriver());

		waitForElementTobeVisible(dashboardpage.return_qAEngineer_dropdownbtn());
		ExtentReport_OrangeHRM.getTest().info("We now on Dashboard page");
		dashboardpage.clickOn_qAEngineer_dropdownbtn();
		ExtentReport_OrangeHRM.getTest().info("Clicked on profile DropDown Icon");

		waitForElementTobeVisible(dashboardpage.return_logout());
		ExtentReport_OrangeHRM.getTest().info("In dropdown Logout Button is visible or not status: "+dashboardpage.isVisible_logout());

		Assert.assertTrue(dashboardpage.isVisible_logout());
	}

}

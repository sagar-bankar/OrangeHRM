package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;

public class TC015_ProfileDropdownCheck extends BaseClass {

	@Test
	public void ProfileDropdownCheck() {

		LoginPage loginpage = new LoginPage(driver);
		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("Admin");
		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword("admin123");
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();

		DashBoardPage dashboardpage = new DashBoardPage(driver);

		waitForElementTobeVisible(dashboardpage.return_qAEngineer_dropdownbtn());
		dashboardpage.clickOn_qAEngineer_dropdownbtn();

		waitForElementTobeVisible(dashboardpage.return_logout());

		Assert.assertTrue(dashboardpage.isVisible_logout());
	}

}

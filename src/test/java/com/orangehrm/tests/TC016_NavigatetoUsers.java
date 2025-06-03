package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;

public class TC016_NavigatetoUsers extends BaseClass {

	@Test
	public void NavigatetoUsers() {

		LoginPage loginpage = new LoginPage(driver);
		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("Admin");
		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword("admin123");
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();

		DashBoardPage dashboardpage = new DashBoardPage(driver);
		waitForElementTobeVisible(dashboardpage.return_admin());
		dashboardpage.clickOn_admin();

		AdminPage adminpage = new AdminPage(driver);

		Assert.assertTrue(adminpage.getUserRowCount() > 1);
	}

}

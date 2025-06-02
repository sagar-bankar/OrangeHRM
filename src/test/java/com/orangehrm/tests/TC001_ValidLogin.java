package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;



public class TC001_ValidLogin extends BaseClass {

	@Test
	public void ValidLogin() {

		LoginPage loginpage = new LoginPage(driver);
		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("Admin");
		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword("admin123");
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();

		DashBoardPage dashboardpage = new DashBoardPage(driver);
		waitForElementTobeVisible(dashboardpage.return_Dashboardelement());
		Assert.assertTrue(dashboardpage.isDisplayed_Dashboardelement());
	}

}

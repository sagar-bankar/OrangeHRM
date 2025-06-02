package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;



public class TC010_LogoutFunctionality extends BaseClass {

	@Test
	public void LogoutFunctionality() {

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
		dashboardpage.clickOn_logout();
		
		waitForElementTobeVisible(loginpage.return_submitbtn());
		
		Assert.assertTrue(loginpage.isVisible_submitbtn());
	}

}

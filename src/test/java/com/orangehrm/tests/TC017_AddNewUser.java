package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AddUserPage;
import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;

public class TC017_AddNewUser extends BaseClass {

	@Test
	public void AddNewUser() throws InterruptedException {

		// Login to admin page
		LoginPage loginpage = new LoginPage(driver);
		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("Admin");
		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword("admin123");
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();

		// DashboardPage
		DashBoardPage dashboardpage = new DashBoardPage(driver);

		waitForElementTobeVisible(dashboardpage.return_admin());
		dashboardpage.clickOn_admin();
		System.out.println("we all on add user page");

		//Thread.sleep(9000);
		
		// AdminPage here
		AdminPage adminpage = new AdminPage(driver);
		
		waitForElementTobeVisible(adminpage.return_addbtn());
		adminpage.clickOnaddBtn();
		
		// AddUserPage
		AddUserPage addUserpage = new AddUserPage(driver);
		Thread.sleep(9000);
		
		//waitForElementTobeVisible(addUserpage.returnUserRoleAdmin());
		//addUserpage.clickonUserRoleAdmin();
//		waitForElementTobeVisible(addUserpage.returnUserRoleDropdown());
//		addUserpage.selectUserRole("Admin");
		
		Thread.sleep(9000);

		waitForElementTobeVisible(addUserpage.returnstatusDropdown());
		addUserpage.selectStatus("Enabled");

		Thread.sleep(9000);
		
		waitForElementTobeVisible(addUserpage.returnEmployeeNameInput());
		addUserpage.setEmployeeNameInput();

		waitForElementTobeVisible(addUserpage.returnUsernameInput());
		addUserpage.sendUsernameInput("Sagar124bcd");

		waitForElementTobeVisible(addUserpage.returnPasswordInput());
		addUserpage.sendPassword("Sagartiou2@v");

		waitForElementTobeVisible(addUserpage.returnConfirmPasswordInput());
		addUserpage.sendConfirmPassword("Sagartiou2@v");

		waitForElementTobeVisible(addUserpage.returnSaveButton());
		addUserpage.clickOnSaveButton();

		// check user is present which we created by username
		waitForVisibilityOfAllElements(addUserpage.returnTotalAdduserAccount());
		addUserpage.isUsernamePresent("Sagar124bcdxcc");

		Assert.assertTrue(addUserpage.isUsernamePresent("Sagar124bcd"), "user is not present");
	}

}

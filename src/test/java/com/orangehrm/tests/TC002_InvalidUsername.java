package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;

public class TC002_InvalidUsername extends BaseClass {

	@Test
	public void InvalidUsername() {
		LoginPage loginpage = new LoginPage(driver);

		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("wronguser");
		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword("admin123");
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();

		waitForElementTobeVisible(loginpage.return_message_Invalidcredentials());
		String ActualErrormsg = loginpage.gettext_message_Invalidcredentials();
		String ExpectedErrormsg = "Invalid credentials";

		
		Assert.assertEquals(ActualErrormsg, ExpectedErrormsg);

	}

}

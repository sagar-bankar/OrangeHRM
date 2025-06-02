package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;

public class TC003_InvalidPassword extends BaseClass {

	@Test
	public void InvalidPassword() {
		LoginPage loginpage = new LoginPage(driver);

		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("Admin");
		waitForElementTobeVisible(loginpage.return_password());
		loginpage.sendPassword("wrongpass");
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();

		waitForElementTobeVisible(loginpage.return_message_Invalidcredentials());
		String ActualErrormsg = loginpage.gettext_message_Invalidcredentials();
		String ExpectedErrormsg = "Invalid credentials";

		
		Assert.assertEquals(ActualErrormsg, ExpectedErrormsg);

	}

}

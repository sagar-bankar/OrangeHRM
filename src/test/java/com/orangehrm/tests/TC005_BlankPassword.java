package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;

public class TC005_BlankPassword extends BaseClass {

	@Test
	public void BlankPassword() {
		LoginPage loginpage = new LoginPage(driver);

		waitForElementTobeVisible(loginpage.return_username());
		loginpage.sendUsername("Admin");
		waitForElementTobeVisible(loginpage.return_password());
	
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();

		waitForElementTobeVisible(loginpage.return_Required());
		boolean ActualErrormsg = loginpage.isVisible_Required();

		Assert.assertTrue(ActualErrormsg);

	}

}

package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;

public class TC006_BothFieldsBlank extends BaseClass {

	@Test
	public void BothFieldsBlank() {
		LoginPage loginpage = new LoginPage(driver);

		waitForElementTobeVisible(loginpage.return_username());
		
		waitForElementTobeVisible(loginpage.return_password());
	
		waitForElementTobeVisible(loginpage.return_submitbtn());
		loginpage.clickOnSubmitbtn();

		waitForElementTobeVisible(loginpage.return_Required());
		boolean ActualErrormsg = loginpage.isVisible_Required();

		Assert.assertTrue(ActualErrormsg);

	}

}

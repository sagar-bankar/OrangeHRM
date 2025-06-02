package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// locators
	@FindBy(name="username")
	private WebElement username;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement submitbtn;
	
	@FindBy(xpath="//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")
	private WebElement message_Invalidcredentials;

	@FindBy(xpath="//*[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
	private WebElement Required;
	// Return locators
	public WebElement return_username() {
		return username;
	}

	public WebElement return_password() {
		return password;
	}

	public WebElement return_submitbtn() {
		return submitbtn;
	}
	
	public WebElement return_message_Invalidcredentials() {
		return message_Invalidcredentials;
	}
	
	public WebElement return_Required() {
		return Required;
	}

	// Actions on method
	public void sendUsername(String user) {
		username.sendKeys(user);

	}

	public void sendPassword(String pass) {
		password.sendKeys(pass);

	}

	public void clickOnSubmitbtn() {
		submitbtn.click();
	}
	
	public String gettext_message_Invalidcredentials() {
		return message_Invalidcredentials.getText();
	}
	
	public boolean isVisible_Required() {
		return Required.isDisplayed();
	}
	
	public boolean isVisible_submitbtn() {
		return submitbtn.isDisplayed();
	}
}

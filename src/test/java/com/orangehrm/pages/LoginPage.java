package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.tests.BaseClass;

public class LoginPage extends BaseClass {

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
		scrollIntoView(username);
		waitForElementTobeVisible(username);
		username.sendKeys(user);

	}

	public void sendPassword(String pass) {
		scrollIntoView(password);
		waitForElementTobeVisible(password);
		password.sendKeys(pass);

	}

	public void clickOnSubmitbtn() {
		scrollIntoView(submitbtn);
		waitForElementTobeVisible(submitbtn);
		submitbtn.click();
	}
	
	public String gettext_message_Invalidcredentials() {
		scrollIntoView(message_Invalidcredentials);
		waitForElementTobeVisible(message_Invalidcredentials);
		return message_Invalidcredentials.getText();
	}
	
	public String getErrorTestOfRequired() {
		scrollIntoView(Required);
		waitForElementTobeVisible(Required);
		return Required.getText();
	}
	
	public boolean isVisible_Required() {
		scrollIntoView(Required);
		waitForElementTobeVisible(Required);
		return Required.isDisplayed();
	}
	
	public boolean isVisible_submitbtn() {
		scrollIntoView(submitbtn);
		return submitbtn.isDisplayed();
	}
}

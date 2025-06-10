package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {
	WebDriver driver;

	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// locators
//	@FindBy(xpath = "//label[text()='User Role']/following::div[1]")
//	private WebElement userRoleDropdown;

//	@FindBy(xpath = "//div[text()='-- Select --']")
//	private WebElement userRoleDropdown;

//	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active oxd-select-text--error']")
//	private WebElement userRoleDropdown;

	@FindBy(xpath="//label[text()='User Role']/following::div[@class='oxd-select-text'][1]")
	private WebElement userRoleDropdown;
	
	@FindBy(xpath="//div[contains(text(),'Admin')]") 
	 private WebElement userRoleAdmin;
	
	@FindBy(xpath = "//label[text()='Status']/following::div[1]")
	private WebElement statusDropdown;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employeeNameInput;

	@FindBy(xpath = "//*[text()='Username']/following::div[1]")
	private WebElement usernameInput;

	@FindBy(xpath = "//*[text()='Password']/following::div[1]")
	private WebElement passwordInput;

	@FindBy(xpath = "//*[text()='Confirm Password']/following::input[@type=\"password\"]")
	private WebElement confirmPasswordInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@alt=\"profile picture\"]/following::p[1]")
	private WebElement profileName;

	@FindBy(xpath = "//div[@role=\"table\"]/div[2]/div")
	private List<WebElement> totalAdduserAccount;

	// <----- Return ------->
	public WebElement returnUserRoleDropdown() {
		return userRoleDropdown;
	}

	public WebElement returnstatusDropdown() {
		return statusDropdown;
	}

	public WebElement returnEmployeeNameInput() {
		return employeeNameInput;
	}

	public WebElement returnUsernameInput() {
		return usernameInput;
	}

	public WebElement returnPasswordInput() {
		return passwordInput;
	}

	public WebElement returnConfirmPasswordInput() {
		return confirmPasswordInput;
	}

	public WebElement returnSaveButton() {
		return saveButton;
	}

	public WebElement returnProfileName() {
		return profileName;
	}

	public List<WebElement> returnTotalAdduserAccount() {
		return totalAdduserAccount;
	}
	
	public WebElement returnUserRoleAdmin() {
		return userRoleAdmin;
	}

	// Actions
	public void clickonUserRoleAdmin() {
		userRoleAdmin.click();
	}
	public void selectUserRole(String userRoleText) {
		userRoleDropdown.click();
//		String xpath = "//div[@role='listbox']//span[text()='" + userRoleText + "']";
//		driver.findElement(By.xpath(xpath)).click();

	}

	public void selectStatus(String statusText) {
		statusDropdown.click();
		String xpath = "//div[@role='listbox']//span[text()='" + statusText + "']";
		driver.findElement(By.xpath(xpath)).click();
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public void setEmployeeNameInput() {
		employeeNameInput.sendKeys(getProfileName());
	}

	public void sendUsernameInput(String userName) {
		usernameInput.sendKeys(userName);
	}

	public void sendPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void sendConfirmPassword(String ConfirmPassword) {
		confirmPasswordInput.sendKeys(ConfirmPassword);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public boolean isUsernamePresent(String expectedUsername) {
		for (WebElement row : totalAdduserAccount) {
			if (row.getText().contains(expectedUsername)) {
				return true;
			}
		}
		return false;

	}

}

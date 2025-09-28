package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.tests.BaseClass;

public class AdminPage extends BaseClass {
	WebDriver driver;
	// constructor
	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// locators
	@FindBy(xpath = "//div[@class=\"orangehrm-container\"]/div/div/div")
	private List<WebElement> Dashboardelement;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement add;

	// Return
	public List<WebElement> retturn_Dashboardelement() {
		return Dashboardelement;
	}

	public WebElement return_addbtn() {
		
		return add;
	}

	// Actions
	public int getUserRowCount() {
		
		return Dashboardelement.size();
	}

	public void clickOnaddBtn() {
		scrollIntoView(add);
		waitForElementTobeVisible(add);
		add.click();
	}

}

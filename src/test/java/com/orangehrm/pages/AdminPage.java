package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// locators
	@FindBy(xpath = "//div[@class=\"orangehrm-container\"]/div/div/div")
	private List<WebElement> Dashboardelement;

	// Return
	public List<WebElement> retturn_Dashboardelement() {
		return Dashboardelement;
	}

	// Actions
	public int getUserRowCount() {
		return Dashboardelement.size();
	}

}

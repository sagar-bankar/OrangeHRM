package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// locators
	@FindBy(xpath = "//*[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
	private WebElement Dashboardelement;

	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']") 
	private WebElement qAEngineer_dropdownbtn;
	
	@FindBy(xpath="//a[normalize-space()='Logout']") 
	 private WebElement logout;
	
	@FindBy(xpath="//button[@title='Assign Leave']//*[name()='svg']//*[name()='g' and contains(@fill,'currentCol')]//*[name()='path' and contains(@class,'cls-1')]") 
	 private WebElement assignLeave;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']//div[6]") 
	 private WebElement myTimesheet;
	
	@FindBy(xpath="//*[@class=\"oxd-sidepanel-body\"]/ul/li") 
	 private WebElement admin;
	
	// Return locators
	public WebElement return_Dashboardelement() {
		return Dashboardelement;
	}
	
	public WebElement return_qAEngineer_dropdownbtn() {
		return qAEngineer_dropdownbtn;
	}
	
	public WebElement return_assignLeave() {
		return assignLeave;
	}
	
	public WebElement return_logout() {
		return logout;
	}
	
	public WebElement return_myTimesheet() {
		return myTimesheet;
	}
	
	public WebElement return_admin() {
		return admin;
	}

	// Actions on method
	public boolean isDisplayed_Dashboardelement() {
		return Dashboardelement.isDisplayed();

	}
	
	public void clickOn_qAEngineer_dropdownbtn() {
		qAEngineer_dropdownbtn.click();
	}
	
	public void clickOn_logout() {
		logout.click();
	}
	
	public boolean isVisible_assignLeave() {
		return assignLeave.isDisplayed();
	}
	
	public boolean isVisible_myTimesheet() {
		return myTimesheet.isDisplayed();
	}
	
	public boolean isVisible_logout() {
		return logout.isDisplayed();
	}
	
	public void clickOn_admin() {
		admin.click();
	}

}

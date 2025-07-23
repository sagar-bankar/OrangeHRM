package com.orangehrm.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	private static ThreadLocal<WebDriver> ldriver = new ThreadLocal<>();
	private static ThreadLocal<WebDriverWait> lwait = new ThreadLocal<>();

	// public static WebDriver driver;
	WebDriver driver = null; // ✅ Local variable, NOT the global one
	// public WebDriverWait wait;
	WebDriverWait wait =null;
	public Logger logger;

	public void setDriver(WebDriver driver) {
		ldriver.set(driver);
	}

	public WebDriver getDriver() {
		if (ldriver.get() == null) {
			return driver;
		}
		return ldriver.get();
	}

	public void setWait(WebDriverWait wait) {
		lwait.set(wait);
	}

	public WebDriverWait getWait() {
		return lwait.get();
	}

	@Parameters({ "os", "browser" })
	@BeforeClass
	public void setuP(String os, String browser) {
		
		// String browser = "chrome";
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Brouser is not valid");

		}
		setDriver(driver);
		// ExtentReport_OrangeHRM.getTest().info("Browser launched successfully.");

		// wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		setWait(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
		logger = LogManager.getLogger(this.getClass());

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	public void waitForElementTobeVisible(WebElement webelement) {
		// wait.until(ExpectedConditions.visibilityOf(webelement));
		getWait().until(ExpectedConditions.visibilityOf(webelement));

	}

	public void waitForVisibilityOfAllElements(List<WebElement> webelement) {
		// .until(ExpectedConditions.visibilityOfAllElements(webelement));
		getWait().until(ExpectedConditions.visibilityOfAllElements(webelement));
	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Workspaces\\30-10-2024 On words\\OrangeHRM\\Screenshots\\" + tname + "" + timeStamp + ".png";
		File des = new File(path);

		// FileHandler.copy(src, des);
		src.renameTo(des);
		return path;
	}

	@AfterClass
	public void tearDown() {
		getDriver().quit();
		ldriver.remove();
		lwait.remove();
		// ExtentReport_OrangeHRM.getTest().info("Browser closed.");
	}

}

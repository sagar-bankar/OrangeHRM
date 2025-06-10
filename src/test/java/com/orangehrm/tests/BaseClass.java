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

import com.orangehrm.utils.ExtentReport_OrangeHRM;

public class BaseClass {
	public static WebDriver driver;
	public WebDriverWait wait;
	public Logger logger;

	@BeforeClass
	public void setuP() {
		String browser = "chrome";
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
		//ExtentReport_OrangeHRM.getTest().info("Browser launched successfully.");
		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		logger = LogManager.getLogger(this.getClass());

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	public void waitForElementTobeVisible(WebElement webelement) {
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	
	public void waitForVisibilityOfAllElements(List<WebElement> webelement) {
		wait.until(ExpectedConditions.visibilityOfAllElements(webelement));
	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Workspaces\\30-10-2024 On words\\OrangeHRM\\Screenshots\\" + tname + "" + timeStamp + ".png";
		File des = new File(path);

		// FileHandler.copy(src, des);
		src.renameTo(des);
		return path;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		//ExtentReport_OrangeHRM.getTest().info("Browser closed.");
	}

}

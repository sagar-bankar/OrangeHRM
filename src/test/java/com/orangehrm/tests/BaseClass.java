package com.orangehrm.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {

    private static ThreadLocal<WebDriver> ldriver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> lwait = new ThreadLocal<>();

    public Logger logger;
    public static Properties p;

    // ----------------- Driver / Wait Getters -----------------
    public void setDriver(WebDriver driver) {
        ldriver.set(driver);
    }

    public WebDriver getDriver() {
        return ldriver.get();
    }

    public void setWait(WebDriverWait wait) {
        lwait.set(wait);
    }

    public WebDriverWait getWait() {
        return lwait.get();
    }

    // ----------------- Config Load -----------------
    @BeforeSuite(alwaysRun = true)
    public void loadConfig() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
        FileReader file = new FileReader(filePath);
        p = new Properties();
        p.load(file);
        file.close();
    }

    // ----------------- Browser Setup -----------------
    @Parameters({ "os", "browser" })
    @BeforeClass(alwaysRun = true)
    public void setuP(String os, String browser) {
        WebDriver driver = null;

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
                throw new RuntimeException("Browser not valid: " + browser);
        }

        setDriver(driver);
        setWait(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));

        logger = LogManager.getLogger(this.getClass());

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(p.getProperty("OrangeHRM_URL"));
    }

    // ----------------- Utilities -----------------
    public void waitForElementTobeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfAllElements(List<WebElement> elements) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void scrollIntoView(WebElement element) {
        ((org.openqa.selenium.JavascriptExecutor) getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timeStamp + ".png";
        File des = new File(path);
        src.renameTo(des);

        return path;
    }

    // ----------------- Tear Down -----------------
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        ldriver.remove();
        lwait.remove();
    }
}

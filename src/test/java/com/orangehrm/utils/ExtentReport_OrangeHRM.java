package com.orangehrm.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.tests.BaseClass;

public class ExtentReport_OrangeHRM implements ITestListener {

	// Declare ExtentReports and ExtentTest objects

	private ExtentReports extent;
	private ExtentTest test;

	public void onStart(ITestContext context) {
		// This method is called before any test method is run
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time stamp
		String reportFileName = "OrangeHRM-Extent-report-" + timeStamp + ".html"; // Report file name

		// Initialize ExtentSparkReporter with the path where the report will be saved
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
				"C:\\Workspaces\\30-10-2024 On words\\OrangeHRM\\Reports\\" + reportFileName);
		htmlReporter.config().setDocumentTitle("OrangeHRM Report"); // Title of the report
		htmlReporter.config().setReportName("Functional Test Report"); // Name of the report
		
		
		// htmlReporter.config().setTheme(Theme.STANDARD); // Theme of the report
		htmlReporter.config().setTheme(Theme.DARK); // Theme of the report

		// Initialize ExtentReports and attach the reporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Set additional information about the environment
		// extent.setSystemInfo("Host Name", "Your Host Name");
		// extent.setSystemInfo("Environment", "QA");
		// extent.setSystemInfo("User Name", "SAGAR BANKAR");

		// Infosys level doc
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Client", "OrangeHRM");
		extent.setSystemInfo("Java Version", "1.8/11");
		extent.setSystemInfo("Build URL", "OrangeHRM");
		extent.setSystemInfo("Host Name", "Jenkins_Agent_01");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Executed By", "SAGAR BANKAR");

	}

	public void onTestStart(ITestResult result) {
		// This method is called when a test starts
		test = extent.createTest(result.getTestClass().getName()); // Create a new test in the report
	}

	public void onTestSuccess(ITestResult result) {
		// This method is called when a test is successful
		test.pass("Test Passed"); // Log a pass message in the report
	}

	public void onTestFailure(ITestResult result) {
		// This method is called when a test fails
		test.fail(result.getThrowable()); // Log the failure exception in the report

		// BaseClass baseclass=new BaseClass();

		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			test.warning("Screenshot capture failed: " + e.getMessage());
		} catch (Exception e) {
			test.warning("Unexpected error while capturing screenshot: " + e.getMessage());
		}

	}

	public void onTestSkipped(ITestResult result) {
		// This method is called when a test is skipped
		test.skip(result.getThrowable()); // Log the skip exception in the report
	}

	public void onFinish(ITestContext context) {
		// This method is called after all test methods have been run
		extent.flush(); // Write the test results to the report
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// This method is called for tests that fail but are within the success
		// percentage defined in TestNG
		// Not commonly used, so implementation can be skipped or customized as needed
	}
}

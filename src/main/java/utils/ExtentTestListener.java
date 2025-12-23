package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;

public class ExtentTestListener extends BaseTest implements ITestListener {
	ExtentReports extent =
	        ExtentReportManager.getReportInstance();

	    ExtentTest test;

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.fail(result.getThrowable());
	        ScreenShotUtils.takeScreenshot(
	            driver, result.getMethod().getMethodName());
	    }
	   
	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
}

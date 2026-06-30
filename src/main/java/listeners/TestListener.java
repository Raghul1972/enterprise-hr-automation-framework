package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utilities.ScreenshotUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;

public class TestListener implements ITestListener {

	ExtentReports extent =
	        ExtentManager.getExtent();

	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {

	    test = extent.createTest(result.getName());

	    System.out.println("Test Started : "
	            + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	    test.pass("Test Passed");

	    System.out.println("Test Passed : "
	            + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

	    test.fail(result.getThrowable());

	    result.getThrowable().printStackTrace();
	    System.out.println(result.getThrowable().getMessage());

	    System.out.println("Test Failed : " + result.getName());

	    String path = ScreenshotUtils.captureScreenshot(
	            BaseTest.driver,
	            result.getName());

	    System.out.println("Screenshot Saved : " + path);
	}
	
	@Override
	public void onFinish(ITestContext context) {

	    extent.flush();

	    System.out.println("Execution Finished");

	}

}
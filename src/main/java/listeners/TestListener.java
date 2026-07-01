package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driver.DriverFactory;
import utilities.ExtentManager;
import utilities.LoggerUtils;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

	ExtentReports extent =
	        ExtentManager.getExtent();

	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {

	    test = extent.createTest(result.getName());

	    LoggerUtils.logger.info("Test Started : "
	            + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	    test.pass("Test Passed");

	    LoggerUtils.logger.info("Test Passed : "
	            + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

	    test.fail(result.getThrowable());

	    result.getThrowable().printStackTrace();
	    LoggerUtils.logger.info(result.getThrowable().getMessage());

	    LoggerUtils.logger.info("Test Failed : " + result.getName());

	    String path = ScreenshotUtils.captureScreenshot(
	            DriverFactory.getDriver(),
	            result.getName());

	    LoggerUtils.logger.info("Screenshot Saved : " + path);
	}
	
	@Override
	public void onFinish(ITestContext context) {

	    extent.flush();

	    LoggerUtils.logger.info("Execution Finished");

	}

}
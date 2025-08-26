package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    private static final ExtentReports extent = ExtentReporterNG.extentReportGenerator();
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extentTest.get();
        test.log(Status.PASS, "✅ Test Passed");
        // Capture and attach screenshot on success
        try {
            String screenshotPath = Screenshot.captureScreenshot(BaseClass.getDriver(), result.getMethod().getMethodName() + "_success");
            test.pass("Screenshot on Success",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            test.log(Status.WARNING, "Could not attach success screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTest.get();
        test.log(Status.FAIL, "❌ Test Failed");
        test.fail(result.getThrowable());

        // Capture and attach screenshot on failure
        try {
            String screenshotPath = Screenshot.captureScreenshot(BaseClass.getDriver(), result.getMethod().getMethodName() + "_failure");
            test.fail("Screenshot on Failure",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            test.log(Status.WARNING, "Could not attach failure screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extentTest.get();
        test.log(Status.SKIP, "⚠️ Test Skipped");
        if (result.getThrowable() != null) {
            test.skip(result.getThrowable());
        }
        // Optionally, capture screenshot on skip
        try {
            String screenshotPath = Screenshot.captureScreenshot(BaseClass.getDriver(), result.getMethod().getMethodName() + "_skipped");
            test.skip("Screenshot on Skip",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            test.log(Status.WARNING, "Could not attach skip screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    // Unused overrides
    @Override public void onStart(ITestContext context) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onTestFailedWithTimeout(ITestResult result) {}
}

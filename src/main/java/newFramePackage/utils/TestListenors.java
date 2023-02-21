package newFramePackage.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import newFramePackage.core.BaseConfig;
import newFramePackage.management.CaptureManager;
import newFramePackage.management.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenors implements ITestListener{
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;

    @Override
    public void onFinish(ITestContext result) {
        Log.info("");
        Log.info("################### Running Completed! ###################");
        extent.flush();
    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("################### Starting automation Test! ###################");
        htmlReporter = new ExtentHtmlReporter("OutPut/Report/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("#######  Testcase is failed: " + result.getName() + " #######");
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CaptureManager.getCapture(new BaseConfig().getDriver(), result.getName());
            } catch (Exception e) {
                Log.info("Exception while taking screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("#######  Testcase is skipped: " + result.getName() + " #######");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("#######  Testcase is passed: " + result.getName() + " #######");
    }

}

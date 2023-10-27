package utils;

import core.WebDriverCore;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

    @Override
    public void onFinish(ITestContext result) {
        Logs.warn("#".repeat(5) + " FINISHED! " + "#".repeat(5));
    }

    @Override
    public void onStart(ITestContext result) {
        Logs.warn("#".repeat(5) + " STARTING! " + "#".repeat(5));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.error("#".repeat(5) + " FAILED TCs: " + result.getName() + " " + "#".repeat(5));
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CameraCapture.getCapture(new WebDriverCore().getDriver(), result.getName());
            } catch (Exception e) {
                Logs.info("Exception while taking screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.warn("#".repeat(5) + " SKIPPED TCs: " + result.getName() + " " + "#".repeat(5));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("#".repeat(5) + " PASSED TCs: " + result.getName() + " " + "#".repeat(5));
    }
}

package BaseConfig;

import management.CaptureManager;
import management.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenors implements ITestListener {
    @Override
    public void onFinish(ITestContext result) {
        Log.info("");
        Log.info("################### Running Completed! ###################");
    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("Starting automation Test!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("  Testcase is failed: " + result.getName());
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
        Log.info("  Testcase is skipped: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("  Testcase is passed: " + result.getName());
    }

}

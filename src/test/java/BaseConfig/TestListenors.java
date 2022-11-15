package BaseConfig;

import management.CaptureManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenors implements ITestListener {
    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Automation Test is Finished!");
    }

    @Override
    public void onStart(ITestContext result) {
        System.out.println("Starting automation Test!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Testcase is failed: " + result.getName());
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CaptureManager.getCapture(new BaseConfig().getDriver(), result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Testcase is skipped: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Testcase is passed: " + result.getName());
    }

}

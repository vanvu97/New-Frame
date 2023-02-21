package newFramePackage.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Date;

public class ExtentManager {

    protected ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void beforeMethod(Method method) {
        test = extent.createTest(method.getName());
    }
    @BeforeSuite
    public void beforeSuit(){
        Date date = new Date();
        String reportName = "Report_" + date.toString().replace(":", "-") + ".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/OutPut/test-output/" + reportName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed is "+result.getName());
            test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
        }
        else {
            test.log(Status.PASS, "Test Case Passed is "+result.getName());
        }
    }
    @AfterSuite
    public void afterSuit(){
        extent.flush();
    }

}

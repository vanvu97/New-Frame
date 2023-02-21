package BaseConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import newFramePackage.core.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class StartBrowse extends BaseConfig {

    protected WebDriver driver;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;
    private final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php";


    @BeforeMethod
    public void beforeMethod(Method method) {
        test = extent.createTest(method.getName());
    }
    @BeforeClass
    public void setUp(){

        htmlReporter = new ExtentHtmlReporter("OutPut/Report/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        driver = new BaseConfig().setupBrowser("edge", URL);
//        driver = new BaseConfig().setupBrowser("remote", URL);

    }

    @AfterClass
    public void tearDown(){
        extent.flush();
        driver.quit();
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

    //Remote
    //cd C:\Program Files\Google\Chrome\Application
    //chrome.exe --remote-debugging-port=9222 --user-data-dir=D:\chromedriver_\Remote


    //Edge
    //cd C:\Program Files (x86)\Microsoft\Edge\Application
    //msedge.exe --remote-debugging-port=9222 --user-data-dir=D:\edge

}

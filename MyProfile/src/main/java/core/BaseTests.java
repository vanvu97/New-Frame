package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import manage.PropertiesManager;
import org.testng.annotations.*;
import utils.TestListener;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Date;

import static utils.Logs.setExtentTest;

@Listeners(TestListener.class)
public class BaseTests extends WebDriverCore {

    protected ExtentHtmlReporter htmlReporter;
    protected static ExtentReports extent;
    protected ExtentTest test;


    @BeforeMethod
    public void beforeSuit() {
        Date date = new Date();
        String reportName = this.getClass().getSimpleName() + date.toString().replace(":", "-") + ".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "Report" + File.separator + reportName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest(this.getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName());
        setExtentTest(test);
    }

    @BeforeTest
    public void initTest() {
        PropertiesManager.setPropertiesFile();
        setupBrowser(PropertiesManager.getPropValue("browserType"));

    }

    @AfterTest
    public void endTest() {
        getDriver().close();
    }

    @AfterMethod
    public void afterSuit() {
        extent.flush();
    }

}


package BaseConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import newFramePackage.core.BaseConfig;
import newFramePackage.report.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Date;

public class StartBrowse extends ExtentManager {

    protected WebDriver driver;

    private final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php";



    @BeforeClass
    public void setUp(){
        driver = new BaseConfig().setupBrowser("edge", URL);
//        driver = new BaseConfig().setupBrowser("remote", URL);

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }


    //Remote
    //cd C:\Program Files\Google\Chrome\Application
    //chrome.exe --remote-debugging-port=9222 --user-data-dir=D:\chromedriver_\Remote


    //Edge
    //cd C:\Program Files (x86)\Microsoft\Edge\Application
    //msedge.exe --remote-debugging-port=9222 --user-data-dir=D:\edge

}

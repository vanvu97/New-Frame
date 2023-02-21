package BaseConfig;

import newFramePackage.core.BaseConfig;
import newFramePackage.management.Log;
import newFramePackage.management.PropertiesManager;
import newFramePackage.report.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class StartUp extends ExtentManager {

    protected WebDriver driver;

    private final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";

    @BeforeClass
    public void setUp() {
        Log.info("Start Browser");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //Remote
    //cd C:\Program Files\Google\Chrome\Application
    //chrome.exe --remote-debugging-port=9222 --user-data-dir=D:\chromedriver_\Remote


    //Edge
    //cd C:\Program Files (x86)\Microsoft\Edge\Application
    //msedge.exe --remote-debugging-port=9222 --user-data-dir=D:\edge

}

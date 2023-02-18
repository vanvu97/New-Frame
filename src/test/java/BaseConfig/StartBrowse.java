package BaseConfig;

import newFramePackage.core.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class StartBrowse extends BaseConfig {

    protected WebDriver driver;
    private final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php";

    @BeforeClass
    public void setUp(){

        driver = new BaseConfig().setupBrowser("chrome", URL);
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

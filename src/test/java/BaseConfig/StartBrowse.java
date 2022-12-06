package BaseConfig;

import core.BaseRemote;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class StartBrowse extends Elements{

    protected WebDriver driver;
    private final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php";

    @BeforeClass
    public void setUp(){
//        driver = new BaseConfig().setupBrowser("chrome");

        driver = new BaseRemote().setupBrowser("chrome", URL);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

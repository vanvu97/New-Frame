package BaseConfig;

import core.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class StartBrowse extends BaseConfig {

    protected WebDriver driver;
    private final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php";

    @BeforeClass
    public void setUp(){
        driver = new BaseConfig().setupBrowser("chrome", URL);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

package BaseConfig;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class StartBrowse {

    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new BaseConfig().setupBrowser("edge");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

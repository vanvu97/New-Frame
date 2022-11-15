package BaseConfig;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class startBrowse {

    protected WebDriver driver;

    public startBrowse() {
    }

    @BeforeClass
    public void setUp(){
        driver = new BaseConfig().setupBrowser("edge");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

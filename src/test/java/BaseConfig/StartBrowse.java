package BaseConfig;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class StartBrowse extends Elements{

    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new BaseRemote().setupBrowser("chrome");
    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }

}

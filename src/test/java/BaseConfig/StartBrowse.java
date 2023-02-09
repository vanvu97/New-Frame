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
<<<<<<< HEAD
        driver = new BaseConfig().setupBrowser("chrome");
=======
        driver = new BaseConfig().setupBrowser("chrome", URL);

>>>>>>> ca7e3b571490891a1c2a81ef91d247df824540b5
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

package test;

import BaseConfig.BaseConfig;
import management.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class logTest {

    private WebDriver driver;

    public logTest() {
    }


    @BeforeClass
    public void setUp(){
        driver = new BaseConfig().setupBrowser("edge");
    }

    @Test(priority = 1)
    public void login() throws InterruptedException, IOException {
        Log.info("1. Running Login");
        driver.navigate().to("https://www.google.com");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

package test;

import BaseConfig.BaseConfig;
import management.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import management.PropertiesManager;

import java.io.IOException;

public class ReadPropData {
    private WebDriver driver;
    private LoginPage login;

    private ExcelManager excel;

    @BeforeClass
    public void setUp(){
        PropertiesManager.setPropertiesFile();
        //Set up new value to run Properties rather than use an existing value in properties file
        PropertiesManager.setPropValue("browser", "firefox");
//        PropertiesManager.setPropValue("email", "text email");
//        PropertiesManager.setPropValue("password", "text password");

        driver = new BaseConfig().setupBrowser(PropertiesManager.getPropValue("browser"));
    }

    @Test
    public void readData() throws IOException, InterruptedException {
        login = new LoginPage(driver);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        login.login(PropertiesManager.getPropValue("email"), PropertiesManager.getPropValue("password"));

    }

    @AfterClass
    public void tearDown() {
        System.out.println("Run Test Completed! Closing Browser...");
        driver.quit();
    }
}

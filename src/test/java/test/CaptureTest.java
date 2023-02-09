package test;

import BaseConfig.BaseConfig;
import page.TC1_LoginPage;
import utils.TestListenors;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners(TestListenors.class)
public class CaptureTest {
    private WebDriver driver;
    private TC1_LoginPage login;
    private final String userName = "Admin";
    private final String passWord = "admin123";

    @BeforeClass
    public void setUp() {
        driver = new BaseConfig().setupBrowser("firefox");
    }

    @Test
    public void readData() throws IOException, InterruptedException {
        login = new TC1_LoginPage();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        login.login(userName, passWord);
        Assert.assertEquals(driver.getTitle(), "Test");

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

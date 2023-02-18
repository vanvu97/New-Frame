package test;

import BaseConfig.BaseConfig;
import page.TC1_LoginPage;
import newFramePackage.utils.TestListenors;
import newFramePackage.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListenors.class)
public class RepeatTest {

    int count = 0;
    private WebDriver driver;
    private TC1_LoginPage login;

    @BeforeClass
    public void setUp(){
        PropertiesManager.setPropertiesFile();
        driver = new BaseConfig().setupBrowser("firefox");
    }

    @Test (priority = 1)
    public void login() throws InterruptedException, IOException {
        login = new TC1_LoginPage();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        login.login(PropertiesManager.getPropValue("email"), PropertiesManager.getPropValue("password"));
    }

    @Test(invocationCount = 4, successPercentage = 100, priority = 2)
    public void repeatTest(){
        count++;
        System.out.println("Time run: " + count);
        if(count == 100){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

    }

}

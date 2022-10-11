package test;

import BaseConfig.BaseConfig;
import management.CaptureManager;
import management.ExcelManager;
import management.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;

import java.io.IOException;

public class CaptureTest {
    private WebDriver driver;
    private LoginPage login;

    private final String userName = "Admin";
    private final String passWord = "admin123";

    @BeforeClass
    public void setUp(){

        driver = new BaseConfig().setupBrowser("firefox");
    }

    @Test
    public void readData() throws IOException, InterruptedException {
        login = new LoginPage(driver);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        login.login(userName, passWord);
        Assert.assertEquals(driver.getTitle(), "Test");

    }

    @AfterMethod
    public void takeScreenShoot(ITestResult result) throws InterruptedException {
        Thread.sleep(1000);

       if(ITestResult.FAILURE == result.getStatus()){
           try{
               CaptureManager.getCapture(driver, result.getName());
           }catch (Exception e){
               System.out.println("Exception while taking screenshot: " + e.getMessage());
           }
       }

    }

    @AfterClass
    public void tearDown() {
        System.out.println("Run Test Completed! Closing Browser...");
        driver.quit();
    }
}

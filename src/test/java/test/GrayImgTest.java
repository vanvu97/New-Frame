package test;

import BaseConfig.BaseConfig;
import management.CaptureManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ImageTextPage;
import page.LoginPage;
import utils.GrayImage;

import java.io.IOException;

import static page.ImageTextPage.imgIn;
import static page.ImageTextPage.imgPath;
import static utils.GrayImage.setA;
import static utils.GrayImage.setB;

public class GrayImgTest {

    private WebDriver driver;
    private LoginPage login;
    private final String userName = "Admin";
    private final String passWord = "admin123";
    private ImageTextPage imgPage;

    public GrayImgTest() {
    }

    @BeforeClass
    public void setUp() {
        driver = new BaseConfig().setupBrowser("edge");
        imgPage = new ImageTextPage(driver);
    }

    @Test
    public void readData() throws IOException, InterruptedException {
        imgPage.grayImage();
        setA(imgIn);
        setB(imgPath);
//        setC(new int[]{24, 16, 8});
        GrayImage.main();

    }

    @AfterMethod
    public void takeScreenShoot(ITestResult result) throws InterruptedException {
        Thread.sleep(1000);
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CaptureManager.getCapture(driver, result.getName());
            } catch (Exception e) {
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

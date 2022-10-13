package test;

import BaseConfig.BaseConfig;
import management.CaptureManager;
import management.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.AdminPage;
import page.LoginPage;
import page.PIMPage;
import utils.ValidateAction;

import java.io.IOException;

public class OrangeTest{
    private WebDriver driver;
    private LoginPage login;
    private PIMPage pim;
    private AdminPage adminPage;

    private ValidateAction ACTIONs;

    private final String userName = "Admin";
    private final String passWord = "admin123";

    private final String firstName = "Corgi";
    private final String lastName = "Dog";

    private ExcelManager excel;


    @BeforeClass
    public void setUp(){

        driver = new BaseConfig().setupBrowser("firefox");
        excel = new ExcelManager();
        //Run extends Base then use the following code
//        WebDriver driver = getDriver();
    }

    @Test (priority = 1)
    public void login() throws InterruptedException, IOException {
        login = new LoginPage(driver);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        pim = login.login(userName, passWord);
    }
    @Test(priority = 3)
    public void adminPage() throws InterruptedException {
        adminPage = new AdminPage(driver);
        adminPage.setFirstName(firstName);
        adminPage.addUser();

    }
    @Test(priority = 2)
    public void pimPage() throws InterruptedException {
        pim.setFirstName(firstName);
        pim.setLastName(lastName);
        adminPage = pim.addNewEmployees();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Run Test Completed! Closing Browser...");
        driver.quit();
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


}

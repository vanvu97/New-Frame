package test;

<<<<<<< HEAD
import BaseConfig.StartBrowse;
import BaseConfig.TestListenors;
import management.Log;
import org.testng.Assert;
=======
import BaseConfig.BaseConfig;
import management.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
>>>>>>> b35c4638db9b0491929b7b45d5ad7998316e460b
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.AdminPage;
import page.LoginPage;
import page.PIMPage;
import management.Log;
import utils.ValidateAction;
import BaseConfig.TestListenors;

import java.io.IOException;

@Listeners(TestListenors.class)
<<<<<<< HEAD
public class OrangeTest extends StartBrowse {
=======
public class OrangeTest{
    private WebDriver driver;
>>>>>>> b35c4638db9b0491929b7b45d5ad7998316e460b
    private LoginPage login;
    private PIMPage pim;
    private AdminPage adminPage;

    private ValidateAction ACTIONs;

    private final String userName = "Admin";
    private final String passWord = "admin123";

    private final String firstName = "Corgi";
    private final String lastName = "Dog";

<<<<<<< HEAD
=======
    private ExcelManager excel;
>>>>>>> b35c4638db9b0491929b7b45d5ad7998316e460b


    @BeforeClass
    public void setUp(){
        driver = new BaseConfig().setupBrowser("edge");
        excel = new ExcelManager();
    }

    @Test (priority = 1)
    public void login() throws InterruptedException, IOException {
        Log.info("1. Running Login");
        login = new LoginPage(driver);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        pim = login.login(userName, passWord);
<<<<<<< HEAD
        Assert.assertEquals(driver.getTitle(), "OrangeHRM1");
=======
>>>>>>> b35c4638db9b0491929b7b45d5ad7998316e460b
    }
    @Test(priority = 3)
    public void adminPage() throws InterruptedException {
        Log.info("3. Running adminPage");
        adminPage = new AdminPage(driver);
        adminPage.setFirstName(firstName);
        adminPage.addUser();

    }
    @Test(priority = 2)
    public void pimPage() throws InterruptedException {
        Log.info("2. Running pimPage");
        pim.setFirstName(firstName);
        pim.setLastName(lastName);
        adminPage = pim.addNewEmployees();
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

}
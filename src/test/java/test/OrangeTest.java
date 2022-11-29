package test;

import BaseConfig.StartBrowse;
import BaseConfig.TestListenors;
import management.ExcelManager;
import management.Log;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.AdminPage;
import page.LoginPage;
import page.PIMPage;
import page.PerformancePage;

import java.io.IOException;

@Listeners(TestListenors.class)
public class OrangeTest extends StartBrowse {

    private LoginPage login;
    private PIMPage pim;
    private AdminPage adminPage;
    private PerformancePage performancePage;
    private final String userName = "Admin";
    private final String passWord = "admin123";
    private final String firstName = "Corgi";
    private final String lastName = "Dog";


    private ExcelManager excel;


    @Test(priority = 1, testName = "Test Case 1")
    public void login() throws InterruptedException, IOException {
        Log.info("1. Running Login");
        login = new LoginPage(driver);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        pim = login.login(userName, passWord);
        Assert.assertEquals(driver.getTitle(), "Test");
    }

    @Test(priority = 2, testName = "Test Case 2")
    public void pimPage() throws InterruptedException {
        Log.info("2. Running pimPage");
        Log.info("3. Adding New Employee!");
        pim.setFirstName(firstName);
        pim.setLastName(lastName);
        adminPage = pim.addNewEmployees();
    }

    @Test(priority = 3, testName = "Test Case 3")
    public void adminPage() throws InterruptedException {
        Log.info("4. Running adminPage");
        adminPage.setFirstName(firstName);
        Log.info("5. Adding New User!");
        adminPage.addUser();
        performancePage = adminPage.getListUser();
    }

    @Test(priority = 4, testName = "Test Case 4")
    public void performancePage() throws InterruptedException {
        performancePage = new PerformancePage(driver);
        login = new LoginPage(driver);
        Log.info("5. Checking Performance");
        performancePage.selectPerformance();
        performancePage.selectFromDate();
    }
}

package test;


import BaseConfig.StartBrowse;
import BaseConfig.TestListenors;
import management.Log;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.AdminPage;
import page.LoginPage;
import page.PIMPage;

import java.io.IOException;

@Listeners(TestListenors.class)
public class OrangeTest extends StartBrowse {

    private LoginPage login;
    private PIMPage pim;
    private AdminPage adminPage;

    private final String userName = "Admin";
    private final String passWord = "admin123";

    private final String firstName = "Corgi";
    private final String lastName = "Dog";


    @Test(priority = 1)
    public void login() throws InterruptedException, IOException {
        Log.info("1. Running Login");
        login = new LoginPage(driver);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        pim = login.login(userName, passWord);
        Assert.assertEquals(driver.getTitle(), "OrangeHRM1");
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
}
package test;


import BaseConfig.StartBrowse;
import BaseConfig.TestListenors;
import management.Log;
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
        pim = login.login(userName, passWord);
    }

    @Test(priority = 2)
    public void pimPage() throws InterruptedException {
        pim = new PIMPage(driver);
        Log.info("2. Running pimPage");
        pim.setFirstName(firstName);
        pim.setLastName(lastName);
        adminPage = pim.addNewEmployees();
    }

    @Test(priority = 3)
    public void adminPage() throws InterruptedException {
        adminPage = new AdminPage(driver);
        Log.info("3. Running adminPage");
        adminPage.setFirstName(firstName);
        Log.info("4. Adding New User!");
//        adminPage.addUser();
        adminPage.verifyUser();
    }



}
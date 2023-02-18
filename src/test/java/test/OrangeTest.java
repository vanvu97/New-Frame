package test;


import BaseConfig.StartBrowse;
import newFramePackage.ExcelManager;
import page.TC1_LoginPage;
import newFramePackage.utils.TestListenors;
import newFramePackage.Log;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.TC3_AdminPage;
import page.TC2_PIMPage;

import java.io.IOException;

@Listeners(TestListenors.class)
public class OrangeTest extends StartBrowse {

    private TC1_LoginPage login;
    private TC2_PIMPage pim;
    private TC3_AdminPage adminPage;

    private final String userName = "Admin";
    private final String passWord = "admin123";

    private final String firstName = "Corgi";
    private final String lastName = "Dog";

    private ExcelManager excel;

    @Test(priority = 1, testName = "TC1_Check Login")
    public void login() throws InterruptedException, IOException {
        Log.info("1. Running Login");
        login = new TC1_LoginPage();
        pim = login.login(userName, passWord);
    }

    @Test(priority = 2, testName = "TC2_Check PIM - Add New Employees")
    public void pimPage() throws InterruptedException {
        pim = new TC2_PIMPage();
        Log.info("2. Running pimPage");
        pim.setFirstName(firstName);
        pim.setLastName(lastName);
        adminPage = pim.addNewEmployees();
    }

    @Test(priority = 3, testName = "TC3_Check AdminPage - Add New User")
    public void adminPage() throws InterruptedException {
        adminPage = new TC3_AdminPage();
        Log.info("3. Running adminPage");
        adminPage.setEmployName(firstName);
        adminPage.addUser();
//        adminPage.addUser();
    }


}
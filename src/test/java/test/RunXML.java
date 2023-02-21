package test;

import BaseConfig.Bases;
import newFramePackage.utils.TestListenors;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.LoginPage;

@Listeners(TestListenors.class)
public class RunXML extends Bases {
    private LoginPage login;

    private final String userName = "Admin";
    private final String passWord = "admin123";


    @Test (testName = "Login Test!")
    public void login() throws InterruptedException {
        login = new LoginPage(driver);
        login.login(userName, passWord);
    }


}

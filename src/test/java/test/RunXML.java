package test;

import BaseConfig.Base;
import BaseConfig.StartBrowse;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import page.TC1_LoginPage;

public class RunXML extends Base {
    private LoginPage login;

    private final String userName = "Admin";
    private final String passWord = "admin123";


    @Test
    public void login() throws InterruptedException {
        login = new LoginPage(driver);
        login.login(userName, passWord);
    }


}

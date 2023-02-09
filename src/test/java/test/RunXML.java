package test;

import BaseConfig.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.TC1_LoginPage;

public class RunXML extends Base{
    private TC1_LoginPage login;

    private final String userName = "Admin";
    private final String passWord = "admin123";

    @BeforeClass
    public void setUp(){
        //Run extends Base then use the following code
        WebDriver driver = getDriver();
    }

    @Test
    public void login() throws InterruptedException {
        login = new TC1_LoginPage();
        login.login(userName, passWord);
    }


}

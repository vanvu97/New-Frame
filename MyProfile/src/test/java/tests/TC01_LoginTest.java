package tests;

import core.BaseTests;
import manage.PropertiesManager;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.IOException;


public class TC01_LoginTest extends BaseTests {
    @Test(description = "Login with Admin account!")
    public void loginTest() throws IOException {
        String username = PropertiesManager.getPropValue("username");
        String password = PropertiesManager.getPropValue("password");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.goToURL();
        loginPage.loginWeb(username, password)
                .verifyLoginSuccessful();
    }
}

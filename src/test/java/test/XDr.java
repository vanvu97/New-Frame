package test;

import core.Button;
import org.testng.Assert;

public class XDr extends Button {
    String username = "name//username";
    String password = "name//password";
    String loginBtn = "xpath//button";

    public void Login() {
        sendKeys(username, "Admin");
        sendKeys(password, "admin123");
        click(loginBtn);
        Assert.assertEquals(getDriver().getTitle(), "Test");
    }

}

package test;

import core.Button;
import management.Log;
import org.testng.Assert;

public class XDr{
    String username = "name//username";
    String password = "name//password";
    String loginBtn = "xpath//button";
    Button btn = new Button();
    public void Login() {
        Log.info("Input Username and Password");
        btn.sendKey(username, "Admin");
        btn.sendKey(password, "admin123");
        Log.info("Click Login button");
        btn.clickBtn(loginBtn);
        Log.info("Assert Title!");
        Assert.assertEquals(btn.getDriver().getTitle(), "Test");
    }

}

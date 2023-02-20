package page;

import BaseConfig.Interface;
import newFramePackage.management.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import newFramePackage.utils.ValidateAction;

import java.time.Duration;

public class LoginPage extends Interface {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(second_10s));
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public TC2_PIMPage login(String username, String password) throws InterruptedException {
        ACTIONs.waitForPageLoad();
        ACTIONs.verifyPageURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        ACTIONs.setTextWeb(userNames, username);
        Log.info("Username: " + userNames);
        ACTIONs.setTextWeb(this.password, password);
        Log.info("Password: " + password);
        ACTIONs.clickElementWeb(loginBtn);
        Assert.assertTrue(ACTIONs.verifyPageTitle("OrangeHRM"), "Incorrect Page Title!");
        return new TC2_PIMPage();
    }

}

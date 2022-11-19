package page;

import BaseConfig.Interface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ValidateAction;

import java.time.Duration;

public class LoginPage extends Interface {

    @FindBy(name = "username")
    WebElement userNames;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span")
    WebElement pageHeader;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(second_10s));
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public PIMPage login(String username, String password) throws InterruptedException {
        ACTIONs.waitForPageLoad();
        ACTIONs.verifyPageURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        ACTIONs.setWebElementText(userNames, username);
        ACTIONs.setWebElementText(this.password, password);
        ACTIONs.clickWebElement(loginBtn);
        Assert.assertTrue(ACTIONs.verifyPageTitle("OrangeHRM"), "Incorrect Page Title!");

        return new PIMPage(driver);
    }

}

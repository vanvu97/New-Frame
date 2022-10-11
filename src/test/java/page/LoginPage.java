package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ValidateAction;

import java.time.Duration;

public class LoginPage {

    @FindBy(name = "username")
    WebElement userNames;

    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span")
    WebElement pageHeader;
    By loginBtn = By.xpath("//button[@type='submit']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final ValidateAction ACTIONs;

    private final int timeOut = 10;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public PIMPage login(String username, String password) throws InterruptedException {
        ACTIONs.waitForPageLoad();
        ACTIONs.verifyPageURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        ACTIONs.setWebElementText(userNames, username);
        ACTIONs.setWebElementText(this.password, password);
        ACTIONs.clickElement(loginBtn);
        Assert.assertTrue(ACTIONs.verifyPageTitle("OrangeHRM"), "Incorrect Page Title!");

        return new PIMPage(driver);
    }

}

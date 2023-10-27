package pages;

import com.aventstack.extentreports.ExtentReports;
import locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ValidateAction;
import utils.Logs;

public class LoginPage extends BasePage {

    private By getPageTitle = By.xpath("//div[@class='title']/div[2]");

    protected ValidateAction ACTION;
    public LoginPage(WebDriver driver) {
        super(driver);
        ACTION = new ValidateAction(driver);
    }

    public LoginPage loginWeb(String username, String password) {
        Logs.info("Input Username: " + username);
        ACTION.setText(Locator.USERNAME, username);

        Logs.info("Input password: " + password);
        ACTION.setText(Locator.PASSWORD, password);

        Logs.info("Click Login");
        ACTION.clickElement(Locator.BTN_SUBMIT);
        return this;
    }
    public CustomDashboardPage verifyLoginSuccessful(){
        Logs.info("Verify page title");
        ACTION.assertTitleText("Single System - Dashboard", getPageTitle);
        return new CustomDashboardPage(driver);
    }

}

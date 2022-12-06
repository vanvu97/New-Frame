package page;

import BaseConfig.Interface;
import core.Button;
import management.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import utils.ValidateAction;

public class PIMPage extends Interface {

    String usernames = "name//username";
    String passwords = "name//password";
    String loginBtn = "xpath//button";
    String FirstName;
    String LastName;

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        ACTIONs = new ValidateAction(driver);
        btn = new Button();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public AdminPage addNewEmployees() throws InterruptedException {
        ACTIONs.waitForPageLoad();
        Log.info(" - Clicking to PIM");
        ACTIONs.clickElementWeb(PIM);
        Log.info(" - Clicking to Add New User");
        ACTIONs.clickElementWeb(addUserButton);
        Log.info(" - Adding New User");
        ACTIONs.setTextWeb(firstNames, getFirstName());
        ACTIONs.setTextWeb(lastNames, getLastName());
        Log.info(" - Click Save Button!");
        ACTIONs.clickElementJS(saveBtn);
        Assert.assertTrue(ACTIONs.verifySaveSuccess(""), "Unable to Save data!");

        return new AdminPage(driver);
    }
    public void test() {
        btn.sendKeys(usernames, "Admin");
        btn.sendKeys(passwords, "admin123");
        btn.click(loginBtn);
    }


}

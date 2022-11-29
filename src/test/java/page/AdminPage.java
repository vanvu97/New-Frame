package page;

import BaseConfig.Interface;
import management.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ValidateAction;

import java.time.Duration;

public class AdminPage extends Interface {

    protected String FirstName ="";

    protected String ListUName;

    protected String listRoless;

    protected String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void addUser() throws InterruptedException {
        ACTIONs.waitForPageLoad();
        Log.info(" - Navigate to Admin Page!");
        ACTIONs.clickElement(ADMIN);
        Log.info(" - Clicking Add User Button!");
        ACTIONs.clickElementWeb(addUserButton);
        Log.info(" - Adding User Button!");
        ACTIONs.selectOptionWeb(clickRole, selectRole);
        ACTIONs.selectOptionWeb(clickStatus, selectStatus);
        ACTIONs.setTextWeb(userName, this.username + Keys.ENTER);
        ACTIONs.sendKeyThenSelectOption(employeeseName, getFirstName(), getFirstName());
        ACTIONs.intputRepeatFieldText(passwordField, "SD#Dsa2e3AS#$@%\n");
        Thread.sleep(2000);
        if (!(errorField == null)) {
            ACTIONs.getErrorMessages(errorField, errorMessages);
            if (errorMessages.equals("Already exists") && errorField.equals("Username")) {
                ACTIONs.setTextWeb(userName, this.username + "1");
            }
        }
        Log.info(" - Clicking Save Button!");
        ACTIONs.clickElementWeb(saveBtn);

    }

    public PerformancePage verifyUser() {
        ACTIONs.verifyUserInTable(username, listRole);

        return new PerformancePage(driver);
    }


}

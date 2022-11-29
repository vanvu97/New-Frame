package page;

import BaseConfig.Interface;
import management.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.ValidateAction;

public class PIMPage extends Interface {
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
        Log.info(" - Click Save button!");
        ACTIONs.clickElementJS(saveBtn);
        ACTIONs.verifyPageHeader(header, "Personal Details");

        return new AdminPage(driver);
    }


}

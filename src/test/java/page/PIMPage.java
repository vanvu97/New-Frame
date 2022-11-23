package page;

import BaseConfig.Interface;
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

    public AdminPage addNewEmployees() {
        ACTIONs.waitForPageLoad();
        ACTIONs.clickWebElement(PIM);
        ACTIONs.clickWebElement(addUserButton);
        ACTIONs.setTextWeb(firstNames, getFirstName());
        ACTIONs.setTextWeb(lastNames, getLastName());
        ACTIONs.clickWebElement(saveBtn);
        ACTIONs.verifyPageHeader(header, "Personal Details");

        return new AdminPage(driver);
    }


}

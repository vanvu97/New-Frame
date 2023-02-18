package page;

import BaseConfig.Interface;
import newFramePackage.core.Button;
import newFramePackage.management.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TC2_PIMPage extends Interface {

    String usernames = "name//username";
    String passwords = "name//password";
    String loginBtn = "xpath//button";

    String PIM = "xpath//span[normalize-space()='PIM']";
    String addUserButton = "xpath//Button[normalize-space()='Add']";

    @FindBy (xpath = "//Button[normalize-space()='Add']")
    WebElement c;
    String firstNames = "name//firstName";
    String lastNames = "name//lastName";
    String saveBtn = "xpath//Button[normalize-space()='Save']";
    String messageSuccessful = "xpath//*[contains(text(), 'Successfully Saved')]";
    String FirstName;
    String LastName;

    Button btn = new Button();

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


    public TC3_AdminPage addNewEmployees() {

        Log.info(" - Clicking to PIM");
        btn.clickButton(PIM);
        Log.info(" - Clicking to Add New User");
        btn.clickButton(addUserButton);
        ACTIONs.waitFor(c, 10);
        Log.info(" - Adding New User");
        btn.sendKey(firstNames, getFirstName());
        btn.sendKey(lastNames, getLastName());
        Log.info(" - Click Save Button!");
        btn.clickButton(saveBtn);
        Assert.assertEquals(btn.getTexts(messageSuccessful), "Successfully Saved");
        return new TC3_AdminPage();
    }

}

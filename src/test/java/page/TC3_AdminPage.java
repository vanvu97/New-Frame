package page;

import BaseConfig.Interface;
import newFramePackage.core.Button;
import newFramePackage.Log;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class TC3_AdminPage extends Interface {

    protected final String status = "Enabled";
    protected final String role = "Admin";
    protected final String username = "Test@DS543fd@RD23";
    protected final String Password = "Test@DS543fd@RD23";
    String employName;

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }
    protected final String ADMIN = "xpath//span[normalize-space()='Admin']";
    protected final String addUserButton = "xpath//Button[normalize-space()='Add']";
    protected final String clickRole = "xpath//label[normalize-space()='User Role']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div";
    protected final String selectRole = "xpath//label[normalize-space()='User Role']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[normalize-space()='" + role + "']";
    protected final String clickStatus = "xpath//label[normalize-space()='Status']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div";
    protected final String selectStatus = "xpath//label[normalize-space()='Status']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[normalize-space()='" + status + "']";
    protected final String userName = "xpath//div[@class='oxd-input-group__label-wrapper' and normalize-space()='Username']/following-sibling::div/input";
    protected final String password = "xpath//label[text() = 'Password']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input";
    protected final String confirmPassword = "xpath//label[text() = 'Confirm Password']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input";
    protected final String employeesName = "xpath//input[@placeholder='Type for hints...']";
    protected final String selectEmployeesName = "xpath//div[@role='listbox']//span[contains(text(),  '" + getEmployName() +"')]";



    String messageSuccessful = "xpath//*[contains(text(), 'Successfully Saved')]";
    Button btn = new Button();

    public void addUser() throws InterruptedException {
        Log.info(" - Navigate to Admin Page!");
        btn.clickButton(ADMIN);
        Log.info(" - Clicking Add User Button!");
        btn.clickButton(addUserButton);
        Log.info(" - Adding User Button!");
        btn.selectOptions(clickRole, selectRole);
        btn.selectOptions(clickStatus, selectStatus);
        Log.info(" - Sending Employee Name");
        btn.sendkeyAndSelect(employeesName, getEmployName(), selectEmployeesName);
        btn.sendKey(userName, this.username + Keys.ENTER);
        btn.sendKey(password, Password);
        btn.sendKey(confirmPassword, Password);
        Assert.assertEquals(btn.getTexts(messageSuccessful), "Successfully Saved");

    }
}

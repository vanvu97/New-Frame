package page;

import BaseConfig.Interface;
import management.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ValidateAction;

import java.time.Duration;
import java.util.List;

public class AdminPage extends Interface {

    protected String FirstName;

    protected String ListUName;

    protected String listRoless;

    String c;
    String d;

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

    public PerformancePage getListUser() {
        List<WebElement> listTotals = listUserName;
        List<WebElement> listRol = listRole;
        int sizeTotals = listTotals.size();
        System.out.println(sizeTotals);
        for (int i = 0; i < sizeTotals; i++) {
            this.c = listTotals.get(i).getText();
            this.d = listRol.get(i).getText();
            System.out.println(this.c + " : " + this.d);
        }
        Assert.assertEquals(this.c, EmployeeName);
        return new PerformancePage(driver);
    }


}

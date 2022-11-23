package BaseConfig;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {
    //    =================================================PIM Page===========================================================
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    protected WebElement PIM;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    protected WebElement addUserButton;
    @FindBy(xpath = "firstName")
    protected WebElement firstNames;
    @FindBy(xpath = "lastName")
    protected WebElement lastNames;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement saveBtn;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    protected WebElement header;

    //    =========================================LoginPage===================================================================
    protected final String title = "User Management";
    @FindBy(name = "username")
    protected WebElement userNames;
    @FindBy(name = "password")
    protected WebElement password;
    @FindBy(xpath = "//h6[normalize-space()='Admin']/following-sibling::h6[normalize-space()='" + title + "']")
    protected WebElement pageHeader;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement loginBtn;

    //    =========================================Performance Page===================================================================
    @FindBy(xpath = "//span[normalize-space()='Performance']")
    protected WebElement Performance;
    @FindBy(xpath = "//label[normalize-space()='From Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input[@placeholder = 'yyyy-mm-dd']")
    protected WebElement fromDate;
    @FindBy(xpath = "//label[normalize-space()='To Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input[@placeholder = 'yyyy-mm-dd']")
    protected WebElement toDate;
    @FindBy(xpath = "//div[@class='oxd-date-input-link --clear']")
    protected WebElement clearCalendar;

}

package BaseConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Elements {
    //    =================================================Admin Page===========================================================
    protected final String status = "Enabled";
    protected final String role = "Admin";
    protected final String username = "Test@DS543fd@RD23";
    protected final String EmployeeName = "";

    @FindBy(xpath = "//div[@role = 'rowgroup']/div[@class='oxd-table-card']//div[contains(text(), '" + EmployeeName + "')]/preceding::div[@class='oxd-table-cell oxd-padding-cell']/div[contains(text(), '" + username + "')]")
    protected List<WebElement> listUserName;

    @FindBy(xpath = "//div[@role = 'rowgroup']/div[@class='oxd-table-card']//div[contains(text(), '"+username+"')]")
    protected List<WebElement> listRole;
    @FindBy(xpath = "//label[normalize-space()='User Role']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div")
    protected WebElement clickRole;
    @FindBy(xpath = "//label[normalize-space()='Status']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div")
    protected WebElement clickStatus;
    @FindBy(xpath = "//label[normalize-space()='User Role']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[normalize-space()='" + role + "']")
    protected WebElement selectRole;
    @FindBy(xpath = "//label[normalize-space()='Status']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[normalize-space()='" + status + "']")
    protected WebElement selectStatus;
    protected By passwordField = By.xpath("//input[@type='password']");

    protected By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    @FindBy(xpath = "//button[normalize-space()='Save']")
    protected WebElement saveBtn;

    protected By errorMessages = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div[@class='oxd-input-group__label-wrapper']");
    protected By errorField = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div[@class='oxd-input-group__label-wrapper']/following-sibling::span");

    protected By ADMIN = By.xpath("//span[normalize-space()='Admin']");


    //    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a") WebElement ADMIN;
    @FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper' and normalize-space()='Username']/following-sibling::div/input")
    protected WebElement userName;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    protected WebElement employeeseName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    protected WebElement addUserBtn;

    @FindBy(xpath = "//div[@role = 'rowgroup']/div")
    protected WebElement listUser;


    //    =================================================PIM Page===========================================================
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    protected WebElement PIM;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    protected WebElement addUserButton;
    @FindBy(name = "firstName")
    protected WebElement firstNames;
    @FindBy(name = "lastName")
    protected WebElement lastNames;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and normalize-space()='Personal Details']")
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

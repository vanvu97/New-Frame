package page;

import BaseConfig.Interface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ValidateAction;

import java.time.Duration;
import java.util.List;

public class AdminPage extends Interface {
    String FirstName;

    private final String status = "Enabled";
    private final String role = "Admin";
    private final String username = "Test";

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }


    @FindBy(xpath = "//div[@class='orangehrm-header-container']/button[normalize-space()='Add']")
    WebElement addUserButton;
    @FindBy(xpath = "//label[normalize-space()='User Role']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div")
    WebElement clickRole;
    @FindBy(xpath = "//label[normalize-space()='Status']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div")
    WebElement clickStatus;
    @FindBy(xpath = "//label[normalize-space()='User Role']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[normalize-space()='" + role + "']")
    WebElement selectRole;
    @FindBy(xpath = "//label[normalize-space()='Status']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//div[normalize-space()='" + status + "']")
    WebElement selectStatus;
    By passwordField = By.xpath("//input[@type='password']");

    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By saveBtn = By.xpath("//button[normalize-space()='Save']");

    By errorMessages = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div[@class='oxd-input-group__label-wrapper']");
    By errorField = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div[@class='oxd-input-group__label-wrapper']/following-sibling::span");

    By ADMIN = By.xpath("//span[normalize-space()='Admin']");

    //    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a") WebElement ADMIN;
    @FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper' and normalize-space()='Username']/following-sibling::div/input")
    WebElement userName;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeseName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    WebElement addUserBtn;

    By listUser = By.xpath("//div[@role = 'rowgroup']/div");


    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public PerformancePage addUser() throws InterruptedException {
        ACTIONs.waitForPageLoad();
        ACTIONs.clickElement(ADMIN);
        ACTIONs.clickWebElement(addUserButton);
        ACTIONs.selectOptionWeb(clickRole, selectRole);
        ACTIONs.selectOptionWeb(clickStatus, selectStatus);
        ACTIONs.setWebElementText(userName, this.username);
        ACTIONs.sendKeyThenSelectOption(employeeseName, getFirstName(), getFirstName());
        ACTIONs.intputRepeatFieldText(passwordField, "SD#Dsa2e3AS#$@%\n");
        ACTIONs.getErrorMessages(errorField, errorMessages);
        ACTIONs.clickElement(saveBtn);

        return new PerformancePage(driver);

    }

    public void getListUser() {
        List<WebElement> listUsers = driver.findElements(By.xpath("//div[@role = 'rowgroup']/div"));
        int sizeUserList = listUsers.size();
        for (int i = 0; i < sizeUserList; i++) {
            String getUserList = listUsers.get(i).getText();
            System.out.println(getUserList);
        }
    }
}

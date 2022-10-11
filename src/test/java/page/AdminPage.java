package page;

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

public class AdminPage {
    String FirstName;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    By addUserButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    By dropDownRole = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    By dropDownStt = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div");
    By passwordField = By.xpath("//input[@type='password']");

    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By saveBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");

    By errorMessages = By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div/div/div/div/span");
    By errorField = By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div/div/div/div/span//preceding-sibling::div[2]");

    By ADMIN = By.xpath("//span[normalize-space()='Admin']");

//    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a") WebElement ADMIN;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    WebElement userName;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeseName;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button") WebElement addUserBtn;

    By listUser = By.xpath("//div[@role = 'rowgroup']/div");

    WebDriver driver;
    WebDriverWait wait;
    ValidateAction ACTIONs;

    private final String status = "Enabled";
    private final String role = "ESS";
    private final String username = "Test User Name";

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void addUser() throws InterruptedException {
        ACTIONs.waitForPageLoad();
        ACTIONs.clickElement(ADMIN);
        ACTIONs.clickElement(addUserButton);
        ACTIONs.selectOptionByText(dropDownRole, this.role);
        ACTIONs.selectOptionByText(dropDownStt, this.status);
        ACTIONs.setWebElementText(userName, this.username);
        ACTIONs.sendKeyThenSelectOption(employeeseName, getFirstName(), getFirstName());
        ACTIONs.intputRepeatFieldText(passwordField, "SD#Dsa2e3AS#$@%\n");
        ACTIONs.getErrorMessages(errorMessages, errorField);
        if(ACTIONs.getErrorMessages(errorMessages, errorField)){
            ACTIONs.setWebElementText(userName, this.username + "1");
        }
        ACTIONs.clickElement(saveBtn);
    }

    public void getListUser(){
        List<WebElement> listUsers = driver.findElements(By.xpath("//div[@role = 'rowgroup']/div"));
        int sizeUserList = listUsers.size();
        for(int i = 0; i< sizeUserList; i++){
            String getUserList = listUsers.get(i).getText();
            System.out.println(getUserList);
        }
    }
}

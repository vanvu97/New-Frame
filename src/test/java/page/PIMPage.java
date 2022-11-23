package page;

import BaseConfig.Interface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.ValidateAction;

public class PIMPage extends Interface {
    WebElement e;

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

    @FindBy(xpath = "")
    WebElement addUserBtn;
    @FindBy(name = "firstName")
    WebElement firstName;
    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "middleName")
    WebElement middleName;

    @FindBy(xpath = "//h6[contains(text(), 'Personal Details')]")
    WebElement headerPage;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement header;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public AdminPage addNewEmployees() throws InterruptedException {
        ACTIONs.waitForPageLoad();
        ACTIONs.clickElement(PIM);
        ACTIONs.clickElement(addUserButton);
        ACTIONs.setText(firstNames, getFirstName());
        ACTIONs.setText(lastNames, getLastName());
        ACTIONs.clickWebElement(saveBtn);
        ACTIONs.verifyPageHeader(header, "Personal Details");

        return new AdminPage(driver);
    }


}

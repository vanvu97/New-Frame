package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.ValidateAction;

public class PIMPage { WebElement e;

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


    By PIM = By.xpath("//span[normalize-space()='PIM']");
    By addUserButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");

    By firstNames = By.name("firstName");

    By lastNames = By.name("lastName");

    @FindBy (xpath = "") WebElement addUserBtn;
    @FindBy (name = "firstName") WebElement firstName;
    @FindBy (name = "lastName") WebElement lastName;

    @FindBy (name = "middleName") WebElement middleName;
    @FindBy (xpath = "//button[@type='submit']") WebElement saveBtn;

    @FindBy (xpath = "//h6[contains(text(), 'Personal Details')]") WebElement headerPage;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6") WebElement header;
    WebDriver driver;
    ValidateAction ACTIONs;
    public PIMPage(WebDriver driver){
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
        ACTIONs.clickWebelement(saveBtn);
        ACTIONs.verifyPageHeader(header, "Personal Details");

        return new AdminPage(driver);
    }


}

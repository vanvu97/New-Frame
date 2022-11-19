package page;

import BaseConfig.Interface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ValidateAction;

import java.time.Duration;

public class PerformancePage extends Interface {

    @FindBy(xpath = "//span[normalize-space()='Performance']")
    WebElement Performance;
    @FindBy(xpath = "//label[normalize-space()='From Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input[@placeholder = 'yyyy-mm-dd']")
    WebElement fromDate;
    @FindBy(xpath = "//label[normalize-space()='To Date']/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input[@placeholder = 'yyyy-mm-dd']")
    WebElement toDate;

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(second_10s));
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void selectPerformance() {
        ACTIONs.clickWebElement(Performance);
    }

    public void selectFromDate() throws InterruptedException {
        ACTIONs.setWebElementText(fromDate, "2022-11-19");

        Thread.sleep(3000);

    }


}

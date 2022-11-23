package page;

import BaseConfig.Interface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ValidateAction;

import java.time.Duration;

public class PerformancePage extends Interface {

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
        ACTIONs.clickWebElement(fromDate);
        ACTIONs.clickWebElement(clearCalendar);
        ACTIONs.setWebElementText(fromDate, "2022-11-19");
        Thread.sleep(3000);
    }


}

package page;

import BaseConfig.Interface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import newFramePackage.utils.ValidateAction;

import java.time.Duration;

public class PerformancePage extends Interface {

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(second_10s));
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void selectPerformance() {
        ACTIONs.clickElementWeb(Performance);
    }

    public void selectFromDate() throws InterruptedException {
        ACTIONs.clickElementWeb(fromDate);
        ACTIONs.clickElementWeb(clearCalendar);
        ACTIONs.setTextWeb(fromDate, "2022-11-19");
        Thread.sleep(3000);
    }


}

package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import manage.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logs;

import java.io.IOException;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected String path = "/";
    protected WebDriverWait wait;
    protected String URL;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected BasePage(WebDriver driver, String URL) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void goToURL() throws IOException {
        URL = PropertiesManager.getPropValue("baseUrl");
        driver.get(URL);
        Logs.info("Opening URL: " + URL);
    }
}

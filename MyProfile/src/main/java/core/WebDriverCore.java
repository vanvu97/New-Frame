package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverCore {

    private static WebDriver driver;
    private static WebDriverWait wait;
    protected static JavascriptExecutor js;
    private static int seconds = 30;
    private static int tryCatchTimes = 30;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver setupBrowser(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "edge" -> driver = edgeBrowser();
            case "firefox" -> driver = firefoxBrowser();
            case "chrome" -> driver = chromeBrowser();
            default -> {
                System.out.println("Browser: " + browserType + " is not config, starting default Browser...!");
                driver = edgeBrowser();
            }
        }
        return driver;
    }

    private static WebDriver edgeBrowser() {
        EdgeOptions options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        js = (JavascriptExecutor) driver;
        return driver;
    }

    private static WebDriver firefoxBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        options.addArguments("--remote-allow-origins=*");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        return driver;
    }

    private static WebDriver chromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        js = (JavascriptExecutor) driver;
        return driver;
    }
}

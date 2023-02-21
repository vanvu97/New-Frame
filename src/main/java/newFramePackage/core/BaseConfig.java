package newFramePackage.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import newFramePackage.utils.ValidateAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseConfig {
    private static WebDriver driver;
    private static WebDriverWait wait;
    protected static JavascriptExecutor js;
    private ValidateAction ACTION;
    private static int seconds = 30;
    private static int tryCatchTimes = 1;


    public static WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForPageLoad (){
        ACTION.waitForPageLoad();
    }
    public WebDriver setupBrowser(String browserType, String URL) {
        switch (browserType.trim().toLowerCase()) {
            case "edge":
                driver = edgeBrowser();
                driver.navigate().to(URL);
                waitForPageLoad();
                System.out.println("Navigate to " + URL);
                break;
            case "remote":
                driver = chromeRemote();
//                driver.navigate().to(URL);
                waitForPageLoad();
                System.out.println("Navigate to " + URL);
                break;
            case "firefox":
                driver = firefoxBrowser();
                driver.navigate().to(URL);
                waitForPageLoad();
                System.out.println("Navigate to " + URL);
                break;
            case "chrome":
                driver = chromeBrowser();
                driver.navigate().to(URL);
                waitForPageLoad();
                System.out.println("Navigate to " + URL);
                break;
            case "remoteNoURL":
                driver = chromeBrowser();
                break;
            default:
                System.out.println("Browser: " + browserType + " is not config, starting default Browser...!");
                driver = edgeBrowser();
                System.out.println("Navigate to " + URL);
        }
        return driver;
    }
    public List<WebElement> listWebElement(String a){
        List<WebElement> e = driver.findElements(By.xpath(a));
        return e;
    }
    public WebElement xpath(String a) {
        return driver.findElement(By.xpath(a));
    }
    public WebElement id(String a) {
        return driver.findElement(By.id(a));
    }
    public WebElement name(String a) {
        return driver.findElement(By.name(a));
    }
    public WebElement cssSelector(String a) {
        return driver.findElement(By.cssSelector(a));
    }
    public WebElement className(String a) {
        return driver.findElement(By.className(a));
    }

    private static WebDriver edgeBrowser() {
        EdgeOptions options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        js = (JavascriptExecutor) driver;
        return driver;
    }

    private static WebDriver firefoxBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        js = (JavascriptExecutor) driver;
        return driver;
    }

    private static WebDriver chromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(tryCatchTimes));
        js = (JavascriptExecutor) driver;
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);
        return driver;
    }

    private WebDriver chromeRemote() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
//        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(tryCatchTimes));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(tryCatchTimes));
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);
        return driver;
    }



}

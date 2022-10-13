package BaseConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseConfig {
    protected static WebDriver driver;
    protected static JavascriptExecutor js;

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriver setupBrowser(String browserType){
        switch (browserType.trim().toLowerCase()){
            case "edge":
                driver = edgeBrowser();
                break;
            case "chrome":
                driver = chromeBrowser();
                break;
            case "firefox":
                driver = firefoxBrowser();
                break;
            default:
                System.out.println("Browser: "+browserType+" is not config, starting default Browser...!");
                driver = edgeBrowser();
        }
        return driver;
    }

    private void setBrowser(String browserType, String URL){
        switch (browserType.trim().toLowerCase()){
            case "edge":
                driver = edgeBrowser();
                driver.navigate().to(URL);
                break;
            case "chrome":
                driver = chromeBrowser();
                driver.navigate().to(URL);
                break;
            case "firefox":
                driver = firefoxBrowser();
                driver.navigate().to(URL);
                break;
            case "opera":
                driver = operaBrowser();
                driver.navigate().to(URL);
                break;
            default:
                System.out.println("Browser: "+browserType+" is not config, starting default Browser...!");
                driver = edgeBrowser();
                driver.navigate().to(URL);
        };
    }

    private static WebDriver edgeBrowser(){
        EdgeOptions options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        return driver;
    }
    private static WebDriver operaBrowser(){
        OperaOptions options = new OperaOptions();
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);
        return driver;
    }
    private static WebDriver chromeBrowser(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
        js = (JavascriptExecutor) driver;
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);
        return driver;
    }
    private static WebDriver firefoxBrowser(){
        FirefoxOptions options = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
        js = (JavascriptExecutor) driver;
        return driver;
    }


    @Parameters({"browserType", "URL"})
    @BeforeClass
    public void setUp(String browserType, String URL) {
        try{
            setBrowser(browserType, URL);
        }catch (Exception e){
            System.out.println("Error..." + e.getStackTrace());
        }

    }

    @AfterClass
    public void tearDown() {
        System.out.println("Run Test Completed! Closing Browser...");
        driver.quit();
    }
}

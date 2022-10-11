package BaseConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class Base {
    protected static WebDriver driver;
    protected static JavascriptExecutor js;

    public WebDriver getDriver(){
        return driver;
    }

    private void setBrowser(String browserType, String URL){
        switch (browserType){
            case "edge":
                driver = edgeBrowser(URL);
                break;
            case "chrome":
                driver = chromeBrowser(URL);
                break;
            default:
                System.out.println("Browser: "+browserType+" is not config, starting default Browser...!");
                driver = edgeBrowser(URL);
        }
    }

    private static WebDriver edgeBrowser(String URL){
        EdgeOptions options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        return driver;
    }
    private static WebDriver chromeBrowser(String URL){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(URL);
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

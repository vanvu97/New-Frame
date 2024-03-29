package newFramePackage.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;


    //Get the driver
    public Waiter(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    private void ajaxComplete() {
        js.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    private void waitForJQueryLoad() {
        try {
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver)
                    .executeScript("return jQuery.active") == 0);
            boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");
            if (!jqueryReady) {
                wait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitForAngularLoad() {
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        angularLoads(angularReadyScript);
    }

    private void waitUntilJSReady() {
        try {
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) this.driver)
                    .executeScript("return document.readyState").toString().equals("complete");
            boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");
            if (!jsReady) {
                wait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitUntilJQueryReady() {
        Boolean jQueryDefined = (Boolean) js.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            poll(20);
            waitForJQueryLoad();
            poll(20);
        }
    }

    public void waitUntilAngularReady() {
        try {
            Boolean angularUnDefined = (Boolean) js.executeScript("return window.angular === undefined");
            if (!angularUnDefined) {
                Boolean angularInjectorUnDefined = (Boolean) js.executeScript("return angular.element(document).injector() === undefined");
                if (!angularInjectorUnDefined) {
                    poll(20);
                    waitForAngularLoad();
                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    public void waitUntilAngular5Ready() {
        try {
            Object angular5Check = js.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
            if (angular5Check != null) {
                Boolean angularPageLoaded = (Boolean) js.executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1");
                if (!angularPageLoaded) {
                    poll(20);
                    waitForAngular5Load();
                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitForAngular5Load() {
        String angularReadyScript = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
        angularLoads(angularReadyScript);
    }

    private void angularLoads(String angularReadyScript) {
        try {
            ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                    .executeScript(angularReadyScript).toString());
            boolean angularReady = Boolean.valueOf(js.executeScript(angularReadyScript).toString());
            if (!angularReady) {
                wait.until(angularLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    public void waitAllRequest() {
        waitUntilJSReady();
        ajaxComplete();
        waitUntilJQueryReady();
        waitUntilAngularReady();
        waitUntilAngular5Ready();
    }

    /**
     * Method to make sure a specific element has loaded on the page
     *
     * @param by
     * @param expected
     */
    public void waitForElementAreComplete(By by, int expected) {
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = this.driver.findElements(by).size();
            return loadingElements >= expected;
        };
        wait.until(angularLoad);
    }

    /**
     * Waits for the elements animation to be completed
     *
     * @param css
     */
    public void waitForAnimationToComplete(String css) {
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = this.driver.findElements(By.cssSelector(css)).size();
            return loadingElements == 0;
        };
        wait.until(angularLoad);
    }

    private void poll(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

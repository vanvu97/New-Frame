package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Editor extends BaseRemote{

    private String[] c;
    private String[] d;
    private String b;
    private String l;


    protected WebDriver click(String a) {
        c = a.split("//", 0);
        d = a.split("//");
        b = c[0].trim();
        l = d[d.length - 1];

        switch (b) {
            case "xpath":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(xpath("//" + l)));
                getWait().until(ExpectedConditions.elementToBeClickable(xpath("//" + l)));
                xpath("//" + l).click();
                break;
            case "id":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(id(l)));
                getWait().until(ExpectedConditions.elementToBeClickable(id(l)));
                id(l).click();
                break;
            case "name":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(name(l)));
                getWait().until(ExpectedConditions.elementToBeClickable(name(l)));
                name(l).click();
                break;
            case "cssselector":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(cssSelector(l)));
                getWait().until(ExpectedConditions.elementToBeClickable(cssSelector(l)));
                cssSelector(l).click();
                break;
            case "classname":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(className(l)));
                getWait().until(ExpectedConditions.elementToBeClickable(className(l)));
                className(l).click();
                break;
        }
        return getDriver();
    }

    protected WebDriver sendKeys(String a, String q) {
        c = a.split("//", 0);
        d = a.split("//");
        b = c[0].trim();
        l = d[d.length - 1];

        switch (b.trim().toLowerCase()) {
            case "xpath":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(xpath("//" + l)));
                getWait().until(ExpectedConditions.elementToBeClickable(xpath("//" + l)));
                xpath("//" + l).clear();
                xpath("//" + l).sendKeys(q);
                break;
            case "id":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(id(l)));
                getWait().until(ExpectedConditions.elementToBeClickable(id(l)));
                id(l).clear();
                id(l).sendKeys(q);
                break;
            case "name":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(name(l)));
                getWait().until(ExpectedConditions.elementToBeClickable(name(l)));
                name(l).clear();
                name(l).sendKeys(q);
                break;
            case "cssselector":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(cssSelector(l)));
                getWait().until(ExpectedConditions.elementToBeClickable(cssSelector(l)));
                cssSelector(l).clear();
                cssSelector(l).sendKeys(q);
                break;
            case "classname":
                waitForPageLoad();
                getWait().until(ExpectedConditions.visibilityOf(className(l)));
                getWait().until(ExpectedConditions.elementToBeClickable(className(l)));
                className(l).clear();
                className(l).sendKeys(q);
                break;
        }
        return getDriver();
    }

    public void waitForPageLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver)
                                .executeScript("return document.readyState")
                                .toString()
                                .equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(300));
            wait.until(expectation);

        } catch (Throwable error) {
            Assert.fail("Timeout! Page still loading...");
        }
    }

}

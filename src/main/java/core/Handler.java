package core;

import management.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Handler extends BaseRemote {

    private String c;
    private String d;
    private String q;
    private String w;


    protected WebDriver click(String a) {
        c = a.substring(0, a.indexOf("//"));
        d = a.substring(a.indexOf("//") + 2);
        waitForPageLoad();
        switch (c.trim().toLowerCase()) {
            case "xpath":
                getWait().until(ExpectedConditions.visibilityOf(xpath("//" + d)));
                getWait().until(ExpectedConditions.elementToBeClickable(xpath("//" + d)));
                xpath("//" + d).click();
                break;
            case "id":
                getWait().until(ExpectedConditions.visibilityOf(id(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(id(d)));
                id(d).click();
                break;
            case "name":
                getWait().until(ExpectedConditions.visibilityOf(name(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(name(d)));
                name(d).click();
                break;
            case "cssselector":
                getWait().until(ExpectedConditions.visibilityOf(cssSelector(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(cssSelector(d)));
                cssSelector(d).click();
                break;
            case "classname":
                getWait().until(ExpectedConditions.visibilityOf(className(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(className(d)));
                className(d).click();
                break;
        }
        return getDriver();
    }

    protected WebDriver sendKeys(String a, String q) {
        c = a.substring(0, a.indexOf("//"));
        d = a.substring(a.indexOf("//") + 2);
        waitForPageLoad();
        switch (c.trim().toLowerCase()) {
            case "xpath":
                getWait().until(ExpectedConditions.visibilityOf(xpath("//" + d)));
                getWait().until(ExpectedConditions.elementToBeClickable(xpath("//" + d)));
                xpath("//" + d).clear();
                xpath("//" + d).sendKeys(q);
                break;
            case "id":
                getWait().until(ExpectedConditions.visibilityOf(id(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(id(d)));
                id(d).clear();
                id(d).sendKeys(q);
                break;
            case "name":
                getWait().until(ExpectedConditions.visibilityOf(name(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(name(d)));
                name(d).clear();
                name(d).sendKeys(q);
                break;
            case "cssselector":
                getWait().until(ExpectedConditions.visibilityOf(cssSelector(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(cssSelector(d)));
                cssSelector(d).clear();
                cssSelector(d).sendKeys(q);
                break;
            case "classname":
                getWait().until(ExpectedConditions.visibilityOf(className(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(className(d)));
                className(d).clear();
                className(d).sendKeys(q);
                break;
        }
        return getDriver();
    }

    protected WebDriver selectOption(String a, String s) {
        c = a.substring(0, a.indexOf("//"));
        d = a.substring(a.indexOf("//") + 2);

        q = s.substring(0, s.indexOf("//"));
        w = s.substring(s.indexOf("//") + 2);
        waitForPageLoad();
        switch (c.trim().toLowerCase()) {
            case "xpath":
                getWait().until(ExpectedConditions.visibilityOf(xpath("//" + d)));
                getWait().until(ExpectedConditions.elementToBeClickable(xpath("//" + d)));
                xpath("//" + d).click();
                break;
            case "id":
                getWait().until(ExpectedConditions.visibilityOf(id(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(id(d)));
                id(d).click();
                break;
            case "name":
                getWait().until(ExpectedConditions.visibilityOf(name(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(name(d)));
                name(d).click();
                break;
            case "cssselector":
                getWait().until(ExpectedConditions.visibilityOf(cssSelector(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(cssSelector(d)));
                cssSelector(d).click();
                break;
            case "classname":
                getWait().until(ExpectedConditions.visibilityOf(className(d)));
                getWait().until(ExpectedConditions.elementToBeClickable(className(d)));
                className(d).click();
                break;
        }


        switch (q.trim().toLowerCase()) {
            case "xpath":
                getWait().until(ExpectedConditions.visibilityOf(xpath("//" + w)));
                getWait().until(ExpectedConditions.elementToBeClickable(xpath("//" + w)));
                xpath("//" + w).click();
                break;
            case "id":
                getWait().until(ExpectedConditions.visibilityOf(id(w)));
                getWait().until(ExpectedConditions.elementToBeClickable(id(w)));
                id(w).click();
                break;
            case "name":
                getWait().until(ExpectedConditions.visibilityOf(name(w)));
                getWait().until(ExpectedConditions.elementToBeClickable(name(w)));
                name(w).click();
                break;
            case "cssselector":
                getWait().until(ExpectedConditions.visibilityOf(cssSelector(w)));
                getWait().until(ExpectedConditions.elementToBeClickable(cssSelector(w)));
                cssSelector(w).click();
                break;
            case "classname":
                getWait().until(ExpectedConditions.visibilityOf(className(w)));
                getWait().until(ExpectedConditions.elementToBeClickable(className(w)));
                className(w).click();
                break;
        }
        return getDriver();
    }

    protected WebDriver checkBox(String a) {
        c = a.substring(0, a.indexOf("//"));
        d = a.substring(a.indexOf("//") + 2);
        waitForPageLoad();
        switch (c.trim().toLowerCase()) {
            case "xpath":
                getWait().until(ExpectedConditions.visibilityOf(xpath("//" + d)));
                getWait().until(ExpectedConditions.elementToBeClickable(xpath("//" + d)));
                if (xpath("//" + d).isSelected()) {
                    Log.info(" Option is selected!");
                } else {
                    Log.info(" Checking the Checkbox");
                    xpath("//" + d).click();
                }
                break;
            case "id":
                if (id(d).isSelected()) {
                    Log.info(" Option is selected!");
                } else {
                    Log.info(" Checking the Checkbox");
                    getWait().until(ExpectedConditions.visibilityOf(id(d)));
                    getWait().until(ExpectedConditions.elementToBeClickable(id(d)));
                    id(d).click();
                }
                break;
            case "name":
                if (name(d).isSelected()) {
                    Log.info(" Option is selected!");
                } else {
                    Log.info(" Checking the Checkbox");
                    getWait().until(ExpectedConditions.visibilityOf(name(d)));
                    getWait().until(ExpectedConditions.elementToBeClickable(name(d)));
                    name(d).click();
                }
                break;
            case "cssselector":
                if (cssSelector(d).isSelected()) {
                    Log.info(" Option is selected!");
                } else {
                    Log.info(" Checking the Checkbox");
                    getWait().until(ExpectedConditions.visibilityOf(cssSelector(d)));
                    getWait().until(ExpectedConditions.elementToBeClickable(cssSelector(d)));
                    cssSelector(d).click();
                }
                break;
            case "classname":
                if (className(d).isSelected()) {
                    Log.info(" Option is selected!");
                } else {
                    Log.info(" Checking the Checkbox");
                    getWait().until(ExpectedConditions.visibilityOf(className(d)));
                    getWait().until(ExpectedConditions.elementToBeClickable(className(d)));
                    className(d).click();
                }
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

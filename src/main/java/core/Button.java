package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Button extends BaseRemote {

    public WebDriver click(String a) {
        String[] c = a.split("//", 0);
        String[] d = a.split("//");
        String b = c[0].trim();
        String l = d[d.length - 1];

        switch (b) {
            case "xpath":
                getDriver().findElement(By.xpath("//" + l)).click();
                break;
            case "id":
                getDriver().findElement(By.id(l)).click();
                break;
            case "name":
                getDriver().findElement(By.name(l)).click();
        }
        return getDriver();
    }

    public WebDriver sendKeys(String a, String q) {
        String[] c = a.split("//", 0);
        String[] d = a.split("//");
        String b = c[0].trim();
        String l = d[d.length - 1];

        switch (b) {
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
        }
        return getDriver();
    }

    public WebElement xpath(String a) {
        return getDriver().findElement(By.xpath(a));
    }

    public WebElement id(String a) {
        return getDriver().findElement(By.id(a));
    }

    public WebElement name(String a) {
        return getDriver().findElement(By.name(a));
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

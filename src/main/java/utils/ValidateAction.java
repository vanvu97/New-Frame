package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ValidateAction {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private final int timeOut = 5;

    public ValidateAction(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickElement(By element) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void clickWebelement(WebElement element) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickElementJS(By element) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        js.executeScript("arguments[0].click();", element);
    }

    public void selectOptionByText(By element, String value) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
        driver.findElement(By.xpath("//div[@role='option']/span[contains(text(), '" + value + "')]")).click();

    }

    public void sendKeyThenSelectOption(WebElement element, String text, String value) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
        driver.findElement(By.xpath("//div[@role='option']/span[contains(text(), '" + value + "')]")).click();

    }

    public void setWebElementText(WebElement element, String text) {
        waitForPageLoad();
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public void setText(By element, String text) {
        waitForPageLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }


    public void intputRepeatFieldText(By element, String text) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        List<WebElement> listInputField = driver.findElements(element);
        int setElementSize = driver.findElements(element).size();
        for (int i = 0; i < setElementSize; i++) {
            WebElement sendKey = listInputField.get(i);
            sendKey.sendKeys(text);
        }
    }

    public boolean verifyPageURL(String expectedURL) {
        waitForPageLoad();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl().contains(expectedURL);
    }

    public boolean getErrorMessages(By element, By element2) throws InterruptedException {
        waitForPageLoad();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            List<WebElement> listError = driver.findElements(element);
            List<WebElement> listErrorFields = driver.findElements(element2);
            int setElementSize = listError.size();
            int getErrorField = listErrorFields.size();
            for (int i = 0; i < setElementSize; i++) {
                String allError = listError.get(i).getText();
                String allFieldErorr = listErrorFields.get(i).getText();
                System.out.println("Field: " + allFieldErorr + " is " + allError);
            }
        } catch (Exception e) {
            System.out.println("No error messages found!");
        }
        return false;
    }

    public String getPageTitle() {
        waitForPageLoad();
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyPageTitle(String pageTitle) {
        waitForPageLoad();
        System.out.println("Current Page title: " + driver.getTitle());
        return getPageTitle().equals(pageTitle);
    }

    public boolean verifyPageHeader(WebElement el, String pageHeader) {
        waitForPageLoad();
        String header = ("Current Page Header: " + el.getText());
        System.out.println(header);
        return header.equals(pageHeader);
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
            wait.until(expectation);

        } catch (Throwable error) {
            Assert.fail("Timeout! Page still loading...");
        }
    }

}

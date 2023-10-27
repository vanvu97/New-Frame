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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidateAction {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private String s;
    private final int timeOut = 30;

    public ValidateAction(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(this.driver, this);
    }

    public void scrollToJS(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }

    public void clickElement(By element) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void click(WebElement element) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void setText(By element, String text) {
        waitForPageLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public void getText(By element) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        s = driver.findElement(element).getText();
    }

    public void getListText(By element) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        List<WebElement> list = driver.findElements(element);
        List<String> textList = new ArrayList<>();
        for (WebElement l : list) {
            String text = l.getText();
            textList.add(text);
        }
        Collections.sort(textList);
        for (String text : textList) {
            System.out.println(" - " + text);
        }
    }
    public boolean isExisting(By element){
        List<WebElement> elementList = driver.findElements(element);
        if(!elementList.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public boolean clickOnPlusIcon(By element) {
        waitForPageLoad();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        List<WebElement> list = driver.findElements(element);
        List<String> textList = new ArrayList<>();
        for (WebElement l : list) {
            String text = l.getText();
            textList.add(text);
        }
        Collections.sort(textList);
        for (String text : textList) {
            WebElement s = driver.findElement(By.xpath("//div[contains(@class, 'chart-title__')]/div[contains(text(), '"+text+"')]/ancestor::div[contains(@class, 'app-chart-title')]/following-sibling::div//i[@aria-label='icon: plus-circle']"));
            wait.until(ExpectedConditions.elementToBeClickable(s));
            s.click();
            WebElement t = driver.findElement(By.xpath("//div[contains(@class,'chart-title-box')]/div[1]"));
            Assert.assertEquals(t.getText(), text.toString());

            List<WebElement> icons = driver.findElements(By.xpath("//div[contains(@class,'chart-title-box')]/div[2]/div"));
            if (icons.size() < 3) {
                System.out.println(icons.size());
                return false;
            }
            driver.findElement(By.xpath("//div[contains(@class, 'close-btn')]")).click();
        }
        return true;
    }

    public void verifyText(By element, String expected) {
        waitForPageLoad();
        getText(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertEquals(s, expected);
    }

    public void assertTitle(String expected) {
        waitForPageLoad();
        Assert.assertEquals(driver.getTitle(), expected);
    }

    public void assertTitleText(String expected, By element){
        waitForPageLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        String title = driver.findElement(element).getText();
        Assert.assertEquals(expected, title);
        try {
            CameraCapture.getCapture(driver, expected);
        } catch (Exception e) {
            Logs.info("Exception while taking screenshot: " + e.getMessage());
        }
        Logs.info("Text title is: " + title);
    }

    public void clickJS(By element) {
        waitForPageLoad();
        js.executeScript("arguments[0].click();", element);
    }

    public void navigatePage(String page){
        waitForPageLoad();
        driver.navigate().to(page);
    }
    /**
     * Assert list of Array Text
     * @param element
     * @param expectedText
     */
    public void assertListText(By element, String[] expectedText){
        List<WebElement> elements = driver.findElements(element);
        List<String> textList = new ArrayList<>();
        for (WebElement l: elements) {
            textList.add(l.getText());
        }
        Collections.sort(textList);
        Assert.assertEquals(textList.size(), expectedText.length, "Number of elements does not match");
        for (int i = 0; i < textList.size(); i++) {
            Assert.assertEquals(textList.get(i), expectedText[i],
                    "Text at index " + i + " does not match the expected value.");
        }
        Logs.info("List text: " + textList);
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

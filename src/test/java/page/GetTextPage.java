package page;

import BaseConfig.WriteExcel;
import core.Button;
import management.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class GetTextPage extends Button {

    WebDriver driver;
    private WriteExcel writeExcel;
    String s;
    String sheet = "Lesson 7. Exam Sample G2";

    private String Tit;
    private String Ques;
    private String Ans;
    public String getTit() {
        return Tit;
    }
    public String getQues() {
        return Ques;
    }
    public String getAns() {
        return Ans;
    }

    @FindBy(xpath = "//form/span[contains(text(), 'Question')]")
    WebElement question;
    @FindBy(xpath = "//span[contains(text(), 'Skip question')]")
    WebElement skipBtn;
    @FindBy(xpath = "//form/span[contains(text(), 'Question')]/following-sibling::div")
    WebElement q;
    @FindBy(xpath = "//div[@class='ud-heading-xxl']")
    WebElement title;
    @FindBy(xpath = "//span[contains(text(), 'Continue')]")
    WebElement btnContinues;
    @FindBy(xpath = "//div[@data-purpose='results-title']")
    WebElement completed;
    @FindBy(xpath = "//div[@class='ud-heading-xxl']")
    WebElement quizResumeOrStart;
    @FindBy(xpath = "//button[@data-purpose='start-or-resume-quiz']")
    WebElement btnResumeOrStart;
    @FindBy(xpath = "//div[@data-purpose= 'safely-set-inner-html:rich-text-viewer:html']/p[contains(text(), ')')]")
    List<WebElement> listAnswer;

    @FindBy(xpath = "//span[@data-purpose='item-title' and contains(text(), 'Exam Sam')]")
    List<WebElement> lessonTitle;
    @FindBy(xpath = "//span[@data-purpose='item-title' and contains(text(), 'Exam Sam')]")
    WebElement lessonTitle2;
    By x = By.xpath("//button[@data-purpose='start-or-resume-quiz']");
    By buttonSkip = By.xpath("//span[contains(text(), 'Skip question')]");
    By buttonContinues = By.xpath("//span[contains(text(), 'Continue')]");
    String btnResumeOrStarts = "xpath//button[@data-purpose='start-or-resume-quiz']";

    public GetTextPage(WebDriver driver) {
        this.driver = driver;
        writeExcel = new WriteExcel();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void sText() throws InterruptedException, IOException {

        for (WebElement t : lessonTitle) {
            String getTit = t.getText();
            this.sheet = getTit.substring(lessonTitle.indexOf("Exam"));
            t.click();
            try {
                getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(x));
                System.out.println(sheet);
                System.out.println(writeExcel.getSheet());
                if (writeExcel.getSheet().trim().equals(sheet.trim())) {
                    writeExcel.write("", "", "", sheet);
                    writeExcel.write(title.getText(), "Questions", "Answer", sheet);
                } else {
                    writeExcel.create(sheet);
                    writeExcel.write("", "", "", sheet);
                    writeExcel.write(title.getText(), "Questions", "Answer", sheet);
                }
                btnResumeOrStart.click();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            try {
                if (writeExcel.getSheet().trim().equals(sheet.trim())) {
                    System.out.println("Continues!");
                } else {
                    writeExcel.create(sheet);
                }
                while (skipBtn.isDisplayed()) {
                    Log.info("");
                    Log.info(question.getText());
                    Log.info(q.getText());
                    System.out.println(question.getText());
                    for (WebElement l : listAnswer) {
                        Log.info(this.s);
                        this.s = l.getText();
                        writeExcel.write(question.getText(), q.getText(), this.s, sheet);
                        System.out.println(this.s);
                    }
                    skipBtn.click();
                    Thread.sleep(300);
                }
            } catch (Exception e) {
                try {
                    System.out.println("Error is: " + e);
                    btnContinues.click();
                } catch (Exception ex) {
                    System.out.println("Error is: " + ex);
                }
            }

        }

    }

}

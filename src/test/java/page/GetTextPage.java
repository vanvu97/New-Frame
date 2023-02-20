package page;

import BaseConfig.ReadExcel;
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
import utils.ValidateAction;

import java.io.IOException;
import java.util.List;

public class GetTextPage extends Button {

    WebDriver driver;
    private WriteExcel writeExcel;
    private ReadExcel readExcel;
    private String Ans;
    ValidateAction ACTIONs;
    private String sheet;

    public String getShet() {
        return sheet;
    }

    private String Tit;
    private String Ques;
    private String QuesNum;

    public String getQuesNum() {
        return QuesNum;
    }

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
    @FindBy(xpath = "//button[@data-purpose='next-question-button']")
    WebElement checkAnswer;
    @FindBy(xpath = "//button[@data-purpose='next-question-button']")
    WebElement nextBtn;
    @FindBy(xpath = "//div[@data-purpose= 'safely-set-inner-html:rich-text-viewer:html']/p[contains(text(), ')')]")
    List<WebElement> listAnswer;
    @FindBy(xpath = "//span[@data-purpose='item-title' and contains(text(), 'Quiz')]")
    List<WebElement> lessonTitle;
    @FindBy(xpath = "//label[@class='mc-quiz-answer--answer--11thr ud-toggle-input-container ud-toggle-input-block-container']")
    WebElement answer;
    @FindBy(xpath = "//footer/span[contains(text(), 'Question ')]")
    WebElement getNumberQuestion;
    By resumeStart = By.xpath("//button[@data-purpose='start-or-resume-quiz']");

    public GetTextPage(WebDriver driver) {
        this.driver = driver;
        writeExcel = new WriteExcel();
        ACTIONs = new ValidateAction(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void sText() throws InterruptedException, IOException {

        for (WebElement t : lessonTitle) {
            System.out.println(t);
            ACTIONs.clickElementWeb(t);
            String s = t.getText().substring(t.getText().indexOf("Exam"));
            Log.info("Checking Lesson Title");
            System.out.println("Lesson title: " + s);
            Log.info("Checking Available of Resume, Start button");
            ACTIONs.waitAndClickCustom(btnResumeOrStart, 1);
            sheet = s;
            System.out.println(getShet());
            Log.info("Get Sheet");
//                Tit = title.getText();
            if (!writeExcel.getSheet().trim().contains(getShet().trim())) {
                System.out.println("Checking available of Sheet");
                writeExcel.write("", "", "", getShet());
                writeExcel.write(getTit(), "Questions", "Answer", getShet());
            } else {
                System.out.println("Creating new Sheet: " + getShet());
                writeExcel.create(getShet());
                writeExcel.write("", "", "", getShet());
                writeExcel.write(getTit(), "Questions", "Answer", getShet());
            }
            try {
                String str = getNumberQuestion.getText();
                String[] parts = str.split(" ");
                int fistNum = Integer.parseInt(parts[1]);
                int lastNum = Integer.parseInt(parts[3]);
                int total = lastNum - fistNum;
                System.out.println("Totals questions: " + total);
                for (int i = 0; i < total; i++) {
                    System.out.println(i);
                    Log.info("");
                    Log.info(question.getText());
                    Log.info(q.getText());
                    System.out.println(question.getText());
//                    for (WebElement l : listAnswer) {
//                        Log.info(this.Ans);
//                        Ans = l.getText();
//                        Ques = q.getText();
//                        this.QuesNum = question.getText();
//                        writeExcel.write(getQuesNum(), getQues(), getAns(), sheet);
//                        System.out.println(getAns());
//                    }
                    listAnswer.forEach(l -> {
                        Log.info(this.Ans);
                        Ans = l.getText();
                        Ques = q.getText();
                        QuesNum = question.getText();
                        writeExcel.write(getQuesNum(), getQues(), getAns(), sheet);
                        System.out.println(getAns());
                    });
//                    for (WebElement l : listAnswer) {
//                        ACTIONs.clickElementJS(l);
//                        checkAnswer.click();
//                        if (!nextBtn.isDisplayed()) {
//                            System.out.println("Answer is: "+ answer.getText());
//                            nextBtn.click();
//                        }
//                    }
                    listAnswer.forEach(l -> {
                        ACTIONs.clickElementJS(l);
                        ACTIONs.clickElementWeb(checkAnswer);
                        if (!nextBtn.isDisplayed()) {
                            Log.info("Answer is: " + l.getText());
                            ACTIONs.clickElementWeb(nextBtn);
                        }
                    });
                }

            } catch (Exception e) {
                System.out.println("Error is: " + e);
            }

        }

    }

}

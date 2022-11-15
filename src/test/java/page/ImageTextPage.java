package page;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GrayImage;
import utils.ValidateAction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class ImageTextPage {

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/aside/nav/div[1]/a/div[2]/img")
    WebElement Images;

    private ValidateAction ACTIONs;
    private WebDriver driver;

    private GrayImage gray;

    public ImageTextPage(WebDriver driver) {
        this.driver = driver;
        ACTIONs = new ValidateAction(driver);
        gray = new GrayImage();
        PageFactory.initElements(driver, Duration.ofSeconds(30));
    }

    private static ITesseract instance;

    private static String f = "2";
    public static String imgPath = System.getProperty("user.dir") + "/img/bx" + f + ".png";
    public static String imgIn = "C:\\Users\\mozil\\Desktop\\img Test/bx" + f + ".jpg";
    private static String tessDataPath = "C:/Users/mozil/Desktop/tessdata";

    private static String imgPathCheck = System.getProperty("user.dir") + "./img/";

    public static ITesseract getInstance() {
        if (instance == null) {
            instance = new Tesseract();
            instance.setDatapath(tessDataPath);
        }
        return instance;
    }

    public static String getText(final File imageFile) {
        String result = null;
        try {
            result = ImageTextPage.getInstance().doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void grayImage() throws IOException, InterruptedException {



        File imageFile = new File(imgPathCheck);
        if(!imageFile.exists()){
            imageFile.mkdirs();
        }
        String ExtractedTextFromImage = ImageTextPage.getText(new File(imgPath));
        System.out.println("The Text is: \n" + ExtractedTextFromImage.trim().replace("[,|)]", ""));
        File output = new File("OutPut/x.txt");
        FileWriter writer = new FileWriter(output);
        writer.write(ExtractedTextFromImage);
        writer.flush();
        writer.close();

    }


}

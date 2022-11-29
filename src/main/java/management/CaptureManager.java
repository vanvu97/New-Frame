package management;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureManager {
    static String projectPath = System.getProperty("user.dir") + "/";

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public static void getCapture(WebDriver driver, String screeName) {

        PropertiesManager.setPropertiesFile();
        try {

            Reporter.log("Driver for Screenshot " + driver);

            TakesScreenshot ta = (TakesScreenshot) driver;

            File source = ta.getScreenshotAs(OutputType.FILE);

            File theDir = new File(projectPath + PropertiesManager.getPropValue("exportCapturePath"));

            if (!theDir.exists()) {

                theDir.mkdirs();

            }

            FileHandler.copy(source, new File(projectPath + PropertiesManager.getPropValue("exportCapturePath") + "/" + screeName+ " " + dateFormat.format(new Date()) + ".png"));

            Log.info("  Screenshot taken: " + screeName);

            Reporter.log("  Screenshot taken current URL: " + driver.getCurrentUrl(), true);

        } catch (Exception e) {

            System.out.println("  Exception while taking screenshot: " + e.getMessage());

        }

    }

}

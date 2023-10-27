package utils;

import manage.PropertiesManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraCapture {
    static String projectPath = System.getProperty("user.dir") + "\\";

    static String imagePath;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");


    public static void getCapture(WebDriver driver, String screeName) {

        PropertiesManager.setPropertiesFile();
        try {

            Reporter.log("Driver for Screenshot " + driver);

            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

//            File theDir = new File(projectPath + PropertiesManager.getPropValue("exportCapturePath"));

            File theDir = new File("ExportData\\Images");
            if (!theDir.exists()) {

                theDir.mkdirs();

            }
            imagePath = projectPath + "ExportData\\Images\\" + screeName + " " + dateFormat.format(new Date()) + ".png";
            FileHandler.copy(source, new File(imagePath));
            Logs.warn("Screenshot taken: " + screeName);
            Logs.warn("Screenshot path: " + imagePath);
            Logs.warn("Screenshot taken current URL: " + driver.getCurrentUrl());

        } catch (Exception e) {

            Logs.warn("Exception while taking screenshot: " + e.getMessage());

        }

    }
}

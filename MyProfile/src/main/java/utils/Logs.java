package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs{
    private static final Logger Log = LogManager.getLogger();
    private static int count = 1;
    private static ExtentTest extentTest;

    public static void setExtentTest(ExtentTest test) {
        extentTest = test;
    }

    public static String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date now = new Date();
        return dateFormat.format(now);
    }

    public static void info(String message) {
        String logMessage = "[" + getFormattedDate() + "] " + count++ + " - " + message;
        Log.info(logMessage);
        if (extentTest != null) {
            extentTest.log(Status.INFO, count++ + " .[" + getFormattedDate() + "] - " + message);
        }
    }

    public static void warn(String message) {
        Log.warn("[" + getFormattedDate() + "] " + count++ + " - " + message);
        if (extentTest != null) {
            extentTest.log(Status.PASS, count++ + " .[" + getFormattedDate() + "] - " + message);
        }
    }

    public static void error(String message) {
        String logMessage = "[" + getFormattedDate() + "] " + count++ + " - " + message;
        Log.error(logMessage);
        if (extentTest != null) {
            extentTest.log(Status.ERROR, count++ + " .[" + getFormattedDate() + "] - " + message);
        }
    }

    public static void fatal(String message) {
        Log.fatal(message);
        if (extentTest != null) {
            extentTest.log(Status.FATAL, message);
        }
    }

    public static void debug(String message) {
        Log.debug(message);
        if (extentTest != null) {
            extentTest.log(Status.DEBUG, message);
        }
    }
}

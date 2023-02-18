package newFramePackage.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extentReports = ExtentManager.getExtentReports();

    public static ExtentTest getTest(){
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

}

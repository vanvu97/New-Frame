package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static final ExtentReports extentReports= new ExtentReports();

    public synchronized static ExtentReports getExtentReports(){
        ExtentSparkReporter  reporter = new ExtentSparkReporter("./Report/Report.html");
        reporter.config().setReportName("Test Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework: ", "Selenium Java");
        extentReports.setSystemInfo("Author: ", "vuvan");
        return extentReports;
    }

}

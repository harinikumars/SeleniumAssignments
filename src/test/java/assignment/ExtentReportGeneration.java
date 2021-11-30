package assignment;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGeneration {

    static ExtentReports extentReport;
    static ExtentSparkReporter sparkReporter;
    static ExtentTest test;
    static String ExtentReportPath;

    public static void extentReportCreation() {
        ExtentReportPath = System.getProperty("user.dir") + "/Reports/" + System.currentTimeMillis() + "index.html";
        extentReport = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(ExtentReportPath);
        extentReport.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Order Completion using check payment method.");
        sparkReporter.config().setReportName("Test Report for Order completion.");
        sparkReporter.config().setTheme(Theme.DARK);
    }

    public static void flushTheReports() {
        extentReport.flush();
    }

    public static void createTest(String testCaseName) {
        test = extentReport.createTest(testCaseName);
    }
}

package exercise1;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver = null;
    static ExtentHtmlReporter htmlReporter;
    static ExtentReports extentReport;
    static ExtentTest test;

    @BeforeClass
    public void startTest() {
        htmlReporter = new ExtentHtmlReporter("./Reports/extentReport.html");

        htmlReporter.config().setAutoCreateRelativePathMedia(true);
        htmlReporter.config().setDocumentTitle("Order Completion using check payment method.");
        htmlReporter.config().setReportName("Test Report for Order completion.");
        htmlReporter.config().setTheme(Theme.DARK);

        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);

        test = extentReport.createTest("Order Completion");
        test.log(Status.INFO, "Execution started.");
    }

    @BeforeMethod
    public void setDriverAndLaunchWebsite() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE) {
            String ss = CaptureScreenShot.takeScreenShot(driver);
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Failed", ExtentColor.RED));
            test.info(result.getThrowable().getMessage());
            test.addScreenCaptureFromPath(ss);
            test.log(Status.INFO, "Test Execution Completed");
            extentReport.flush();
        }
        else {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Passed", ExtentColor.GREEN));
            test.log(Status.INFO, "Test Execution Completed");
        }
        driver.quit();
    }
}

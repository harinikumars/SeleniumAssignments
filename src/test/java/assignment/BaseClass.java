package assignment;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver = null;

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportGeneration.extentReportCreation();
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            String ss = CaptureScreenShot.takeScreenShot(driver);
            ExtentReportGeneration.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Failed", ExtentColor.RED));
            ExtentReportGeneration.test.info(result.getThrowable().getMessage().toUpperCase(), MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());
            ExtentReportGeneration.test.log(Status.INFO, "Execution Completed");
        } else {
            ExtentReportGeneration.test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Passed", ExtentColor.GREEN));
            ExtentReportGeneration.test.log(Status.INFO, "Execution Completed");
        }
        driver.quit();
    }

    @AfterSuite
    public void afterSuite(){
        ExtentReportGeneration.flushTheReports();
    }
}

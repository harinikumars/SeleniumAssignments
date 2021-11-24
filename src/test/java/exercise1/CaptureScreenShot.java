package exercise1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShot {
    public static String takeScreenShot(WebDriver driver) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrShot = screenshot.getScreenshotAs(OutputType.FILE);
        String failureScreenShotPath = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".jpg";
        File destFile = new File(failureScreenShotPath);
        FileUtils.copyFile(scrShot, destFile);

        return failureScreenShotPath;
    }
}

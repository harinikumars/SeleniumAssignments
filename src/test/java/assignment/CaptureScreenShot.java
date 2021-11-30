package assignment;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class CaptureScreenShot {
    public static String takeScreenShot(WebDriver driver) throws IOException {

        return ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BASE64);
    }
}

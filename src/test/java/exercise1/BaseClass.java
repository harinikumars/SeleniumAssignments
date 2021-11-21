package exercise1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver chromeDriver = null;

    @BeforeMethod
    public void setDriverGetURL() {

        //setting property for chrome driver and initialising the web driver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://spree-vapasi-prod.herokuapp.com/");
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quitBrowser() {

        //closing the browser session
        chromeDriver.quit();
    }
}

package exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Exercise1 {

    //instantiating the webdriver
     WebDriver chromeDriver = null;

    @BeforeMethod
    public void setDriverGetURL() {

        //setting property for chrome driver and initialising the web driver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        chromeDriver = new ChromeDriver();

        //initialising the URL
        String URL = "http://spree-vapasi-prod.herokuapp.com/";

        //access the login page
        chromeDriver.get(URL + "login");
        chromeDriver.manage().window().maximize();

        //print page title
        String pageTitle = chromeDriver.getTitle();
        System.out.println(pageTitle);
    }

    @Test
    public void loginAddToCartAssertCartValue() {

        //sign-in as existing user
        chromeDriver.findElement(By.id("spree_user_email")).sendKeys("testuser011@tester.com");//fill in the email ID
        chromeDriver.findElement(By.name("spree_user[password]")).sendKeys("tester@123");//fill in the password
        chromeDriver.findElement(By.xpath("//input[@type='checkbox']")).click();//check the 'Remember me' checkbox
        chromeDriver.findElement(By.cssSelector("input[type='submit'][value='Login']")).submit();//click on the login button

        //welcome message is assigned to the variable
        String welcomeMessage = chromeDriver.findElement(By.xpath("//div[contains(text(),'Logged')]")).getText();

        //printing the welcome message after the sign-in
        System.out.println(welcomeMessage);

        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //click on the first category on the left pane under the categories
        WebElement firstCategoryUnderCategories = chromeDriver.findElement(By.xpath("(//h4[contains(text(),'Categories')]/following-sibling::div[@class='list-group']/a)[1]"));
        firstCategoryUnderCategories.click();

        //Add the first product after clicking on the first category
        WebElement firstProductUnderFirstCategory = chromeDriver.findElement(By.cssSelector("div#products :first-of-type a"));
        firstProductUnderFirstCategory.click();

        chromeDriver.findElement(By.id("quantity")).clear();
        chromeDriver.findElement(By.id("quantity")).sendKeys("2");
        chromeDriver.findElement(By.xpath("//button[@id='add-to-cart-button']")).click();

        //Go to cart and get the cart value
        String cartValueActual = chromeDriver.findElement(By.cssSelector("td[class='lead']")).getText();
        System.out.println("The cart value is : " + cartValueActual);

        //Assert the cart value
        String cartValueExpected = "$31.98";
        Assert.assertEquals(cartValueActual, cartValueExpected);
    }

    @AfterMethod
    public void logoutAndQuitBrowser() {

        System.out.println("Will logout now!");
        //logging out from the session
        WebElement logoutButton = chromeDriver.findElement(By.cssSelector("[href='/logout']"));
        logoutButton.click();

        //closing the browser session
        chromeDriver.quit();
    }
}

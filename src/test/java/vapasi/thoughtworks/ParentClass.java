package vapasi.thoughtworks;

import org.testng.Assert;
import org.testng.annotations.*;

public class ParentClass {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Hi! There!");
    }

    @BeforeClass
    public void displayMessage() {
        System.out.println("We are doing breakout assignment on TestNG assertions.");
    }

    @BeforeMethod
    public void thisIsBeforeMethod() {
        System.out.println("We will do a sum of two numbers.");
    }

    @AfterMethod
    public static void thisIsAfterMethod() {
        System.out.println("We are done.");
    }
}

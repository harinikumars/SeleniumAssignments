package vapasi.thoughtworks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChildClass extends ParentClass {

    @Test
    public double sumOfTwoNumbers(double number1, double number2) {
        double sumActual = number1 + number2;
        return sumActual;
    }

    @Test
    public void performingAssertions() {
        System.out.println("We are performing assertions.");
        double sumExpected = 46;
        Assert.assertEquals(sumOfTwoNumbers(12,34), sumExpected);
        Assert.assertTrue(sumOfTwoNumbers(12,34) == sumExpected);
        Assert.assertFalse(sumOfTwoNumbers(12,34) == 0, "Sorry! It's not matching.");
    }
}

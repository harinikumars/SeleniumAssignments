package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage {

    @FindBy(css="td[class='lead']")
    private WebElement totalCartValue;

    @FindBy(id="checkout-link")
    private WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String cartDetails() {

        //Go to cart and get the cart value
        return totalCartValue.getText();
    }
    public void continueToCheckOut(){
        checkoutButton.click();
    }
}

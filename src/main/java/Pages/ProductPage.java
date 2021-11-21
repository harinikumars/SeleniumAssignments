package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(id="quantity")
    private WebElement quantityTextBox;

    @FindBy(xpath = "//button[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    public void addProductToCart(String quantity){

        quantityTextBox.clear();
        quantityTextBox.sendKeys(quantity);
        addToCartButton.click();
    }
}

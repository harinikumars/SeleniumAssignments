package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//div[contains(text(),'Logged')]")
    private WebElement getWelcomeMessage;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String checkWelcomeMessage(){

        //welcome message is assigned to the variable
        String welcomeMessageActual = getWelcomeMessage.getText();
        return welcomeMessageActual;
    }
}

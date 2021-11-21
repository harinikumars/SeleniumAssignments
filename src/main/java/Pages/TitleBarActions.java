package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TitleBarActions {

    @FindBy(css="[href='/logout']")
    private WebElement logoutButton;

    public TitleBarActions(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void logoutFromApplication() {

        //logging out from the session
        System.out.println("We are logging out now!");
        logoutButton.click();
    }
}

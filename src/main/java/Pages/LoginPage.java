package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "[class='nav-link text-white']")
    private WebElement login;
    @FindBy(id="spree_user_email")
    private WebElement emailIdTextBox;
    @FindBy(name="spree_user[password]")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement rememberMeCheckBox;
    @FindBy(css = "input[type='submit'][value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void userLogIn(String userName, String password) {

        login.click();
        emailIdTextBox.sendKeys(userName);//fill in the email ID
        passwordTextBox.sendKeys(password);//fill in the password
        rememberMeCheckBox.click();//check the 'Remember me' checkbox
        loginButton.submit();//click on the login button
    }

}

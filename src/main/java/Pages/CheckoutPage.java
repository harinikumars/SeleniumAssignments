package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    @FindBy(id = "order_bill_address_attributes_firstname")
    private WebElement billingAddressFirstName;
    @FindBy(id = "order_bill_address_attributes_lastname")
    private WebElement billingAddressLastName;
    @FindBy(id = "order_bill_address_attributes_address1")
    private WebElement billingAddressFirstLine;
    @FindBy(id = "order_bill_address_attributes_city")
    private WebElement billingAddressCity;
    @FindBy(id = "order_bill_address_attributes_state_id")
    private WebElement billingAddressState;
    @FindBy(id = "order_bill_address_attributes_phone")
    private WebElement billingAddressPhoneNumber;
    @FindBy(id = "order_bill_address_attributes_zipcode")
    private WebElement billingAddressZipCode;
    @FindBy(id="save_user_address")
    private WebElement saveMyAddressCheckBox;
    @FindBy(name = "commit")
    private WebElement saveAndContinueButton;
    @FindBy(id = "order_shipments_attributes_0_selected_shipping_rate_id_1392")
    private WebElement twoDayShippingMethod;
    @FindBy(id = "order_payments_attributes__payment_method_id_3")
    private WebElement selectPaymentoptionCheck;


    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillBillingAddress(String firstName, String lastName, String address, String city, String state, String zipCode, String phone) {

        billingAddressFirstName.sendKeys(firstName);
        billingAddressLastName.sendKeys(lastName);
        billingAddressFirstLine.sendKeys(address);
        billingAddressCity.sendKeys(city);

        Select chooseState = new Select(billingAddressState);
        chooseState.selectByVisibleText(state);

        billingAddressZipCode.sendKeys(zipCode);
        billingAddressPhoneNumber.sendKeys(phone);
        saveMyAddressCheckBox.click();
        saveAndContinueButton.click();
    }

    public void selectShipping() {
        //twoDayShippingMethod.click();
        saveAndContinueButton.click();
    }

    public void selectCheckPayment() {
        selectPaymentoptionCheck.click();
        saveAndContinueButton.click();

    }
}

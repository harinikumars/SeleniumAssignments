package exercise1;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAddToCart extends  BaseClass{

    @Test
    public void loginChooseProductAddToCart() {

        //Step 1: Login to the Spree website
        LoginPage userLoginAction = new LoginPage(chromeDriver);
        userLoginAction.userLogIn("testuser101@tester.com","tester@123");

        //Step 2: Assert the welcome message in the home page
        HomePage homePage = new HomePage(chromeDriver);
        String welcomeMessageExpected = "Logged in successfully";
        Assert.assertEquals(homePage.checkWelcomeMessage(), welcomeMessageExpected);

        //Step 3: Select a category and a product from the list
        CategoryPage categoryProductSelection = new CategoryPage(chromeDriver);
        categoryProductSelection.selectCategory();
        categoryProductSelection.selectProduct();

        //Step 4: From the product details page, enter the quantity and add to cart
        ProductPage addItemToCart = new ProductPage(chromeDriver);
        addItemToCart.addProductToCart("2");

        //Step 5: Assert the total value in the cart for the above added product
        ShoppingCartPage cartValueValidation = new ShoppingCartPage(chromeDriver);
        String cartValueExpected = "$31.98";
        Assert.assertEquals(cartValueValidation.cartDetails(), cartValueExpected);

        //Step 6: Enter the Billing Address, Shipping method and payment by check
        CheckoutPage completeOrder = new CheckoutPage(chromeDriver);
        completeOrder.fillBillingAddress("Test","hsk","Wyo","Wyoming","Wyoming","82001","7896547890");
        completeOrder.selectShipping();
        completeOrder.selectCheckPayment();

        //Step 7: Log out from the application.
        TitleBarActions logout = new TitleBarActions(chromeDriver);
        logout.logoutFromApplication();
    }
}

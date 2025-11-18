package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends BaseClass {

    @Test
    public void testCompleteCheckoutFlow() {

        // Step 1: Search any product
        HomePage home = new HomePage(driver);
        home.search("computer");

        // Step 2: Click first product
        SearchPage search = new SearchPage(driver);
        search.clickFirstProduct();

        // Step 3: Add product to cart
        ProductPage product = new ProductPage(driver);
        product.clickAddToCart();

        String message = product.getSuccessMessage();
        System.out.println("Add-to-cart message: " + message);

        Assert.assertTrue(message.toLowerCase().contains("added"),
                "Product was NOT added to cart!"
        );

        product.closeNotificationIfPresent();

        // Step 4: Open cart & proceed
        CartPage cart = new CartPage(driver);
        cart.openCart();
        cart.acceptTerms();
        cart.clickCheckout();   // auto Guest Checkout

        // Step 5: Checkout steps
        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.fillBillingDetails(
                "Shankar",
                "Singh",
                "testuser@gmail.com",
                "India",
                "Hyderabad",
                "Street 1",
                "500081",
                "9999999999"
        );

        checkout.continueShippingAddress();   // Step 2
        checkout.continueShippingMethod();    // Step 3
        checkout.continuePaymentMethod();     // Step 4
        checkout.continuePaymentInfo();       // Step 5
        checkout.confirmOrder();              // Step 6

        // Step 9: Validate order success
        OrderConfirmationPage confirmation = new OrderConfirmationPage(driver);

        Assert.assertTrue(
                confirmation.verifyOrderSuccess(),
                "Order confirmation message NOT found!"
        );
    }
}

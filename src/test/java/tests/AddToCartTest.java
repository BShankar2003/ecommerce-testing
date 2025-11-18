package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

public class AddToCartTest extends BaseClass {

    @Test
    public void testAddProductToCart() {

        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
        ProductPage product = new ProductPage(driver);
        AddToCartPage cart = new AddToCartPage(driver);

        // Search a product
        home.search("computer");  // ✅ Correct method name

        // Open first product
        search.clickFirstProduct();

        System.out.println("PRODUCT PAGE TITLE: " + driver.getTitle());

        // Click Add to Cart
        product.clickAddToCart();  // ✅ Correct method name
    }

}

package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void testInvalidLogin() {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.enterEmail("wronguser@test.com");
        login.enterPassword("wrongpassword");
        login.clickLogin();

        String error = login.getErrorMessage();

        Assert.assertTrue(error.contains("Login was unsuccessful"));
    }

    @Test
    public void testValidLogin() {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.enterEmail("testuser@gmail.com");   // ← replace with your real test account
        login.enterPassword("testpassword");     // ← replace with real password
        login.clickLogin();

        Assert.assertTrue(driver.getTitle().contains("Demo Web Shop"));
    }
}

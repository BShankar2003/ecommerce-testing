package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cartLink = By.cssSelector("a.ico-cart");
    private By termsCheckbox = By.id("termsofservice");
    private By checkoutBtn = By.id("checkout");

    // Guest Checkout button (only appears if login is needed)
    private By checkoutAsGuestBtn = By.cssSelector("input.button-1.checkout-as-guest-button");

    // Notification bar — the element blocking your cart click
    private By notificationBar = By.id("bar-notification");
    private By notificationCloseBtn = By.cssSelector("#bar-notification .close");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===============================
    // 🔵 FIXED CART OPEN FUNCTION
    // ===============================
    public void openCart() {

        // 1️⃣ Close notification bar if visible
        try {
            if (driver.findElement(notificationBar).isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(notificationCloseBtn)).click();
                System.out.println("Notification bar closed.");
            }
        } catch (Exception ignored) {
            System.out.println("No notification bar to close.");
        }

        // 2️⃣ Wait until notification disappears
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationBar));
        } catch (Exception e) {
            System.out.println("Notification bar did not disappear, continuing...");
        }

        // 3️⃣ Now safely click Cart
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        System.out.println("Cart opened successfully.");
    }

    // ===============================
    // TERMS ACCEPT
    // ===============================
    public void acceptTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
        System.out.println("Terms & Conditions accepted.");
    }

    // ===============================
    // CHECKOUT BUTTON + AUTO LOGIN/GUEST
    // ===============================
    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        System.out.println("Clicked Checkout.");

        // If redirected to Login page → Use Guest Checkout
        if (driver.getCurrentUrl().contains("login")) {
            System.out.println("Redirected to login page... Trying Guest Checkout.");

            try {
                wait.until(ExpectedConditions.elementToBeClickable(checkoutAsGuestBtn)).click();
                System.out.println("Guest Checkout successful.");
            } catch (Exception e) {
                System.out.println("Guest Checkout button not found! Login page requires valid credentials.");
            }
        }
    }
}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Correct locators for Demo Web Shop
    private By billingContinueBtn = By.cssSelector("input.button-1.new-address-next-step-button");
    private By shippingContinueBtn = By.cssSelector("input.button-1.new-address-next-step-button");
    private By shippingMethodContinueBtn = By.cssSelector("input.button-1.shipping-method-next-step-button");
    private By paymentMethodContinueBtn = By.cssSelector("input.button-1.payment-method-next-step-button");
    private By paymentInfoContinueBtn = By.cssSelector("input.button-1.payment-info-next-step-button");
    private By confirmOrderBtn = By.cssSelector("input.button-1.confirm-order-next-step-button");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ---------------- B I L L I N G  -----------------
    public void fillBillingDetails(
            String fn, String ln, String email,
            String country, String city,
            String address, String zip, String phone
    ) {

        // If address dropdown exists, just click continue
        if (driver.findElements(By.id("billing-address-select")).size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(billingContinueBtn)).click();
            System.out.println("Billing address already saved. Continued.");
            return;
        }

        // Fill new billing address
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys(fn);
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys(ln);
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys(email);

        new Select(driver.findElement(By.id("BillingNewAddress_CountryId")))
                .selectByVisibleText(country);

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address);
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(zip);
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(phone);

        wait.until(ExpectedConditions.elementToBeClickable(billingContinueBtn)).click();
        System.out.println("Billing details submitted.");
    }

    // --------------- S H I P P I N G  A D D R E S S -----------------
    public void continueShippingAddress() {

        // (Optional) select pickup
        try {
            WebElement pickup = driver.findElement(By.id("PickUpInStore"));
            if (pickup.isDisplayed() && !pickup.isSelected()) {
                pickup.click();
            }
        } catch (Exception ignored) {}

        // CLICK THE 2ND CONTINUE BUTTON
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]")
        )).click();

        System.out.println("Shipping Address step completed.");
    }


    // ---------------- S H I P P I N G  M E T H O D -----------------
    public void continueShippingMethod() {

        try {
            WebElement option = driver.findElement(By.cssSelector("input[name='shippingoption']"));
            if (!option.isSelected()) option.click();
        } catch (Exception ignored) {}

        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueBtn)).click();
        System.out.println("Shipping Method step completed.");
    }

    // ---------------- P A Y M E N T  M E T H O D --------------------
    public void continuePaymentMethod() {

        try {
            WebElement pm = driver.findElement(By.cssSelector("input[name='paymentmethod']"));
            if (!pm.isSelected()) pm.click();
        } catch (Exception ignored) {}

        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueBtn)).click();
        System.out.println("Payment Method step completed.");
    }

    // ---------------- P A Y M E N T  I N F O ------------------------
    public void continuePaymentInfo() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinueBtn)).click();
        } catch (Exception e) {
            System.out.println("No Payment Info step, skipping.");
        }

        System.out.println("Payment Info step completed.");
    }

    // ---------------- C O N F I R M  O R D E R ----------------------
    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn)).click();
        System.out.println("Order confirmed.");
    }
}

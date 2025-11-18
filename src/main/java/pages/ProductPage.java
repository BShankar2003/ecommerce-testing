package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addToCartBtn = By.cssSelector("input[id*='add-to-cart-button']");
    private By successMessage = By.cssSelector(".bar-notification.success");
    private By closeNotificationBtn = By.cssSelector("span.close");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Click Add to Cart (with optional product attributes)
    public void clickAddToCart() {

        try {
            // Processor dropdown
            Select processor = new Select(driver.findElement(By.id("product_attribute_1")));
            processor.selectByIndex(1);

            // RAM dropdown
            Select ram = new Select(driver.findElement(By.id("product_attribute_2")));
            ram.selectByIndex(1);

            // HDD radio button
            WebElement hdd = driver.findElement(By.id("product_attribute_3_6"));
            hdd.click();

        } catch (Exception e) {
            System.out.println("No attributes available for this product.");
        }

        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addBtn.click();
    }

    // Read success notification text
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    // 🔥 NEW: Close notification bar so cart button is not blocked
    public void closeNotificationIfPresent() {
        try {
            WebDriverWait smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement closeBtn = smallWait.until(
                    ExpectedConditions.visibilityOfElementLocated(closeNotificationBtn)
            );
            closeBtn.click();

            System.out.println("Notification bar closed.");
        } catch (Exception e) {
            System.out.println("No notification bar to close.");
        }
    }
}

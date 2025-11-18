package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By confirmationLabel = By.cssSelector(".section.order-completed .title");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean verifyOrderSuccess() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationLabel))
                .getText()
                .toLowerCase()
                .contains("success");
    }
}

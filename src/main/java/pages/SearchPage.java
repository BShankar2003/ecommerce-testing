package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    By firstProduct = By.cssSelector(".product-title a");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickFirstProduct() {
        // REFIND the element every time to avoid StaleElementReferenceException
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }
}

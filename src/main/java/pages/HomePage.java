package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input#small-searchterms")
    private WebElement searchBox;

    @FindBy(css = "input.button-1.search-box-button")
    private WebElement searchButton;

    @FindBy(css = "a.ico-login")
    private WebElement loginLink;

    public void search(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchButton.click();
    }

    public void clickLogin() {
        loginLink.click();
    }
}

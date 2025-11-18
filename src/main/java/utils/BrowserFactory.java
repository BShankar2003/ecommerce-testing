package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            ChromeOptions options = new ChromeOptions();

            // DISABLE SAVE PASSWORD / AUTOFILL POPUPS
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");

            options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
                put("credentials_enable_service", false);
                put("profile.password_manager_enabled", false);
                put("profile.default_content_setting_values.notifications", 2);
                put("autofill.profile_enabled", false);
                put("autofill.credit_card_enabled", false);
            }});

            driver = new ChromeDriver(options);
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

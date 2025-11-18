package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;
import utils.ConfigReader;

public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ConfigReader.loadConfig();

        // Start driver → corrected method
        driver = BrowserFactory.getDriver();

        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}

package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    @Test
    public void verifyHomePageTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("Demo Web Shop"), "Title does not match!");
    }
}

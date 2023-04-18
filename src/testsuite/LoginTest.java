package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        // login with valid credentials
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginLink = driver.findElement(By.id("login-button"));
        loginLink.click();
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Products is not displayed", expectedMessage, actualMessage);

    }

    @Test

    public void verifyThatSixProductsAreDisplayedOnPage() {
        // verify products on display page
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginLink = driver.findElement(By.id("login-button"));
        loginLink.click();
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Products is not displayed", expectedMessage, actualMessage);
        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int totalProducts = productNo.size();
        // This is from requirement
        int expectedNumber = 6;
        // Verifying actual number matching with expected number
        Assert.assertEquals("Products numbers not matching", expectedNumber, totalProducts);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}

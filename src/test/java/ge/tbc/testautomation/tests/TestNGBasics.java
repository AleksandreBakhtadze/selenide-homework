package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.steps.SauceDemoSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class TestNGBasics extends BaseTest {
    SauceDemoSteps steps;

    @BeforeMethod
    public void navigateToHomePage() {
        System.out.println("=== Navigating to SauceDemo home page ===");
        //open("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void returnToHomePage() {
        System.out.println("=== Returning to SauceDemo home page ===");
       // open("https://www.saucedemo.com/");
    }

    @BeforeClass
    public void setUp() {
        Configuration.timeout = 10000;
    }

    @Test(invocationCount = 5, successPercentage = 60)
    public void testFlakyDiscountCode() {
        Random random = new Random();
        boolean discountApplied = random.nextBoolean();

        System.out.println("Discount applied? " + discountApplied);

        Assert.assertTrue(discountApplied, "Discount code failed to apply!");
    }



    @Test
    public void addToCartTest() {
        steps = new SauceDemoSteps();
        steps.openLoginPage();
        steps.login("standard_user", "secret_sauce");
        steps.addFirstProductToCart();
        steps.openCart();
    }

    @Test(dependsOnMethods = "addToCartTest")
    public void proceedToCheckoutTest() {
        steps.startCheckout();
        steps.fillCheckoutInfo("jamaliko", "gamer", "12345");
    }

    @Test(dependsOnMethods = "proceedToCheckoutTest")
    public void makePaymentTest() {
        steps.finishCheckout();
    }

    @Test(priority = 2)
    public void validateImageSizes() {
        steps.validateImageSizes(159, 238);
    }

    @Test(priority = 1)
    public void sortOffers() {
        steps = new SauceDemoSteps();
        steps.openLoginPage();
        steps.login("standard_user", "secret_sauce");
        steps.sortOffersByPriceLowToHigh();
    }

    @Test(priority = 3)
    public void validateBurgerMenu() {
        steps.validateBurgerMenuOpens();
    }

}

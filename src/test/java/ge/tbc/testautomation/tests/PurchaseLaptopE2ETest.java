package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.PlaceOrderSteps;
import ge.tbc.testautomation.steps.PurchaseConfirmationSteps;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

import ge.tbc.testautomation.pages.*;

public class PurchaseLaptopE2ETest {
    private demoBlazeHomePage homePage = new demoBlazeHomePage();
    private demoBlazeProductPage productPage = new demoBlazeProductPage();
    private demoBlazeCartPage cartPage = new demoBlazeCartPage();
    private PlaceOrderSteps placeOrderModal = new PlaceOrderSteps();
    private PurchaseConfirmationSteps purchaseConfirmation = new PurchaseConfirmationSteps();

    @Test(priority = 1)
    public void openHomePageAndGoToLaptops() {
        homePage.openPage()
                .goToLaptops();

        $$x("//div[@id='tbodyid']//a[contains(text(),'Sony vaio i5')]")
                .first()
                .shouldBe(visible);
    }

    @Test(priority = 2, dependsOnMethods = "openHomePageAndGoToLaptops")
    public void selectProductAndAddToCart() {
        productPage.selectSonyVaioI5()
                .addToCart();

        webdriver().shouldHave(urlContaining("prod.html?idp_"));
    }

    @Test(priority = 3, dependsOnMethods = "selectProductAndAddToCart")
    public void openCartPlaceOrderAndFillForm() {
        cartPage.openCart()
                .clickPlaceOrder();

        placeOrderModal.fillForm("giorgi", "Geo", "New Gori", "1234 5678 9012 3456", "12", "2025")
                .clickPurchase();
    }

    @Test(priority = 4, dependsOnMethods = "openCartPlaceOrderAndFillForm")
    public void verifyPurchaseConfirmationAndReturnHome() {
        purchaseConfirmation.verifySuccessMessage();
        purchaseConfirmation.clickOk();

        webdriver().shouldHave(url("https://www.demoblaze.com/cart.html"));
    }
}

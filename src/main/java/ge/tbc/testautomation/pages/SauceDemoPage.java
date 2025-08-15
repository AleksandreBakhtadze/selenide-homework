package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class SauceDemoPage {
    // Login Page
    public final SelenideElement usernameField = $("#user-name");
    public final SelenideElement passwordField = $("#password");
    public final SelenideElement loginButton = $("#login-button");

    // Products Page
    public final SelenideElement firstAddToCartButton =
            $("button[data-test='add-to-cart-sauce-labs-backpack']");
    public final SelenideElement cartIcon = $(".shopping_cart_link");
    public ElementsCollection productImages = $$(".inventory_item_img img");
    public SelenideElement sortDropdown = $("select[class*='product_sort_container']");
    public ElementsCollection productPrices = $$(".inventory_item_price");


    // Checkout Page
    public final SelenideElement checkoutButton = $("button[class*='btn btn_action btn_medium checkout_button ']");
    public final SelenideElement firstNameField = $("input[name*='firstName']");
    public final SelenideElement lastNameField = $("input[name*='lastName']");
    public final SelenideElement postalCodeField = $("input[name*='postalCode']");
    public final SelenideElement continueButton = $("#continue");
    public final SelenideElement finishButton = $("#finish");


    // Burger Menu
    public SelenideElement burgerMenuButton = $("#react-burger-menu-btn");
    public SelenideElement burgerMenuPanel = $(".bm-menu-wrap");
}

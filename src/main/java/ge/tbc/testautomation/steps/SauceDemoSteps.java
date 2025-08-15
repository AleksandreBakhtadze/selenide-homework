package ge.tbc.testautomation.steps;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.SauceDemoPage;

import java.util.List;
import java.util.stream.Collectors;

public class SauceDemoSteps {
    SauceDemoPage page = new SauceDemoPage();

    public void openLoginPage() {
        open("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        page.usernameField.setValue(username);
        page.passwordField.setValue(password);
        page.loginButton.click();
    }

    public void addFirstProductToCart() {
        page.firstAddToCartButton.click();
    }

    public void openCart() {
        page.cartIcon.click();
    }

    public void startCheckout() {
        page.checkoutButton.click();
    }

    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        page.firstNameField.setValue(firstName);
        page.lastNameField.setValue(lastName);
        page.postalCodeField.setValue(postalCode);
        page.continueButton.click();
    }

    public void finishCheckout() {
        page.finishButton.click();
    }
    public void validateImageSizes(double expectedWidth, double expectedHeight) {
        for (var img : page.productImages) {
            img.shouldBe(Condition.visible);
            int width = Integer.parseInt(img.getAttribute("width"));
            int height = Integer.parseInt(img.getAttribute("height"));
            if (width != expectedWidth || height != expectedHeight) {
                throw new AssertionError(
                        "Image size mismatch. Expected: " + expectedWidth + "x" + expectedHeight +
                                " but got: " + width + "x" + height
                );
            }
        }
    }

    public void sortOffersByPriceLowToHigh() {
        page.sortDropdown.selectOption("Price (low to high)");
        List<Double> prices = page.productPrices.texts().stream()
                .map(p -> Double.parseDouble(p.replace("$", "")))
                .collect(Collectors.toList());

        List<Double> sorted = prices.stream().sorted().collect(Collectors.toList());
        if (!prices.equals(sorted)) {
            throw new AssertionError("Prices are not sorted low to high");
        }
    }

    public void validateBurgerMenuOpens() {
        page.burgerMenuButton.click();
        page.burgerMenuPanel.shouldBe(Condition.visible);
    }
}

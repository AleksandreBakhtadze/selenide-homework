package ge.tbc.testautomation.pages;

import static com.codeborne.selenide.Selenide.$x;

public class demoBlazeCartPage {

    public demoBlazeCartPage openCart() {
        $x("//a[text()='Cart']").click();
        return this;
    }

    public demoBlazeCartPage clickPlaceOrder() {
        $x("//button[text()='Place Order']").click();
        return this;
    }
}

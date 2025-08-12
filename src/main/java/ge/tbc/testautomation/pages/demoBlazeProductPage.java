package ge.tbc.testautomation.pages;

import static com.codeborne.selenide.Selenide.$x;

public class demoBlazeProductPage {

    public demoBlazeProductPage selectSonyVaioI5() {
        $x("//a[text()='Sony vaio i5']").click();
        return this;
    }

    public demoBlazeProductPage addToCart() {
        $x("//a[text()='Add to cart']").click();
        com.codeborne.selenide.Selenide.confirm(); // accept alert
        return this;
    }

}

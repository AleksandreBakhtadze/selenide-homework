package ge.tbc.testautomation.steps;

import static com.codeborne.selenide.Selenide.$;

public class PlaceOrderSteps {

    public PlaceOrderSteps fillForm(String name, String country, String city, String card, String month, String year) {
        $("#name").setValue(name);
        $("#country").setValue(country);
        $("#city").setValue(city);
        $("#card").setValue(card);
        $("#month").setValue(month);
        $("#year").setValue(year);
        return this;
    }

    public PlaceOrderSteps clickPurchase() {
        com.codeborne.selenide.Selenide.$x("//button[text()='Purchase']").click();
        return this;
    }
}

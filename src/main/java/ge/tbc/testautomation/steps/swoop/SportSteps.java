package ge.tbc.testautomation.steps.swoop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikDemosDesignPage;
import ge.tbc.testautomation.pages.swoop.HomePage;
import ge.tbc.testautomation.pages.swoop.SportPage;

import java.util.List;
import java.util.SortedMap;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;


public class SportSteps {

    private SportPage sportPage;

    public SportSteps() {
        sportPage = new SportPage();
    }

    public SportSteps validatePrices(String optionName, int price) {
        SelenideElement option = sportPage.getOption(optionName);

        String originalPriceText = option.$("h4.line-through").text();
        String discountPercentText = option.$("p[class*='text-primary_green']").text();

        int originalPrice = Integer.parseInt(originalPriceText.replace("₾", "").replace(".00", "").trim());
        int discountPercent = Integer.parseInt(discountPercentText.replace("-", "").replace("%", "").trim());

        int expectedPriceAfterDiscount = originalPrice - (originalPrice * discountPercent / 100);

        assertEquals(price, expectedPriceAfterDiscount,
                "Price validation failed for " + optionName +
                        ". Expected: " + expectedPriceAfterDiscount + ", Actual: " + price);

        return this;
    }
}

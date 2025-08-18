package ge.tbc.testautomation.steps.swoop;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.swoop.FilterPage;

import static com.codeborne.selenide.Selenide.$$;
import static org.testng.AssertJUnit.assertTrue;

public class FilterSteps {

    private final FilterPage filterPage;

    public FilterSteps() {
        this.filterPage = new FilterPage();
    }

    public void generalFilterValidate() {
        filterPage.moreOptions.click();
        filterPage.filter.click();
        $$("div.flex.flex-col.gap-0.tablet\\:gap-2.items-start.relative.overflow-hidden")
               .shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    public void rangeFilterValidate() {
        filterPage.startingRange.setValue("0");
        filterPage.endRange.setValue("50");
        filterPage.applyButton.click();
        filterPage.allPrices.filter(Condition.exist).forEach(price -> {
            String priceText = price.text();
            int priceValue = (int) Double.parseDouble(priceText.replace("₾", "").trim());
            assertTrue(priceValue > 0&& priceValue <= 50);
        });
    }
}

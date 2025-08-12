package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.TelerikPricingPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class TelerikPricingSteps {

    private final TelerikPricingPage pricingPage;

    public TelerikPricingSteps() {
        this.pricingPage = new TelerikPricingPage();
    }

    public TelerikPricingPage getPricingPage() {
        return pricingPage;
    }

    public void showDetails(){
        pricingPage.showDetailsButton.click();
    }

    public void goToIndividualProducts(){
        pricingPage.individualProducts.click();
    }

    public List<String> getDevCraftUIOptions() {
        ElementsCollection items = pricingPage.devCraftUIOptions;
        return items.texts();
    }

    public List<String> getDevCraftCompleteOptions() {
        ElementsCollection items = pricingPage.devCraftCompleteOptions;
        return items.texts();
    }

    public List<String> getDevCraftUltimateOptions() {
        ElementsCollection items = pricingPage.devCraftUltimateOptions;
        return items.texts();
    }

    public boolean isDotPresentInBundleColumn(String featureText, int columnZeroBased) {
        ElementsCollection cells = pricingPage.getBundleCellsForFeatureWithDotCheck(featureText);

        if (cells.size() > columnZeroBased) {
            SelenideElement cell = cells.get(columnZeroBased);

            return cell.$("span.dot").exists() ;
        }
        return false;
    }

    public List<String> getIndividualProductsOptions() {
        ElementsCollection items = pricingPage.purchaseCardRow.$$x("./div[contains(@class, 'Purchase-card')]");
        return items.texts();
    }

    public boolean isPrioritySupportSelected(SelenideElement cardElement) {
        SelenideElement comboBox = cardElement.$x(".//div[@class='ComboBox']");

        if (!comboBox.exists()) {
            System.out.println("ComboBox not found in card: " + cardElement.getAttribute("class"));
            return false;
        }

        String selectedIndex = comboBox.getAttribute("data-combobox-selected-index");

        return "1".equals(selectedIndex);
    }

    public String getPrioritySupportPrice(SelenideElement element) {
        return element.$x(".//span[@class='js-priority']").getText();
    }
}


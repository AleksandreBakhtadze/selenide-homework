package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TelerikPricingPage extends BasePage {

    public SelenideElement individualProducts = $x("//button[contains(@class, 'Tabs-tab') and contains(text(), 'Individual Products')]");

    public SelenideElement showDetailsButton = $x("//button[contains(@class, 'Purchase-expandCollapse') and contains(@class, 'is-active')]");

    public SelenideElement header =  $x("//div[contains(@class,'Purchase-mobileHead') and contains(@class,'is-sticky')]");

    public SelenideElement devCraftUI = $x("//div[@class='Purchase-cell Purchase-cell--DevCraftUI js-mobile-option is-active']");

    public ElementsCollection devCraftUIOptions = devCraftUI.$$x(".//ul/li");

    public SelenideElement devCraftComplete = $x("//div[@class='Purchase-cell Purchase-cell--DevCraftComplete js-mobile-option']");

    public ElementsCollection devCraftCompleteOptions = devCraftComplete.$$x(".//ul/li");

    public SelenideElement devCraftUltimate = $x("//div[@class='Purchase-cell Purchase-cell--DevCraftUltimate js-mobile-option']");

    public ElementsCollection devCraftUltimateOptions = devCraftUltimate.$$x(".//ul/li");

    public ElementsCollection getBundleCellsForFeatureWithDotCheck(String featureText) {
        return $x("//div[(dt//button[contains(normalize-space(.), '" + featureText + "')] or dt[contains(normalize-space(.), '" + featureText + "')]) and dd/span[@class='dot']]")
                .$$("dd");
    }

    public ElementsCollection getBundleCellsForFeatureWithoutDotCheck(String featureText) {
        return $x("//div[(dt//button[contains(normalize-space(.), '" + featureText + "')] or dt[contains(normalize-space(.), '" + featureText + "')])]")
                .$$("dd");
    }

    public boolean doesFeatureExist(String featureText) {
        return $x("//button[contains(text(), '" + featureText + "')]").exists();
    }


    public SelenideElement purchaseCardRow = $x("//div[contains(@class,'Purchase-cardRow') and contains(@class,'js-filter-web')]");

    public SelenideElement kendoReact = $$x("//div[@class='Purchase-card js-card-kendo-react']").get(1);

    public SelenideElement kendoUI = $x("//div[@class='Purchase-card js-card-kendo-ui']");


}

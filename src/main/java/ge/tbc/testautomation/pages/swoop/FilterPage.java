package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.BasePage;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class FilterPage extends BasePage {

    public SelenideElement moreOptions = $x("//div[@class='mt-1'][.//text()[contains(.,'მეტის ნახვა')]]//p");

    public SelenideElement filter = $x("//span[@class='font-tbcx-regular text-md'][.//text()[contains(.,'საბურთალო')]]");

    public SelenideElement startingRange =
            $x("//div[@class='relative'][.//text()[contains(., 'დან')]]//input");

    public SelenideElement endRange =
            $x("//div[@class='relative'][.//text()[contains(., 'მდე')]]//input");

    public SelenideElement applyButton = $x("//button[@data-testid='secondary-button']");

    public ElementsCollection allPrices =$$("h4.text-primary_black-100-value.text-2md.leading-5.font-tbcx-bold");


}

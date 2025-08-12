package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TelerikDemosPage extends BasePage {
    public SelenideElement pricingLink = $x("//a[contains(text(),'Pricing')]");
}

package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.TelerikDemosPage;

import static com.codeborne.selenide.Selenide.*;

public class TelerikDemosSteps {

    private final TelerikDemosPage demosPage;

    public TelerikDemosSteps() {
        this.demosPage = new TelerikDemosPage();
    }

    public void openDemosPage() {
        open("https://www.telerik.com/support/demos");
        demosPage.pricingLink.shouldBe(com.codeborne.selenide.Condition.visible);
    }

    public void goToPricingPage() {
        demosPage.pricingLink.click();
    }


}

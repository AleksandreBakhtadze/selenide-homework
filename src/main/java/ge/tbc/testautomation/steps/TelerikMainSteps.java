package ge.tbc.testautomation.steps;


import ge.tbc.testautomation.pages.TelerikMainPage;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;


public class TelerikMainSteps {
    private TelerikMainPage telerikMainPage;

    public TelerikMainSteps() {
        this.telerikMainPage = new TelerikMainPage();
    }

    public void openTelerikHomePage() {
        open("https://www.telerik.com/");
    }

    public void hoverOverAllProducts() {
        actions().moveToElement(telerikMainPage.allProducts).perform();
    }

    public void clickAllProductsLink() {
        telerikMainPage.link.click();
    }
}

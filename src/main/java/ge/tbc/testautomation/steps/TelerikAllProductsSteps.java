package ge.tbc.testautomation.steps;


import ge.tbc.testautomation.pages.TelerikAllProductsPage;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TelerikAllProductsSteps {
    private TelerikAllProductsPage allProductsPage;

    public TelerikAllProductsSteps() {
        this.allProductsPage = new TelerikAllProductsPage();
    }

    public void scrollToFiddlerLink() {
        actions().scrollToElement(allProductsPage.fiddlerLink).perform();
        executeJavaScript("window.scrollBy(0, 300)");
    }

    public void clickFiddlerLink() {
        allProductsPage.fiddlerLink.click();
    }
}

package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class TelerikAllProductsPage extends BasePage {

    public final SelenideElement fiddlerLink = $("a[href*='/download/fiddler']");

}

package ge.tbc.testautomation.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class TelerikMainPage extends BasePage {

    public final SelenideElement allProducts = $("button[class*='TK-Products-Menu-Item-Button']");

    public final SelenideElement link = $("a[href*='/all-products']");

}

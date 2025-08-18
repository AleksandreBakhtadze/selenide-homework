package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.BasePage;

import static com.codeborne.selenide.Selenide.*;


public class HomePage extends BasePage {

    public final SelenideElement closeButton = $("button[class^='flex group justify-center items-center border rounded-full']");

    public final SelenideElement sportLink = $("a[href*='/category/110/sporti/']");


}


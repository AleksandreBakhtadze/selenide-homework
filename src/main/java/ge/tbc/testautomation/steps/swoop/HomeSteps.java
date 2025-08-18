package ge.tbc.testautomation.steps.swoop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikDemosDesignPage;
import ge.tbc.testautomation.pages.swoop.HomePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;


public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps() {
        open("https://swoop.ge");
        homePage = new HomePage();
    }
    public HomeSteps openPage(String url) {
        String path = String.format("a[href*='%s']", url);
        SelenideElement link = $(path);
        link.click();
        return this;
    }

    public HomeSteps closeAdd(){
        if (homePage.closeButton.isDisplayed()) {
            homePage.closeButton.click();
        }
        return this;
    }

    public HomeSteps goToSportsPage(){
        homePage.sportLink.click();
        return this;
    }

}

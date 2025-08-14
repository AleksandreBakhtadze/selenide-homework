package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikDemosDesignPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class TelerikDemosDesignSteps {

    private final TelerikDemosDesignPage page = new TelerikDemosDesignPage();

    public TelerikDemosDesignSteps openDemosPage() {
        open("https://www.telerik.com/support/demos");
        return this;
    }

    public TelerikDemosDesignSteps validateWebCardsHoverEffect(){
        page.webCards.stream()
                .filter(card -> !card.getAttribute("data-sf-element").equals("Column 6"))
                .forEach(card -> {
                    actions().moveToElement(card.$("div[class^='HoverImg u-mb1']")).perform();
                    card.$("div[class^='HoverImg u-mb1']")
                            .shouldHave(Condition.cssValue("background-color", "rgba(40, 46, 137, 0.75)"));
                });
        return this;
    }

    public TelerikDemosDesignSteps validateKendoUIContainsVue() {
        actions().moveToElement(page.kendoUICard.$("div[class^='HoverImg u-mb1']")).perform();
        assertTrue(page.kendoUICard.$("div[class^='HoverImg u-mb1']")
                .$("div[class^='LinkContainer']")
                .text().contains("UI for Vue demos"));
        return this;
    }

    public TelerikDemosDesignSteps filterDesktopItemsMicrosoftStore() {
        List<SelenideElement> microsoftCards = page.desktopCards.stream()
                .filter(card -> card.$("a[href*='microsoft']").exists())
                .toList();

        assertEquals(microsoftCards.size(), 2);
        return this;
    }

    public TelerikDemosDesignSteps validateXamarinAvailableOnAllStores() {
        SelenideElement card = page.mobileCards.get(1);
        ElementsCollection links = card.findAll("a[href^='https']");

        assertTrue(links.get(0).getAttribute("href").contains("apple"));
        assertTrue(links.get(1).getAttribute("href").contains("google"));
        assertTrue(links.get(2).getAttribute("href").contains("microsoft"));
        return this;
    }

    public TelerikDemosDesignSteps validateSectionLinksSticky() {
        page.sectionLinksNav.shouldBe(Condition.visible);
        executeJavaScript("window.scrollBy(0, 1000)");
        page.sectionLinksNav.shouldBe(Condition.visible);
        assertTrue(page.sectionLinksNav.getAttribute("class").contains("fixed"));
        return this;
    }

    public TelerikDemosDesignSteps validateSectionLinkActivationOnScroll() {
        for (int i = 0; i < page.sectionsHeaders.size(); i++) {
            actions().scrollToElement(page.sectionsHeaders.get(i)).perform();
            executeJavaScript("window.scrollBy(0, 800)");
            assertTrue(page.sectionLinks.get(i).getAttribute("class").contains("active"));
        }
        return this;
    }

    public TelerikDemosDesignSteps validateSectionLinksNavigateCorrectly() {
        executeJavaScript("window.scrollTo(0, 0)");
        for (int i = 0; i < page.sectionLinks.size(); i++) {
            page.sectionLinks.get(i).click();
            page.sections.get(i).shouldBe(Condition.visible);
        }
        return this;
    }
}

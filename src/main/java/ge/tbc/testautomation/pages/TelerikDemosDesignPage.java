package ge.tbc.testautomation.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class TelerikDemosDesignPage extends BasePage {

    // Sections
    public final ElementsCollection sections = $("#ContentPlaceholder1_C257_Col00").$$("div[data-sf-element*='Row']");
    public final ElementsCollection sectionsHeaders = $("#ContentPlaceholder1_C257_Col00").$$("h2[class*='u-mb0 h3']");

    // Web Cards (first section)
    public final ElementsCollection webCards = sections.get(0).$$("div[id^='ContentPlaceholder1_C329_']");

    // Specific card: Kendo UI Card
    public final SelenideElement kendoUICard = sections.get(0).$("div[id^='ContentPlaceholder1_C329_Col00']");

    // Desktop Cards (second section)
    public final ElementsCollection desktopCards = sections.get(1).$$("div[id^='ContentPlaceholder1_C337_']");

    // Mobile Cards (third section)
    public final ElementsCollection mobileCards = sections.get(2).$$("div[id^='ContentPlaceholder1_C340_Col']");

    // Navigation bar
    public final SelenideElement sectionLinksNav = $("nav[data-fixit-render-dummy*='1']");
    public final ElementsCollection sectionLinks = sectionLinksNav.$("div[class*='container']")
            .$$("a[class*='NavAlt-anchor u-b0']");

}

package ge.tbc.testautomation.tests;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.pages.TelerikDemosDesignPage;
import ge.tbc.testautomation.steps.TelerikDemosDesignSteps;
import ge.tbc.testautomation.steps.TelerikDemosSteps;
import ge.tbc.testautomation.steps.TelerikPricingSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class TelerikDemosDesignTests {

    private TelerikDemosDesignSteps demosSteps;

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        demosSteps = new TelerikDemosDesignSteps();
    }


    @Test
    public void validateDemosDesign(){
        demosSteps.openDemosPage()
                .validateWebCardsHoverEffect()
                .validateKendoUIContainsVue()
                .filterDesktopItemsMicrosoftStore()
                .validateXamarinAvailableOnAllStores()
                .validateSectionLinksSticky()
                .validateSectionLinkActivationOnScroll()
                .validateSectionLinksNavigateCorrectly();
    }
}

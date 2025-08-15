package ge.tbc.testautomation.tests;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.pages.TelerikDemosDesignPage;
import ge.tbc.testautomation.steps.TelerikDemosDesignSteps;
import ge.tbc.testautomation.steps.TelerikDemosSteps;
import ge.tbc.testautomation.steps.TelerikPricingSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class TelerikDemosDesignTests extends BaseTest{

    private TelerikDemosDesignSteps demosSteps;

    @BeforeClass
    public void setUp() {
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        demosSteps = new TelerikDemosDesignSteps();
    }
    @BeforeMethod
    public void navigateToHomePage() {
        System.out.println("=== Navigating to Telerik home page ===");
        //demosSteps.openDemosPage();
    }

    @AfterMethod
    public void returnToHomePage() {
        System.out.println("=== Returning to Telerik home page ===");
        //demosSteps.openDemosPage();
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

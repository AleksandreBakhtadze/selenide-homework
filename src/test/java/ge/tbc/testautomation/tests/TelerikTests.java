package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import ge.tbc.testautomation.steps.TelerikDemosSteps;
import ge.tbc.testautomation.steps.TelerikPricingSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.prompt;
import static org.testng.Assert.*;

public class TelerikTests {


    private TelerikDemosSteps demosSteps;
    private TelerikPricingSteps pricingSteps;

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        demosSteps = new TelerikDemosSteps();
        pricingSteps = new TelerikPricingSteps();
    }

    @Test
    public void validateBundleOffers() {
        SoftAssert softAssert = new SoftAssert();

        // Navigate to demos page
        demosSteps.openDemosPage();

        // Go to Pricing page
        demosSteps.goToPricingPage();

        pricingSteps.showDetails();

        // 1) 'Mocking solution for rapid unit testing' feature is not included in DevCraft UI.
        List<String> devCraftUIOptions = pricingSteps.getDevCraftUIOptions();
        List<String> devCraftCompleteOptions = pricingSteps.getDevCraftCompleteOptions();
        List<String> devCraftUltimateOptions = pricingSteps.getDevCraftUltimateOptions();

        softAssert.assertFalse(devCraftUIOptions.contains("Mocking solution for rapid unit testing"));

        // 2) 'Issue escalation' is supported only in DevCraft Ultimate.
        boolean hasDotInUltimate = pricingSteps.isDotPresentInBundleColumn("Issue escalation", 2);
        boolean hasDotInUI = pricingSteps.isDotPresentInBundleColumn("Issue escalation", 0);
        boolean hasDotInComplete = pricingSteps.isDotPresentInBundleColumn("Issue escalation", 1);

        softAssert.assertTrue(hasDotInUltimate, "Ultimate should have Issue escalation");
        softAssert.assertFalse(hasDotInUI, "DevCraft UI should NOT have Issue escalation");
        softAssert.assertFalse(hasDotInComplete, "DevCraft Complete should NOT have Issue escalation");

        // 3) 'End-to-end report management solution' is supported only in DevCraft Ultimate.
        softAssert.assertTrue(
                devCraftUltimateOptions.contains("End-to-end report management solution") &&
                        !devCraftCompleteOptions.contains("End-to-end report management solution") &&
                        !devCraftUIOptions.contains("End-to-end report management solution")
        );

        // 4) 'Telerik Test Studio Dev Edition' is supported only in DevCraft Ultimate.
        boolean featureExists = pricingSteps.getPricingPage().doesFeatureExist("Telerik Test Studio Dev Edition");
        softAssert.assertTrue(featureExists, "Telerik Test Studio Dev Edition does not exist on the page");

        // 5) 'Kendo UI for jQuery' is supported on all offers.
        hasDotInUltimate = pricingSteps.isDotPresentInBundleColumn("Kendo UI for jQuery", 2);
        hasDotInUI = pricingSteps.isDotPresentInBundleColumn("Kendo UI for jQuery", 0);
        hasDotInComplete = pricingSteps.isDotPresentInBundleColumn("Kendo UI for jQuery", 1);

        softAssert.assertTrue(hasDotInUltimate);
        softAssert.assertTrue(hasDotInUI);
        softAssert.assertTrue(hasDotInComplete);

        // 6) DevCraft Ultimate supports 1 instance of 'Telerik Report Server' with 15 users.
        softAssert.assertTrue(pricingSteps.getPricingPage().getBundleCellsForFeatureWithoutDotCheck("Telerik Report Server")
                .get(2).getText().contains("1 instance with 15 users"));

        // 7) 'Telerik Reporting' is supported by only DevCraft Complete and DevCraft Ultimate.
        hasDotInUltimate = pricingSteps.isDotPresentInBundleColumn("Telerik Reporting", 2);
        hasDotInUI = pricingSteps.isDotPresentInBundleColumn("Telerik Reporting", 0);
        hasDotInComplete = pricingSteps.isDotPresentInBundleColumn("Telerik Reporting", 1);

        softAssert.assertTrue(hasDotInUltimate);
        softAssert.assertFalse(hasDotInUI);
        softAssert.assertTrue(hasDotInComplete);

        // 8) 'Access to on-demand videos' is supported by all offers.
        hasDotInUltimate = pricingSteps.isDotPresentInBundleColumn("Access to on-demand videos", 2);
        hasDotInUI = pricingSteps.isDotPresentInBundleColumn("Access to on-demand videos", 0);
        hasDotInComplete = pricingSteps.isDotPresentInBundleColumn("Access to on-demand videos", 1);

        softAssert.assertTrue(hasDotInUltimate);
        softAssert.assertTrue(hasDotInUI);
        softAssert.assertTrue(hasDotInComplete);

        // 9) sticky test
        pricingSteps.getPricingPage().header.shouldHave(attributeMatching("style", ".*position:\\s*fixed.*"));

        // Assert all collected
        softAssert.assertAll();
    }

    @Test
    public void validateIndividualOffers(){
        SoftAssert softAssert = new SoftAssert();

        // Navigate to demos page
        demosSteps.openDemosPage();

        // Go to Pricing page
        demosSteps.goToPricingPage();

        // Go to individual products
        pricingSteps.goToIndividualProducts();

        // 1) Validate that there are only 3 individual offers: KendoReact Free, KendoReact, Kendo UI.
        List<String> offersNames = pricingSteps.getIndividualProductsOptions();
        softAssert.assertEquals(offersNames.size(), 3);
        softAssert.assertTrue(offersNames.get(0).contains("KendoReact Free"));
        softAssert.assertTrue(offersNames.get(1).contains("KendoReact"));
        softAssert.assertTrue(offersNames.get(2).contains("Kendo UI"));

        // 2) KendoReact and Kendo UI offers have Priority Support selected by default.
        softAssert.assertTrue(pricingSteps.isPrioritySupportSelected(pricingSteps.getPricingPage().kendoReact),
                "KendoReact should have Priority Support selected");
        softAssert.assertTrue(pricingSteps.isPrioritySupportSelected(pricingSteps.getPricingPage().kendoUI),
                "KendoUI should have Priority Support selected");

        // 3) The price of Priority Support is $749 on KendoReact.
        softAssert.assertEquals(pricingSteps.getPrioritySupportPrice(pricingSteps.getPricingPage().kendoReact), "749");

        // 4) The price of Priority Support is $1149 on Kendo UI.
        softAssert.assertEquals(pricingSteps.getPrioritySupportPrice(pricingSteps.getPricingPage().kendoUI), "1149", "Price does not match");

        // Assert all collected
        softAssert.assertAll();
    }

}

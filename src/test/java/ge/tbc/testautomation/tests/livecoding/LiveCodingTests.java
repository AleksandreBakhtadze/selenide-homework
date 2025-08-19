package ge.tbc.testautomation.tests.livecoding;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
//import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.steps.livecoding.blogSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LiveCodingTests {
    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 7000;
        Configuration.baseUrl="https://www.tbcbank.ge/";
        //WebDriverManager.chromedriver().setup();
        open("https://www.tbcbank.ge/");
    }
    @Test(invocationCount = 2, successPercentage = 50)//retry logic
    public void languageSwitchToEnglish() {
        // TODO: Find the correct selector for language switch
        $(byText("EN")).click(); // FIXME: placeholder

        // FIXME: Verify menu label in English
        $$("tbcx-pw-navigation-item[class^='ng-star-inserted']").findBy(text("Personal")).shouldBe(visible); // TODO: adjust text

        // TODO: Add retry logic
    }
    @Test
    public void filterResetRestoresDefaultState() {
        open("en/offers/all-offers?segment=All&filters=");
        $x("//input[@type='checkbox'][.//text(contains(., 'Installment'))]").click(); // FIXME

        int filtered = $$(".marketing__cards-list").size(); // FIXME
        assertTrue(filtered > 0, "Expected at least one filtered result");

        $("[data-test='reset-filters']").click(); // FIXME

        // TODO: Add validation to confirm that results are restored to the default state

    }
    @Test
    public void assertBlogDatesAreDescending_simple() {
        // TODO: Implement POM

        open("en/blogs");

        ElementsCollection cards = $$(" app-marketing-list tbcx-pw-image-card").shouldHave(CollectionCondition.sizeGreaterThan(0));

        int take = Math.min(5, cards.size());
        List<LocalDate> dates = new ArrayList<>();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
        System.out.println(take);

        for (int i = 0; i < take; i++) {

            ElementsCollection freshCards = $$("app-marketing-list tbcx-pw-image-card").shouldHave(CollectionCondition.sizeGreaterThan(0));
            freshCards.get(i).scrollTo().click();

            String dateText = $("app-textpage-header app-textpage-additional").getText().trim();

            LocalDate parsed = LocalDate.parse(dateText, fmt);
            dates.add(parsed);

            back();
        }

        List<LocalDate> sortedDesc = new ArrayList<>(dates);
        sortedDesc.sort(Comparator.reverseOrder());

        assertEquals(dates, sortedDesc, "Blog dates are not in descending order");
    }
}
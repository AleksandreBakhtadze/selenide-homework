package ge.tbc.testautomation.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.data.SwoopDataSupplier;
import ge.tbc.testautomation.steps.SauceDemoSteps;
import ge.tbc.testautomation.steps.TelerikAllProductsSteps;
import ge.tbc.testautomation.steps.TelerikFiddlerDownloadingSteps;
import ge.tbc.testautomation.steps.TelerikMainSteps;
import ge.tbc.testautomation.steps.swoop.HomeSteps;
import ge.tbc.testautomation.steps.swoop.SportSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

@Test(groups = {"swoop 1"})
public class ParametrizedSwoopTests {

    private HomeSteps homeSteps;
    private SportSteps sportSteps;

    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";
        homeSteps = new HomeSteps();
        sportSteps = new SportSteps();
    }

    @Test(dataProvider = "offersData", dataProviderClass = SwoopDataSupplier.class)
    public void SportsTests(String optionName, int price) {
        homeSteps.closeAdd().goToSportsPage();
        sportSteps.validatePrices(optionName,price);
    }

}

















package ge.tbc.testautomation.tests;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.data.SwoopDataSupplier;
import ge.tbc.testautomation.steps.swoop.FilterSteps;
import ge.tbc.testautomation.steps.swoop.HomeSteps;
import ge.tbc.testautomation.steps.swoop.SportSteps;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;


@Test(groups = {"swoop 2"})
public class ParametrizedSwoopTests2 {

    private String param;
    @Factory(dataProvider = "getPagesData",dataProviderClass = SwoopDataSupplier.class)
    public ParametrizedSwoopTests2(String param) {
        this.param = param;
    }

    private HomeSteps homeSteps;
    private FilterSteps filterSteps;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";
        this.homeSteps = new HomeSteps();
        this.filterSteps = new FilterSteps();
    }


    @Test
    public void filterTest() {
        homeSteps.closeAdd().openPage(param);
        filterSteps.generalFilterValidate();
    }

    @Test
    public void rangeTest() {
        homeSteps.closeAdd().openPage(param);
        filterSteps.rangeFilterValidate();
    }
}

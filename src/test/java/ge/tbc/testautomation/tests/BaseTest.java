package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    WebDriver driver;

    @BeforeTest
    @Parameters({"browserType"})
    public void setUp(String browserType){
        if (browserType.equals("chrome")){
            driver = new ChromeDriver();
            WebDriverRunner.setWebDriver(driver);
        } else if (browserType.equals("firefox")) {
            driver = new FirefoxDriver();
            WebDriverRunner.setWebDriver(driver);
        }
        else {
            driver = new EdgeDriver();
            WebDriverRunner.setWebDriver(driver);
        }
        Configuration.browser = browserType;
        Configuration.timeout = 10000;
    }


    @AfterTest
    public void afterTest() {
        System.out.println("=== [AfterTest] Closing browser ===");
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Initializing dummy DB connection");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Closing dummy DB connection");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Logging into e-commerce app ");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Logging out of e-commerce app (dummy)");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigating to home page (dummy)");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Returning to home page (dummy)");
    }
}
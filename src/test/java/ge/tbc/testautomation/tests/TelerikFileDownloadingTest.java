package ge.tbc.testautomation.tests;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.steps.TelerikAllProductsSteps;
import ge.tbc.testautomation.steps.TelerikFiddlerDownloadingSteps;
import ge.tbc.testautomation.steps.TelerikMainSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TelerikFileDownloadingTest {

    private TelerikMainSteps mainSteps;
    private TelerikAllProductsSteps allProductsSteps;
    private TelerikFiddlerDownloadingSteps fiddlerDownloadingSteps;

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";
        Configuration.downloadsFolder = "build\\downloads";
        Configuration.fileDownload = FileDownloadMode.FOLDER;

        // Initialize step classes
        mainSteps = new TelerikMainSteps();
        allProductsSteps = new TelerikAllProductsSteps();
        fiddlerDownloadingSteps = new TelerikFiddlerDownloadingSteps();
    }

    @Test
    public void testTelerikFileDownloading() throws Exception {
        // Navigate to Telerik main page
        mainSteps.openTelerikHomePage();

        // Navigate to All Products page
        mainSteps.hoverOverAllProducts();
        mainSteps.clickAllProductsLink();

        // Navigate to Fiddler download page
        allProductsSteps.scrollToFiddlerLink();
        allProductsSteps.clickFiddlerLink();

        // Fill download form and download file
        fiddlerDownloadingSteps.fillDownloadForm("Personal use", "test@test.com", "Germany");

        // Verify file was downloaded
        fiddlerDownloadingSteps.verifyFileDownloaded("FiddlerSetup.5.0.20253.3311-latest.exe");
    }
}
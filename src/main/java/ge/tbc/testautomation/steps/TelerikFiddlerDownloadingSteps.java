package ge.tbc.testautomation.steps;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import ge.tbc.testautomation.pages.TelerikFiddlerDownloadingPage;
import java.io.File;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static org.testng.Assert.assertEquals;

public class TelerikFiddlerDownloadingSteps {

    private TelerikFiddlerDownloadingPage fiddlerDownloadPage;

    public TelerikFiddlerDownloadingSteps() {
        this.fiddlerDownloadPage = new TelerikFiddlerDownloadingPage();
    }

    public void selectUsageType(String usageType) {
        fiddlerDownloadPage.selectDropdown.selectOption(usageType);
    }

    public void enterEmail(String email) {
        fiddlerDownloadPage.emailField.setValue(email);
    }

    public void selectCountry(String country) {
        fiddlerDownloadPage.selectCountry.selectOption(country);
    }

    public void clickOptInCheckbox() {
        fiddlerDownloadPage.checkBox.click();
    }

    public void clickCustomCheckbox() {
        fiddlerDownloadPage.checkBox2.click();
    }

    public void scrollDown() {
        executeJavaScript("window.scrollBy(0, 300)");
    }

    public void clickDownloadButton() {
        fiddlerDownloadPage.button.click();
    }

    public void fillDownloadForm(String usageType, String email, String country) {
        selectUsageType(usageType);
        enterEmail(email);
        selectCountry(country);
        clickOptInCheckbox();
        clickCustomCheckbox();
        scrollDown();
        clickDownloadButton();
        Selenide.sleep(7000);
    }

    public void verifyFileDownloaded(String expectedFileName) {
        File downloadDir = new File(Configuration.downloadsFolder);
        File[] files = downloadDir.listFiles();
        System.out.println(files.length);
        File[] files2 = files[files.length-1].listFiles();
        assertEquals(files2.length, 1);
        assertEquals(files2[0].getName(), expectedFileName);
    }

}

package ge.tbc.testautomation.pages;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    public void openUrl(String url) {
        open(url);
    }

    public void scrollToElement(String cssSelector) {
        $(cssSelector).scrollIntoView(true);
    }
}

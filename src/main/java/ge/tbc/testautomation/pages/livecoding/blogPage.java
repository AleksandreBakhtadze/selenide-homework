package ge.tbc.testautomation.pages.livecoding;

import com.codeborne.selenide.ElementsCollection;
import ge.tbc.testautomation.pages.BasePage;

import static com.codeborne.selenide.Selenide.$$;

public class blogPage extends BasePage {

    public ElementsCollection cards = $$(" app-marketing-list tbcx-pw-image-card");

}

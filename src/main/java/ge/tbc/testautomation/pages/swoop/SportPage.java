package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.BasePage;

import static com.codeborne.selenide.Selenide.*;



public class SportPage extends BasePage {

    public SelenideElement getOption(String optionName) {
        String path = String.format(
                "//div[contains(@class, 'flex') and contains(@class, 'relative')]" +
                        "[.//h4[contains(text(), '%s')]]", optionName
        );
        return $x(path);
    }


}

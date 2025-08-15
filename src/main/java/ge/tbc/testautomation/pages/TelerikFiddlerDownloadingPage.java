package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;



public class TelerikFiddlerDownloadingPage extends BasePage {

    public final SelenideElement selectDropdown = $("select[id*='Dropdown-1']");

    public final SelenideElement emailField = $("input[id*='Email-1']");

    public final SelenideElement selectCountry = $("select[id*='Country-1']");

    public final SelenideElement checkBox = $("input[id*='OptInOutField-1']");

    public final SelenideElement checkBox2 = $("input[name*='CustomCheckboxesFieldController']");

    public final SelenideElement button = $("button[class*='js-btn js-btnWin Btn Btn--prim u-db u-mt3']");

}

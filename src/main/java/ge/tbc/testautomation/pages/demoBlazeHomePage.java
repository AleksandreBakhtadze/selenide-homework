package ge.tbc.testautomation.pages;

import static com.codeborne.selenide.Selenide.$x;

public class demoBlazeHomePage {

    public demoBlazeHomePage openPage() {
        com.codeborne.selenide.Selenide.open("https://www.demoblaze.com/");
        return this;
    }

    public demoBlazeHomePage goToLaptops() {
        $x("//a[text()='Laptops']").click();
        return this;
    }
}

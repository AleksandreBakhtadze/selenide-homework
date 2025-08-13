package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class PurchaseConfirmationSteps {

    public PurchaseConfirmationSteps verifySuccessMessage() {
        $x("//div[contains(@class,'sweet-alert')]")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Thank you for your purchase!"));
        return this;
    }

    public void clickOk() {
        $x("//button[text()='OK']").click();
    }


}

package org.example.signup.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class CodeConfirmationPage {

    @FindBy(xpath = "//div[contains(@class,'invalid-feedback')]")
    private SelenideElement verifyMessage;

    String inputdata = "//input[contains(@aria-label,'Digit %d')]";

    @Step("click login button")
    public CodeConfirmationPage enterPinCode(String pin) {
    //  xpath start from 1
        for (int i = 1; i <= pin.length(); i++) {
            $x(String.format(inputdata, i))
                    .setValue(String.valueOf(pin.charAt(i - 1)));
        }
        return this;

    }

    @Step("click login button")
    public CodeConfirmationPage clickConfirm() {
        $("#submit-verification").click();
        return page(CodeConfirmationPage.class);
    }

    public void confirmVerify() {
        Assertions.assertEquals("Mã OTP không đúng.", verifyMessage.getText());
    }
}

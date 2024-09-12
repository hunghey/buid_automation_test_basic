package org.example.signup.pages;

import io.qameta.allure.Step;
import org.example.signup.common.EmailUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CodeConfirmationPage {
//    String verification = EmailUtils.getOTPFromMail("detainhom1101@gmail.com","bochungquoc");


    public static void enterPinCode(String pin) {
        // Giả sử mã PIN là một chuỗi 4 ký tự số, ví dụ: "1234"

        // Kiểm tra chiều dài mã pin có đủ 4 ký tự không
        if (pin.length() != 4) {
            throw new IllegalArgumentException("PIN must be 4 digits");
        }

        // Điền từng ký tự vào ô tương ứng
        $("#pin_0").setValue(String.valueOf(pin.charAt(0)));
        $("#pin_1").setValue(String.valueOf(pin.charAt(1)));
        $("#pin_2").setValue(String.valueOf(pin.charAt(2)));
        $("#pin_3").setValue(String.valueOf(pin.charAt(3)));
    }


    @Step("click login button")
    public CodeConfirmationPage co() {
//        $("#verification-code-input").setValue(verification);

        $("#submit-verification").click();
        return page(CodeConfirmationPage.class);
    }

}

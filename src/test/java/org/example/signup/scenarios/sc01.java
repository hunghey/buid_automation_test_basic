package org.example.signup.scenarios;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Story;
import org.example.signup.common.AbstractTest;
import org.example.signup.pages.CodeConfirmationPage;
import org.example.signup.pages.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.signup.common.EmailUtils.getOTPFromMail;

public class sc01 extends AbstractTest {

    RegisterPage homePage;
    String email = "nguyenlephuhung15@gmail.com";

    @BeforeEach
    public void setUp() {

        homePage = Selenide.open("", RegisterPage.class);

    }

    @Story("Create and login account")
    @Test
    public void createAndLogin() {
        CodeConfirmationPage inputEmailandVerifyvcation =
                homePage.inputRegister("acwwcjwqcetbekphvt@poplk.com")
                        .clickLogin();
//        App password if 2FA is enabled
        String codeVerify = getVerificationCode(email, "npya osms zbzt fcpk", "Mã OTP của Quý khách");
        inputEmailandVerifyvcation.enterPinCode(codeVerify)
                .confirmVerify();

    }

    public String getVerificationCode(String email, String passworde, String titleEmail) {
        return getOTPFromMail(email, passworde, titleEmail);
    }
}

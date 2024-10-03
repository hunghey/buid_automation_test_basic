package org.example.signup.scenarios;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Story;
import org.example.signup.common.AbstractTest;
import org.example.signup.common.EmailUtils;
import org.example.signup.models.Account;
import org.example.signup.pages.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class sc01 extends AbstractTest {

    RegisterPage homePage;

    @BeforeEach
    public void setUp() {

        homePage = Selenide.open("", RegisterPage.class);

    }

    @Story("Create and login account")
    @Test
    public void createAndLogin() {

        // App password if 2FA is enabled
        EmailUtils.getOTPFromMail("nguyenlephuhung15@gmail.com","npya osms zbzt fcpk","Mã OTP của Quý khách");
//        homePage.inputRegister()
//                .clickLogin()
//                .co();
    }
}

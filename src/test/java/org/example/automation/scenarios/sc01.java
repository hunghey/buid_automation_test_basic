package org.example.automation.scenarios;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Story;
import org.example.automation.common.AbstractTest;
import org.example.automation.models.Account;
import org.example.automation.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class sc01 extends AbstractTest {

    protected static Account account;
    HomePage homePage;

    @BeforeEach
    public void setUp() {
        account = new Account().toModel();

        homePage = Selenide.open("", HomePage.class);

    }

    @Story("Create and login account")
    @Test
    public void createAndLogin() {

        homePage = homePage.goToRegisterPage()
                .inputInformation(account)
                .clickRegister()
                .goToHomePage()
                .logout()
                .goToLoginPage()
                .inputLogin(account)
                .clickLogin();
    }
}

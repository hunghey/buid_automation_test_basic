package org.example.signup.common;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class AbstractTest {

    @BeforeAll
    public static void setupTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.open("");
    }

    @AfterAll
    public static void cleanup() {
        SelenideLogger.removeListener("AllureSelenide");

        WebDriverRunner.closeWebDriver();
    }
}

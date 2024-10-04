package org.example.signup.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.automation.models.Account;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class RegisterPage {

    @FindBy(id = "floatingInput")
    private SelenideElement emailInput;


    @FindBy(xpath = "//button[text()='Tiếp tục']")
    private SelenideElement signUpBtn;

    @Step("login account with email and password after register")
    public RegisterPage inputRegister(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("click login button")
    public CodeConfirmationPage clickLogin() {
        signUpBtn.click();
        sleep(2000);
        return page(CodeConfirmationPage.class);
    }

}

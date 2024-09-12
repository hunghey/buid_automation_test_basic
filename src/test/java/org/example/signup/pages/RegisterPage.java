package org.example.signup.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.automation.models.Account;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    @FindBy(id = "floatingInput")
    private SelenideElement emailInput;


    @FindBy(xpath = "//button[text()='Tiếp tục']")
    private SelenideElement signUpBtn;

    @Step("login account with email and password after register")
    public RegisterPage inputRegister() {
        emailInput.setValue("detainhom1101@gmail.com");
//        emailInput.setValue("p.hung15122002@gmail.com");
        return this;
    }

    @Step("click login button")
    public CodeConfirmationPage clickLogin() {
        signUpBtn.click();
        return page(CodeConfirmationPage.class);
    }

}

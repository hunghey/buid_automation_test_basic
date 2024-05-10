package org.example.automation.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.automation.models.Account;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {
    @FindBy(id = "gender-male")
    private SelenideElement maleGender;

    @FindBy(id = "gender-female")
    private SelenideElement femaleGender;

    @FindBy(id = "FirstName")
    private SelenideElement firstNameInput;

    @FindBy(id = "LastName")
    private SelenideElement lastNameInput;

    @FindBy(className = "DateOfBirthDay")
    private SelenideElement daySelect;

    @FindBy(className = "DateOfBirthMonth")
    private SelenideElement mothSelect;

    @FindBy(className = "DateOfBirthYear")
    private SelenideElement yearSelect;

    @FindBy(id = "Email")
    private SelenideElement emailInput;

    @FindBy(id = "Password")
    private SelenideElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    private SelenideElement passwordConfirm;

    @FindBy(id = "register-button")
    private SelenideElement registerBtn;

    String email;
    String password;

    @Step("Register account")
    public RegisterPage inputInformation(Account account) {
        firstNameInput.setValue(account.getFirstname());
        lastNameInput.setValue(account.getLastname());
        emailInput.setValue(account.generateEmail().getEmail());
        passwordInput.setValue(account.getPassword());
        passwordConfirm.setValue(account.getPassword());
        return page(RegisterPage.class);
    }

    @Step("Register successfully")
    public RegisterCompletePage clickRegister() {
        registerBtn.click();

        Assertions.assertEquals($(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
        return page(RegisterCompletePage.class);
    }
}

package org.example.automation.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.automation.models.Account;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(className = "email")
    private SelenideElement emailInput;

    @FindBy(className = "password")
    private SelenideElement passwordInput;
    @FindBy(className = "login-button")
    private SelenideElement loginBtn;


    @Step("login account with email and password after register")
    public LoginPage inputLogin(Account account){
        emailInput.setValue(account.generateEmail().getEmail());
        passwordInput.setValue(account.getPassword());
        return this;
    }
    @Step("click login button")
    public HomePage clickLogin(){
        loginBtn.click();
        return page(HomePage.class);
    }

}

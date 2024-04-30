package org.example.automation.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    @FindBy(className = "ico-register")
    private SelenideElement registerBtn;

    @FindBy(className = "ico-login")
    private SelenideElement loginBtn;

    @FindBy(xpath = "//div[@class='page-title']/h1")
    private SelenideElement pageTitle;

    @Step("Sign up account")
    public RegisterPage goToRegisterPage(){
        registerBtn.click();
        Assertions.assertEquals(pageTitle.getOwnText(),"Register");
        return page(RegisterPage.class);
    }
    @Test
    @Step("Sign up account")
    public void goToRegisterPage1(){
        registerBtn.click();
        Assertions.assertEquals(pageTitle.getOwnText(),"Register");
    }

    @Step("Login account")
    public LoginPage goToLoginPage(){
        loginBtn.click();
        Assertions.assertEquals(pageTitle.getOwnText(),"Welcome, Please Sign In!");
        return page(LoginPage.class);
    }
}

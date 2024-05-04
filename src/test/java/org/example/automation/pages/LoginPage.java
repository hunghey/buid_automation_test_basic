package org.example.automation.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(className = "email")
    private SelenideElement emailInput;

    @FindBy(className = "password")
    private SelenideElement passwordInput;


    @Step("addaa")
    public HomePage inputSearch(){
        emailInput.setValue(email);
        passwordInput.setValue(password);
        return page(HomePage.class);
    }

}

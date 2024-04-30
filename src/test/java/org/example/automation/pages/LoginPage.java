package org.example.automation.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    @FindBy(xpath = "//input[@name='email']")
    private SelenideElement email;


    @Step("addaa")
    public LoginPage inputSearch(){
        email.setValue("mail@mail.com");
        return this;
    }

}

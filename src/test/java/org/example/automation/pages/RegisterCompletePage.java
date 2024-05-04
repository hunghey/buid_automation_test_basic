package org.example.automation.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterCompletePage {
    @FindBy(className = "register-continue-button")
    private SelenideElement continueBtn;

    @FindBy(className = "ico-account")
    private SelenideElement myAccount;

    @Step("Home page")
    public HomePage goToHomePage(){
        continueBtn.click();

        Assertions.assertEquals($(By.xpath("//div[@class='topic-block-title']/h2")).getText(),"Welcome to our store");
        myAccount.isEnabled();
        return page(HomePage.class);
    }
}
package org.example.App.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//a[normalize-space()='Forgot Username/Password?']")
    private WebElement headerPageText;

    
    public LoginPage login(){


        return this;
    }
}

package org.example.automation.Scenarios;

import com.codeborne.selenide.Selenide;
import org.example.automation.constants.ScenarioKey;
import org.example.automation.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class sc01 {
    @Test
    public void sc01(){
        LoginPage login = Selenide.open(ScenarioKey.URL,LoginPage.class).inputSearch();
    }
}

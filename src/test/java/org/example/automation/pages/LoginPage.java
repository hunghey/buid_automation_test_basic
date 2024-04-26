package org.example.automation.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(id = "login")
    private WebElement btnClick;

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://anhtester.com/login");

    }

    @Test()
    public void inputSearch() {

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("abc");

//        btnClick.click();
    }

    @AfterMethod
    public void teardown() {

        driver.quit();
    }

}

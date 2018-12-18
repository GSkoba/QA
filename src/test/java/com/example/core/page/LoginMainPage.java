package com.example.core.page;

import com.example.core.HelperBase;
import com.example.model.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class LoginMainPage extends HelperBase {

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        assertTrue("password page cant download", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("field_email")),
                5,
                500));
    }

    public UserMainPageHelper doLogin(TestBot testBot) {
        type(testBot.getLogin(), By.id("field_email"));
        type(testBot.getPassword(), By.id("field_password"));
        typeKeys(Keys.ENTER, By.id("field_password"));
        return new UserMainPageHelper(driver);
    }
}

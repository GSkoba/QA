package com.example.core;

import com.example.model.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMainPage extends HelperBase {

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check(){}

    public void doLogin(TestBot testBot) {
        type(testBot.getLogin(), By.id("field_email"));
        type(testBot.getPassword(), By.id("field_password"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[3]"));
    }
}

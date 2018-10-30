package com.example.core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupMainPage extends HelperBase{
    private static final By CREATE_NEW_GROUP = By.xpath(".//*[@class='create-group']");

    public GroupMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
       /* (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driverWeb) {
                return isElementPresent(CREATE_NEW_GROUP);
            }
        });

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_GROUP));
    */}

    public void clickCreateButton() {
        click(By.id("hook_FormButton_button_create"));
    }

    public void typeGroupName(String groupName) {
        type(groupName, By.id("field_name"));
    }

    public void clickInterestGroup() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Публичная страница'])[1]/following::div[1]"));
    }

    public void clickCreateGroup() {
        click(CREATE_NEW_GROUP);
    }
}

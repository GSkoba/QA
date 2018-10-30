package com.example.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPageHelper extends HelperBase{

    public UserMainPageHelper(WebDriver driver) {
        super(driver);
    }

    protected void check(){}

    public void clickGroupsOnToolbar() {
        click(By.xpath(".//*[@class='nav-side __navigation' ]/*[contains(@href,'groups')]"));
    }
}

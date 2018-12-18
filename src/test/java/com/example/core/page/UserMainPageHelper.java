package com.example.core.page;

import com.example.core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPageHelper extends HelperBase {

    public UserMainPageHelper(WebDriver driver) {
        super(driver);
    }

    protected void check(){}

    public FotoMainPage clickFotoOnToolBar(){
        click(By.xpath(".//*[contains(@data-l,'t,userPhotos')]"));
        return new FotoMainPage(driver);
    }
}

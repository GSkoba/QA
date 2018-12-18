package com.example.core.wrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wrapper {
    private WebElement element;
    private WebDriver driver;

    public Wrapper(WebElement element, WebDriver driver){
        this.element = element;
        this.driver = driver;
    }

    public WebElement getElement() {
        return element;
    }
}

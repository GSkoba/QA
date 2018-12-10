package com.example.core;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public abstract class HelperBase {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected abstract void check();

    protected void type(String groupName, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(groupName);
    }

    protected void typeKeys(Keys keys, By by) {
        driver.findElement(by).sendKeys(keys);
    }

    protected void typeKeys(String keys, By by){
        driver.findElement(by).sendKeys(keys);
    }

    protected void typeText(String text, By by){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void implicitWaitInSeconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

}

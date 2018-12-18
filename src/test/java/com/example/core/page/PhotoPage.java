package com.example.core.page;

import com.example.core.HelperBase;
import com.example.core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class PhotoPage extends HelperBase {
    private static final By COOL_BUTTON = By.xpath(".//*[contains(@class,'photo-layer_bottom_block __actions')]//*[contains(@class,'wide-count')]");
    private static final By COOL_COUNT = By.xpath(".//*[contains(@class,'photo-layer_bottom_block __actions')]//*[contains(@class,'wide-count')]//*[contains(@class,'widget_count')][1]");

    public PhotoPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        assertTrue("photo cant download", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        COOL_BUTTON),
                5,
                500));
    }

    public void clickCoolButton() {
        click(COOL_BUTTON);
    }

    public String getCoolCount() {
        return driver.findElement(COOL_COUNT).getText();
    }
}

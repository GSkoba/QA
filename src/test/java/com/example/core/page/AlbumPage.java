package com.example.core.page;

import com.example.core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class AlbumPage extends HelperBase {
    private static final By ALBUM_NAME_EDIT = By.xpath(".//*[@class='photo-album_details ellip']//*");
    private static final By EDIT_ALBUM = By.xpath(".//*[contains(@class,'portlet_controls')]//*[contains(@class,'button-pro __sec __small')]");
    private static final By DELETE_BUTTON = By.xpath(".//*[contains(@data-l,'t,.r')]");
    private static final By DELETE_CONFIRM_BUTTON = By.xpath(".//*[contains(@id,'hook_FormButton_button_delete_confirm')]");
    private static final By ALBUM_NAME = By.name("albumSettings.name");
    private static final By SAVE_ALBUM_CHANGE = By.xpath(".//*[contains(@data-l,'t,submit')]");
    private static final By UPLOAD_FOTO = By.xpath(".//input[@name='photo']");

    public AlbumPage(WebDriver driver){
        super(driver);
    }

    protected void check() {
        assertTrue("album cant download", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        EDIT_ALBUM),
                5,
                500));
    }

    public String getAlbumName() {
        return driver.findElement(ALBUM_NAME_EDIT).getText();
    }

    public void clickEditButton() {
        click(EDIT_ALBUM);
    }

    public void clickDeleteAlbum() {
        click(DELETE_BUTTON);
        click(DELETE_CONFIRM_BUTTON);
    }

    public void changeAlbumName(String name) {
        typeText(name, ALBUM_NAME);
    }

    public void saveChange() {
        click(SAVE_ALBUM_CHANGE);
    }

    public void uploadPhoto(String path) {
        typeKeys(path, UPLOAD_FOTO);
    }
}

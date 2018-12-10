package com.example.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FotoMainPage extends HelperBase {
    private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@data-l,'t,create-photo-album')]");
    private static final By ALBUM_FIELD = By.xpath(".//*[contains(@name,'st.layer.photoAlbumName')]");
    private static final By SAVE_ALBUM = By.xpath(".//*[contains(@name,'button_album_create')]");
    private static final By ALBUM_NAME_EDIT = By.xpath(".//*[@class='photo-album_details ellip']//*");
    private static final By ALBUM_TITLE = By.xpath(".//*[@class='photo-album_title __counter']");
    private static final By ALBUM_OVERLAY = By.xpath(".//*[contains(@class,'photo-album-card_title ellip') and contains(@title,'" + "Grisha" + "')]");
    private static final By UPLOAD_FOTO = By.xpath(".//input[@name='photo']");
    private static final By EDIT_ALBUM = By.xpath(".//*[contains(@class,'portlet_controls')]//*[contains(@class,'button-pro __sec __small')]");
    private static final By ALBUM_NAME = By.name("albumSettings.name");
    private static final By SAVE_ALBUM_CHANGE = By.xpath(".//*[contains(@data-l,'t,submit')]");
    private static final By DELETE_BUTTON = By.xpath(".//*[contains(@data-l,'t,.r')]");
    private static final By DELETE_CONFIRM_BUTTON = By.xpath(".//*[contains(@id,'hook_FormButton_button_delete_confirm')]");
    private static final By PHOTO_FROM_PHOTOSTREAM = By.xpath(".//*[@class='photo-stream']//*[contains(@class,'ugrid __s')]//*[@class='ugrid_i'][1]");
    private static final By COOL_BUTTON = By.xpath(".//*[contains(@class,'photo-layer_bottom_block __actions')]//*[contains(@class,'wide-count')]");
    private static final By COOL_COUNT = By.xpath(".//*[contains(@class,'photo-layer_bottom_block __actions')]//*[contains(@class,'wide-count')]//*[contains(@class,'widget_count')][1]");

    public FotoMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
    }

    public void clickCreateAlbum() {
        click(CREATE_NEW_ALBUM);
    }

    public void inputDiscForAlbum(String disc) {
        type(disc, ALBUM_FIELD);
    }

    public void clickSaveAlbumButton() {
        click(SAVE_ALBUM);
    }

    public void chooseAlbum() {
        click(ALBUM_OVERLAY);
    }

    public void uploadPhoto(String path) {
        typeKeys(path, UPLOAD_FOTO);
    }

    public String getTextOfUploadedPhotosTip() {
        return driver.findElement(ALBUM_TITLE).getText();
    }

    public void clickEditButton() {
        click(EDIT_ALBUM);
    }

    public void changeAlbumName(String name) {
        typeText(name, ALBUM_NAME);
    }

    public String getAlbumName() {
        return driver.findElement(ALBUM_NAME_EDIT).getText();
    }

    public void saveChange() {
        click(SAVE_ALBUM_CHANGE);
    }

    public void clickDeleteAlbum() {
        click(DELETE_BUTTON);
        click(DELETE_CONFIRM_BUTTON);
    }

    public void clickToPhotoStream() {
        click(PHOTO_FROM_PHOTOSTREAM);
    }

    public void clickCoolButton() {
        click(COOL_BUTTON);
    }

    public String getCoolCount() {
        return driver.findElement(COOL_COUNT).getText();
    }
}

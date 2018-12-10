package com.example.core;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class FotoMainPage extends HelperBase {
    private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@data-l,'t,create-photo-album')]");
    private static final By ALBUM_FIELD = By.xpath(".//*[contains(@name,'st.layer.photoAlbumName')]");
    private static final By SAVE_ALBUM = By.xpath(".//*[contains(@name,'button_album_create')]");
    private static final By ALBUM_OVERLAY = By.xpath(".//*[contains(@class,'photo-album-card_title ellip') and contains(@title,'"+ "Grisha" +"')]");
    private static final By UPLOAD_FOTO = By.xpath(".//*[contains(@class,'html5-link_w js-fileapi-wrapper')]//*[contains(@class,'button-pro __small')]");
    private static final By EDIT_ALBUM = By.xpath(".//*[contains(@class,'portlet_controls')]//*[contains(@class,'button-pro __sec __small')]");
    private static final By ALBUM_NAME = By.name("albumSettings.name");
    private static final By SAVE_ALBUM_CHANGE = By.xpath(".//*[contains(@data-l,'t,submit')]");



    public FotoMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        /* (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driverWeb) {
                return isElementPresent(CREATE_NEW_GROUP);
            }
        });

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_GROUP));
    */
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

    public void chooseAlbum(String albumName){
        click(ALBUM_OVERLAY);
    }

    public void uploadPhoto(String path) {
        //typeKeys(path, By.xpath(".//*[contains(@class,'html5-upload-link __before-upload')]"));
        driver.findElement(By.xpath(".//input[@name='photo']")).sendKeys(path);
    }

    public String getTextOfUploadedPhotosTip() {
        return driver.findElement(By.xpath(".//*[@class='photo-album_title __counter']")).getText();
    }

    public void clickEditButton(){
        click(EDIT_ALBUM);
    }

    public void changeAlbumName(String name){
        typeText(name, ALBUM_NAME);
    }

    public String getAlbumName(){
        return driver.findElement(By.xpath(".//*[@class='photo-album_details ellip']//*")).getText();
    }



    public void saveChange(){
        click(SAVE_ALBUM_CHANGE);
    }

    public void addDiscForFoto(){}
}

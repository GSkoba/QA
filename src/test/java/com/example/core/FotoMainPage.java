package com.example.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FotoMainPage extends HelperBase {
    private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@data-l,'t,create-photo-album')]");
    private static final By ALBUM_FIELD = By.xpath(".//*[contains(@name,'st.layer.photoAlbumName')]");
    private static final By SAVE_ALBUM = By.xpath(".//*[contains(@name,'button_album_create')]");
    private static final By ALBUM_OVERLAY = By.xpath(".//*[contains(@class,'photo-album-card_title ellip') and contains(@title,'"+ "Grisha" +"')]");
    private static final By UPLOAD_FOTO = By.xpath(".//*[contains(@class,'html5-link_w js-fileapi-wrapper')]//*[contains(@class,'button-pro __small')]");
    private static final By EDIT_ALBUM = By.xpath(".//*[contains(@class,'portlet_controls')]//*[contains(@class,'button-pro __sec __small')]");
    private static final By NAME_ALBUM = By.xpath(".//*[contains(@class,'text-field h-mod photo-album-name __mod-counter __active')]");
    private static final By SAVE_ALBUM_CHANGE = By.xpath(".//*[contains(@data-l,'t,submit')]");



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

    public void clickSaveAlbumButten() {
        click(SAVE_ALBUM);
    }

    public void chooseAlbum(String albumName){
        click(ALBUM_OVERLAY);
    }

    public void uploadFoto(String path){
        click(UPLOAD_FOTO);
        typeKeys(path, By.name("photo"));
    }

    public void clickEditButton(){
        click(EDIT_ALBUM);
    }

    public void changeAlbumName(String name){
        typeKeys(name, NAME_ALBUM);
    }

    public void saveChange(){
        click(SAVE_ALBUM_CHANGE);
    }

    public void addDiscForFoto(){}
}
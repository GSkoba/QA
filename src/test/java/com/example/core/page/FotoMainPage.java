package com.example.core.page;

import com.example.core.HelperBase;
import com.example.core.transformer.Transformer;
import com.example.core.wrapper.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

import static com.example.core.transformer.Transformer.wrap;
import static org.junit.Assert.assertTrue;

public class FotoMainPage extends HelperBase {
    private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@data-l,'t,create-photo-album')]");
    private static final By ALBUM_FIELD = By.xpath(".//*[contains(@name,'st.layer.photoAlbumName')]");
    private static final By SAVE_ALBUM = By.xpath(".//*[contains(@name,'button_album_create')]");
    private static final By ALBUM_TITLE = By.xpath(".//*[@class='photo-album_title __counter']");
//    private static final By ALBUM_OVERLAY = By.xpath(".//*[contains(@class,'photo-album-card_title ellip') and contains(@title,'" + "spring" + "')]");
    private static final By ALBUM_OVERLAY = By.xpath(".//*[@class='portlet photo-albums']//*[@class='ugrid_cnt']//*[@class='ugrid_i']//*[@title!='Личные фото']");
    private static final By PHOTO_FROM_PHOTOSTREAM = By.xpath(".//*[@class='photo-stream']//*[contains(@class,'ugrid __s')]//*[@class='ugrid_i'][1]");

    public FotoMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue("fotomain page cant download", explicitWait(
                ExpectedConditions.visibilityOfElementLocated(
                        CREATE_NEW_ALBUM),
                5,
                500));
    }

    public void clickCreateAlbum() {
        click(CREATE_NEW_ALBUM);
    }

    public void inputDiscForAlbum(String disc) {
        typeCharacter(disc, ALBUM_FIELD);
    }

    public AlbumPage clickSaveAlbumButton() {
        click(SAVE_ALBUM);
        return new AlbumPage(driver);
    }

    public AlbumPage chooseAlbum() {
        getRandomAlbum().click();
        return new AlbumPage(driver);
    }

    public String getTextOfUploadedPhotosTip() {
        return driver.findElement(ALBUM_TITLE).getText();
    }

    public WebElement getRandomAlbum(){
         List<Wrapper> albums = Transformer.wrap(driver.findElements(ALBUM_OVERLAY), driver);
        Random rd = new Random();
        Wrapper wrapper = albums.get(rd.nextInt(albums.size()));
        return wrapper.getElement();
    }

    public PhotoPage clickToPhotoStream() {
        click(PHOTO_FROM_PHOTOSTREAM);
        return new PhotoPage(driver);
    }
}

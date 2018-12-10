package com.example.tests;

import com.example.core.FotoMainPage;
import com.example.core.LoginMainPage;
import com.example.core.TestBase;
import com.example.core.UserMainPageHelper;
import com.example.model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class FotoTest extends TestBase {
    private static final byte[] login = new byte[]{56, 57, 54, 53, 48, 54, 55, 49, 56, 50, 50};
    private static final byte[] password = new byte[]{82, 108, 111, 108, 113, 55, 49, 106};

    @Test
    public void testCaseCreateAlbum() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot(new String(login), new String(password)));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.clickCreateAlbum();
        String albumName = "Grisha";
        fotoMainPage.inputDiscForAlbum(albumName);
        fotoMainPage.implicitWaitInSeconds(8);
        fotoMainPage.clickSaveAlbumButton();
        Assert.assertEquals(albumName,fotoMainPage.getAlbumName());
    }

    @Test
    public void testCaseUploadPhotoToAlbum() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot(new String(login), new String(password)));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.chooseAlbum();
        fotoMainPage.uploadPhoto("/Users/grigory.skobelev/Documents/work/photoshop/dogMoon.jpg");
        fotoMainPage.implicitWaitInSeconds(3);
        Assert.assertEquals("Загружено1", fotoMainPage.getTextOfUploadedPhotosTip());
    }

    @Test
    public void testCaseEditAlbum() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot(new String(login), new String(password)));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.chooseAlbum();
        fotoMainPage.clickEditButton();
        String newName = "Grisha2";
        fotoMainPage.changeAlbumName(newName);
        fotoMainPage.saveChange();
        fotoMainPage.implicitWaitInSeconds(3);
        Assert.assertEquals(newName, fotoMainPage.getAlbumName());
    }

    @Test
    public void testCaseDeleteAlbum() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot(new String(login), new String(password)));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.chooseAlbum();
        fotoMainPage.clickEditButton();
        fotoMainPage.clickDeleteAlbum();
    }

    @Test
    public void testCaseAddCoolToPhoto() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot(new String(login), new String(password)));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.clickToPhotoStream();
        fotoMainPage.clickCoolButton();
        Assert.assertNotEquals("0",fotoMainPage.getCoolCount());
    }

}

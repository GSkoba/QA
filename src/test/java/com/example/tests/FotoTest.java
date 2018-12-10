package com.example.tests;

import com.example.core.FotoMainPage;
import com.example.core.LoginMainPage;
import com.example.core.TestBase;
import com.example.core.UserMainPageHelper;
import com.example.model.TestBot;
import org.junit.Test;


public class FotoTest extends TestBase {

    @Test
    public void testCaseCreateAlbum() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("", ""));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.clickCreateAlbum();
        fotoMainPage.inputDiscForAlbum("spring");
        fotoMainPage.clickSaveAlbumButten();
    }

    @Test
    public void testCaseUploudForoToAlbum() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("", ""));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.chooseAlbum("Grisha");
        fotoMainPage.uploadFoto("/Users/grigory.skobelev/Documents/work/photoshop/dogMoon.jpg");
    }

    @Test
    public void testCaseEditAlbum() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("", ""));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.chooseAlbum("Grisha");
        fotoMainPage.clickEditButton();
        fotoMainPage.changeAlbumName("Grisha2");
        fotoMainPage.saveChange();
    }

}

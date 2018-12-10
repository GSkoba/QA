package com.example.tests;

import com.example.core.FotoMainPage;
import com.example.core.LoginMainPage;
import com.example.core.TestBase;
import com.example.core.UserMainPageHelper;
import com.example.model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


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
    public void testCaseUploadPhotoToAlbum() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("89650671822", "Rlolq71j"));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.chooseAlbum("Grisha");
        //fotoMainPage.uploadFoto("/Users/grigory.skobelev/Documents/work/photoshop/dogMoon.jpg");
        fotoMainPage.uploadPhoto("/Users/a.perelygina/Desktop/Polytech map.png");
        //Ожидание
        //Thread.sleep(2000);
        fotoMainPage.implicitWaitInSeconds(3);

        Assert.assertEquals("Загружено", fotoMainPage.getTextOfUploadedPhotosTip());
    }

    @Test
    public void testCaseEditAlbum() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("89650671822", "Rlolq71j"));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.chooseAlbum("Grisha");
        fotoMainPage.clickEditButton();
        Thread.sleep(3000);
        fotoMainPage.changeAlbumName("Grisha2");
        fotoMainPage.saveChange();
    }

}

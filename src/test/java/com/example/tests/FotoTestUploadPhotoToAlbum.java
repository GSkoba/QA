package com.example.tests;

import com.example.core.page.AlbumPage;
import com.example.core.page.FotoMainPage;
import com.example.core.page.LoginMainPage;
import com.example.core.TestBase;
import com.example.core.page.UserMainPageHelper;
import com.example.model.Bot;
import com.example.model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class FotoTestUploadPhotoToAlbum extends TestBase {

    private final static String albumName = "Grisha";

    @Test
    public void testCaseUploadPhotoToAlbum() throws Exception {
        UserMainPageHelper userMainPageHelper = new LoginMainPage(driver).doLogin(new TestBot(new String(Bot.login), new String(Bot.password)));
        FotoMainPage fotoMainPage = userMainPageHelper.clickFotoOnToolBar();
        AlbumPage albumPage = fotoMainPage.chooseAlbum();
        albumPage.uploadPhoto("/Users/grigory.skobelev/Documents/work/photoshop/dogMoon.jpg");
        Assert.assertEquals("Загружено1", fotoMainPage.getTextOfUploadedPhotosTip());
    }
}

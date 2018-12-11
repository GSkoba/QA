package com.example.tests;

import com.example.core.FotoMainPage;
import com.example.core.LoginMainPage;
import com.example.core.TestBase;
import com.example.core.UserMainPageHelper;
import com.example.model.Bot;
import com.example.model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class FotoTestFirst extends TestBase {

    @Test
    public void testCaseCreateAlbum() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot(new String(Bot.login), new String(Bot.password)));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.clickCreateAlbum();
        String albumName = "Grisha";
        fotoMainPage.inputDiscForAlbum(albumName);
        fotoMainPage.clickSaveAlbumButton();
        Assert.assertEquals(albumName,fotoMainPage.getAlbumName());
    }
}

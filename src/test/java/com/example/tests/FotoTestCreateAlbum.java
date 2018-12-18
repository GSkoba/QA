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

public class FotoTestCreateAlbum extends TestBase {

    @Test
    public void testCaseCreateAlbum() throws Exception {
        UserMainPageHelper userMainPageHelper = new LoginMainPage(driver).doLogin(new TestBot(new String(Bot.login), new String(Bot.password)));
        userMainPageHelper.clickFotoOnToolBar();
        FotoMainPage fotoMainPage = userMainPageHelper.clickFotoOnToolBar();
        fotoMainPage.clickCreateAlbum();
        String albumName = "spring";
        fotoMainPage.inputDiscForAlbum(albumName);
        AlbumPage albumPage = fotoMainPage.clickSaveAlbumButton();
        Assert.assertEquals(albumName, albumPage.getAlbumName());
    }
}

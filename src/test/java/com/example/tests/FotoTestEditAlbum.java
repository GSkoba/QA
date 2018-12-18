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

public class FotoTestEditAlbum extends TestBase {

    @Test
    public void testCaseEditAlbum() throws Exception {
        UserMainPageHelper userMainPageHelper = new LoginMainPage(driver).doLogin(new TestBot(new String(Bot.login), new String(Bot.password)));
        FotoMainPage fotoMainPage = userMainPageHelper.clickFotoOnToolBar();
        AlbumPage albumPage = fotoMainPage.chooseAlbum();
        albumPage.clickEditButton();
        String newName = "springNew";
        albumPage.changeAlbumName(newName);
        albumPage.saveChange();
        albumPage.implicitWaitInSeconds(3);
        Assert.assertEquals(newName, albumPage.getAlbumName());
    }

}

package com.example.tests;

import com.example.core.FotoMainPage;
import com.example.core.LoginMainPage;
import com.example.core.TestBase;
import com.example.core.UserMainPageHelper;
import com.example.model.Bot;
import com.example.model.TestBot;
import org.junit.Test;

public class FotoTestFourth extends TestBase {

    @Test
    public void testCaseDeleteAlbum() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot(new String(Bot.login), new String(Bot.password)));
        new UserMainPageHelper(driver).clickFotoOnToolBar();
        FotoMainPage fotoMainPage = new FotoMainPage(driver);
        fotoMainPage.chooseAlbum();
        fotoMainPage.clickEditButton();
        fotoMainPage.clickDeleteAlbum();
    }

}

package com.example.tests;

import com.example.core.page.FotoMainPage;
import com.example.core.page.LoginMainPage;
import com.example.core.TestBase;
import com.example.core.page.PhotoPage;
import com.example.core.page.UserMainPageHelper;
import com.example.model.Bot;
import com.example.model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class FotoTestAddCoolToPhoto extends TestBase {

    @Test
    public void testCaseAddCoolToPhoto() throws Exception{
        UserMainPageHelper userMainPageHelper = new LoginMainPage(driver).doLogin(new TestBot(new String(Bot.login), new String(Bot.password)));
        FotoMainPage fotoMainPage = userMainPageHelper.clickFotoOnToolBar();
        fotoMainPage.clickToPhotoStream();
        PhotoPage photoPage = fotoMainPage.clickToPhotoStream();
        photoPage.clickCoolButton();
        Assert.assertNotEquals("0",photoPage.getCoolCount());
    }
}

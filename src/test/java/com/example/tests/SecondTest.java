package com.example.tests;

import com.example.core.GroupMainPage;
import com.example.core.LoginMainPage;
import com.example.core.TestBase;
import com.example.core.UserMainPageHelper;
import com.example.model.TestBot;
import org.junit.*;

public class SecondTest extends TestBase {

    @Test
    public void testCaseWithGroup() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("89650671822","Rlolq71j"));
        new UserMainPageHelper(driver).clickGroupsOnToolbar();
        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();
        groupMainPage.typeGroupName("Group");
        groupMainPage.clickCreateButton();
    }

}

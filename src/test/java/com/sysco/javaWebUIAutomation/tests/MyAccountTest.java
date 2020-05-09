package com.sysco.javaWebUIAutomation.tests;

import com.sysco.javaWebUIAutomation.function.Login;
import com.sysco.javaWebUIAutomation.function.MyAccount;
import com.sysco.javaWebUIAutomation.function.TheAthletesFootHome;
import com.sysco.javaWebUIAutomation.util.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class MyAccountTest extends TestBase {

    @Test
    public void VerifyMyAccountUserNameAfterLoginFromRegisteredUser(){
        SoftAssert softAssert = new SoftAssert();
        TheAthletesFootHome.loadHomePage();
        TheAthletesFootHome.clickLoginButton();
        Login.loginWithRegisteredUserCredentials();
        softAssert.assertTrue(MyAccount.isMyAccountPageTitleDisplayed(),"MY ACCOUNT PAGE TITLE IS NOT DISPLAYED");
        softAssert.assertTrue(MyAccount.isUserNameDisplayedInMyAccount(),"USER NAME IS NOT DISPLAYED IN THE MY ACCOUNT PAGE");
        softAssert.assertAll();

    }





}

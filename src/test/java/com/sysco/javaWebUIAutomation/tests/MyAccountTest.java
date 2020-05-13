package com.sysco.javaWebUIAutomation.tests;

import com.sysco.javaWebUIAutomation.data.LoginData;
import com.sysco.javaWebUIAutomation.function.Login;
import com.sysco.javaWebUIAutomation.function.MyAccount;
import com.sysco.javaWebUIAutomation.function.TheAthletesFootHome;
import com.sysco.javaWebUIAutomation.util.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class MyAccountTest extends TestBase {
    static LoginData loginData = new LoginData();

    @BeforeClass
    public void initClass(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "MyAccount - MyAccount");
        TheAthletesFootHome.loadHomePage();
        TheAthletesFootHome.clickLoginButton();
    }

    @Test
    public void VerifyMyAccountUserNameAfterLoginFromRegisteredUser(){
        SoftAssert softAssert = new SoftAssert();
        Login.loginWithRegisteredUserCredentials(loginData);
        softAssert.assertTrue(MyAccount.isMyAccountPageTitleDisplayed(),"MY ACCOUNT PAGE TITLE IS NOT DISPLAYED");
        softAssert.assertTrue(MyAccount.isUserNameDisplayedInMyAccount(),"USER NAME IS NOT DISPLAYED IN THE MY ACCOUNT PAGE");
        softAssert.assertAll();

    }





}

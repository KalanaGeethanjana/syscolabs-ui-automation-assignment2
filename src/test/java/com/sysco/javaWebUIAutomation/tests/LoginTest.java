package com.sysco.javaWebUIAutomation.tests;

import com.sysco.javaWebUIAutomation.common.Constants;
import com.sysco.javaWebUIAutomation.data.LoginData;
import com.sysco.javaWebUIAutomation.function.Login;
import com.sysco.javaWebUIAutomation.function.TheAthletesFootHome;
import com.sysco.javaWebUIAutomation.util.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {
    static LoginData loginData = new LoginData();

    @BeforeClass
    public void initClass(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - Login");
        TheAthletesFootHome.loadHomePage();
        TheAthletesFootHome.clickLoginButton();

    }

    @Test(description = "Verify login page")
    public void VerifyLoginPageContents(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Login.isLoginOrCreateMyFitRewardsAccountHeaderAvailable(),"THE LOGIN OR CREATE MY FIT REWARDS ACCOUNT HEADER IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isLoginToMyFitRewardsHeaderAvailable(),"THE LOGIN TO MY FIT REWARDS HEADER IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isEmailTextboxAvailable(),"THE EMAIL TEXTBOX IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isPasswordTextboxAvailable(),"THE PASSWORD TEXTBOX IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isFotgotPasswordLinkAvailable(),"THE FORGOT PASSWORD LINK IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isLoginButtonAvailable(),"THE LOGIN BUTTON IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isJoinMyFitRewardsHeaderAvailable(),"THE JOIN MY FIT REWARDS HEADER IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isCreateMyFitRewardsAccountButtonAvailable(),"THE CREATE A MYFIT REWARDS ACCOUNT BUTTON IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isRegisterOrLoginSociallyHeaderAvailable(),"THE REGISTER OR LOGIN SOCIALLY HEADER IS NOT DISPLAYED");
        softAssert.assertTrue(Login.isConnectWithFacebookAvailable(),"THE CONNECT WITH FACEBOOK BUTTON IS NOT DISPLAYED");
        softAssert.assertAll();;
    }

    @Test(description = "Verify without entering email and password", dependsOnMethods = "VerifyLoginPageContents")
    public void VerifyErrorMessagesWhenClickingLoginWithoutEmailAndPassword(){
        SoftAssert softAssert = new SoftAssert();
        Login.clickLoginButton();
        String[] errorMessages_login = Login.getLoginErrorMessagesWhenEmailAndPasswordIsNotEntered();
        softAssert.assertEquals(errorMessages_login[0], Constants.ERRORMESSAGE_EMAIL_IS_REQUIRED);
        softAssert.assertEquals(errorMessages_login[1], Constants.ERRORMESSAGE_PASSWORD_IS_REQUIRED);
        softAssert.assertAll();
    }


    @Test(description = "Verify entering invalid email", dependsOnMethods = "VerifyErrorMessagesWhenClickingLoginWithoutEmailAndPassword")
    public void VerifyErrorMessageWhenEnteringInvalidEmail(){
        SoftAssert softAssert = new SoftAssert();
        Login.loginWithInvalidEmail(loginData);
        softAssert.assertEquals(Login.getInvalidEmailErrorMessage(),Constants.ERRORMESSAGE_INVALID_EMAIL);
        softAssert.assertAll();

    }

    @Test(description = "Verify entering unregistered user credentials", dependsOnMethods ="VerifyErrorMessageWhenEnteringInvalidEmail")
    public void VerifyErrorMessageWhenEnteringCredentialsOfUnregisteredUser(){
        SoftAssert softAssert = new SoftAssert();
        Login.loginWithUnregisteredUserCredentials(loginData);
        softAssert.assertEquals(Login.getUnregisteredUserErrorMessage(),Constants.ERRORMESSAGE_UNREGISTERED_USER);
        softAssert.assertAll();

    }






}

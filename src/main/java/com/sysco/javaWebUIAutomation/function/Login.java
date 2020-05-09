package com.sysco.javaWebUIAutomation.function;

import com.sysco.javaWebUIAutomation.data.LoginData;
import com.sysco.javaWebUIAutomation.page.LoginPage;

public class Login  {
    private static LoginPage loginPage = new LoginPage();


    public static boolean isLoginOrCreateMyFitRewardsAccountHeaderAvailable(){
        return loginPage.isLoginOrCreateMyFitRewardsAccountHeaderAvailable();
    }

    public static boolean isLoginToMyFitRewardsHeaderAvailable(){
        return loginPage.isLoginToMyFitRewardsHeaderAvailable();
    }

    public static boolean isEmailTextboxAvailable(){
        return loginPage.isEmailTextboxAvailable();
    }

    public static boolean isPasswordTextboxAvailable(){
        return loginPage.isPasswordTextboxAvailable();
    }

    public static boolean isFotgotPasswordLinkAvailable(){
        return loginPage.isFotgotPasswordLinkAvailable();
    }

    public static boolean isLoginButtonAvailable(){
        return loginPage.isLoginButtonAvailable();
    }

    public static boolean isJoinMyFitRewardsHeaderAvailable(){
        return loginPage.isJoinMyFitRewardsHeaderAvailable();
    }

    public static boolean isCreateMyFitRewardsAccountButtonAvailable(){
        return loginPage.isCreateMyFitRewardsAccountButtonAvailable();
    }

    public static boolean isRegisterOrLoginSociallyHeaderAvailable(){
        return loginPage.isRegisterOrLoginSociallyHeaderAvailable();
    }

    public static boolean isConnectWithFacebookAvailable(){
        return loginPage.isConnectWithFacebookAvailable();
    }

    public static void clickLoginButton(){
        loginPage.clickLoginButton();
    }

    public static String[] getLoginErrorMessagesWhenEmailAndPasswordIsNotEntered(){
        String [] errorMessages = loginPage.getErrorMessagesForEmptyLoginDetails();
        return errorMessages;
    }

    public static void loginWithInvalidEmail(){
        loginPage.clickLoginButtonWithInvalidEmail();
    }

    public static String getInvalidEmailErrorMessage(){
        String errorMessages = loginPage.getInvalidEmailErrorMessage();
        return errorMessages;
    }

    public static void loginWithUnregisteredUserCredentials(){
        loginPage.clickLoginButtonWithUnregisteredEmailAndPassword();
    }

    public static String getUnregisteredUserErrorMessage(){
        String errorMessages = loginPage.getUnregisteredUserErrorMessage();
        return errorMessages;
    }

    public static void loginWithRegisteredUserCredentials(){
        loginPage.clickLoginButtonWithRegisteredEmailAndPassword();
    }



    public static void quitDriver(){
        loginPage.quitDriver();;
    }
}

package com.sysco.javaWebUIAutomation.function;

import com.sysco.javaWebUIAutomation.page.MyAccountPage;

public class MyAccount {

    public static MyAccountPage myAccountPage = new MyAccountPage();

    public static boolean isUserNameDisplayedInMyAccount(){
        return myAccountPage.isUserNameDisplayedInMyAccount();
    }

    public static boolean isMyAccountPageTitleDisplayed(){
        return myAccountPage.isMyAccountPageTitleDisplayed();
    }

    public static void clickCartButtonValue(){
        myAccountPage.clickCartButtonValue();
    }

    public static void clickCartButton(){
        myAccountPage.clickCartButtonValue();
    }

}

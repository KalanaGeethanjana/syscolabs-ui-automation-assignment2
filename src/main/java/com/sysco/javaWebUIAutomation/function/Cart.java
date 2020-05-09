package com.sysco.javaWebUIAutomation.function;

import com.sysco.javaWebUIAutomation.page.CartPage;

public class Cart {
    public static CartPage cartPage = new CartPage();



    public static void clickRemoveButtonInCart(){
        cartPage.clickRemoveButtonInCart();
    }

    public static void clickCloseButtonInCart(){
        cartPage.clickCloseButtonInCart();
    }

    public static boolean isConfirmDeleteItemMessageDisplayed(){
        return cartPage.isConfirmDeleteItemMessageDisplayed();
    }

    public static void clickOkButtonInConfirmItemDeleteFromCart(){
        cartPage.clickOkButtonInConfirmItemDeleteFromCart();
    }

    public static boolean isNameofFirstItemDisplayed(){
        return cartPage.isNameofFirstItemDisplayed();
    }

    public static boolean isSubTotalOfFirstItemDisplayed(){
        return cartPage.isSubTotalOfFirstItemDisplayed();
    }

    public static void clickProceedToCheckoutButtonInCart(){
        cartPage.clickProceedToCheckoutButtonInCart();
    }
}

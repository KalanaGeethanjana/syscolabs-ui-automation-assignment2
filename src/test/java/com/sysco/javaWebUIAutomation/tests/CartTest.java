package com.sysco.javaWebUIAutomation.tests;

import com.sysco.javaWebUIAutomation.function.*;
import com.sysco.javaWebUIAutomation.util.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import temp.RowFix;

public class CartTest extends TestBase {
    @Test
    public void VerifyItemsInCartAreRemovedIfPresent(){
        SoftAssert softAssert = new SoftAssert();
        TheAthletesFootHome.loadHomePage();
        TheAthletesFootHome.clickLoginButton();
        Login.loginWithRegisteredUserCredentials();
        MyAccount.clickCartButtonValue();
        Cart.clickRemoveButtonInCart();
        softAssert.assertTrue(Cart.isConfirmDeleteItemMessageDisplayed(),"CONFIRM DELETE ITEM MESSAGE IS NOT DISPLAYED");
        Cart.clickOkButtonInConfirmItemDeleteFromCart();
        Cart.clickCloseButtonInCart();
        softAssert.assertTrue(MyAccount.isMyAccountPageTitleDisplayed(),"MY ACCOUNT PAGE TITLE IS NOT DISPLAYED");
        softAssert.assertTrue(MyAccount.isUserNameDisplayedInMyAccount(),"USER NAME IS NOT DISPLAYED IN THE MY ACCOUNT PAGE");
        softAssert.assertAll();


    }


    @Test
    public void VerifyPriceAndNameInCartAfterAddingAnItem(){
        SoftAssert softAssert = new SoftAssert();
        TheAthletesFootHome.loadHomePage();
        TheAthletesFootHome.clickLoginButton();
        Login.loginWithRegisteredUserCredentials();
        AddItem.clickMensLabel();
        AddItem.clickRunCategory();
        AddItem.clickFirstShoeInList();
        AddItem.clickShoeSizeNine();
        AddItem.clickAddToCartButton();
        softAssert.assertTrue(AddItem.isSuccessMessageDisplayedAfterAddingFirstItem(), "SUCCESS MESSAGE IS NOT DISPLAYED AFTER ADDING AN ITEM TO THE CART");
        MyAccount.clickCartButton();
        softAssert.assertTrue(Cart.isNameofFirstItemDisplayed(),"NAME OF THE ADDED ITEM IS NOT DISPLAYED");
        softAssert.assertTrue(Cart.isSubTotalOfFirstItemDisplayed(),"SUBTOTAL OF THE ADDED ITEM IS NOT DISPLAYED");
        softAssert.assertAll();

    }



}

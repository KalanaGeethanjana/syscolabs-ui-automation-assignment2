package com.sysco.javaWebUIAutomation.tests;

import com.sysco.javaWebUIAutomation.data.LoginData;
import com.sysco.javaWebUIAutomation.function.*;
import com.sysco.javaWebUIAutomation.util.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import temp.RowFix;



public class CartTest extends TestBase {

    static LoginData loginData = new LoginData();

    @BeforeClass
    public void initClass(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Cart - Cart");
        TheAthletesFootHome.loadHomePage();
        TheAthletesFootHome.clickLoginButton();
    }




    @Test(description = "Remove Item If Present")
    public void VerifyItemsInCartAreRemovedIfPresent(){
        SoftAssert softAssert = new SoftAssert();
        Login.loginWithRegisteredUserCredentials(loginData);
        MyAccount.clickCartButtonValue();
        Cart.clickRemoveButtonInCart();
        softAssert.assertTrue(Cart.isConfirmDeleteItemMessageDisplayed(),"CONFIRM DELETE ITEM MESSAGE IS NOT DISPLAYED");
        Cart.clickOkButtonInConfirmItemDeleteFromCart();
        Cart.clickCloseButtonInCart();
        softAssert.assertTrue(MyAccount.isMyAccountPageTitleDisplayed(),"MY ACCOUNT PAGE TITLE IS NOT DISPLAYED");
        softAssert.assertTrue(MyAccount.isUserNameDisplayedInMyAccount(),"USER NAME IS NOT DISPLAYED IN THE MY ACCOUNT PAGE");
        softAssert.assertAll();


    }


    @Test(description = "Verify the price and item in cart after adding a item", dependsOnMethods = "VerifyItemsInCartAreRemovedIfPresent")
    public void VerifyPriceAndNameInCartAfterAddingAnItem(){
        SoftAssert softAssert = new SoftAssert();
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

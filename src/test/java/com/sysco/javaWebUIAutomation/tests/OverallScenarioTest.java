package com.sysco.javaWebUIAutomation.tests;

import com.sysco.javaWebUIAutomation.data.CheckOutData;
import com.sysco.javaWebUIAutomation.data.LoginData;
import com.sysco.javaWebUIAutomation.function.*;
import com.sysco.javaWebUIAutomation.util.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OverallScenarioTest extends TestBase {

    static LoginData loginData = new LoginData();
    static CheckOutData checkOutData = new CheckOutData();

    @BeforeClass
    public void initClass(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Cart - Cart");
        TheAthletesFootHome.loadHomePage();
        TheAthletesFootHome.clickLoginButton();
    }

    @Test(description = "Full Scenario")
    public void VerifyTheFullScenario(){
        SoftAssert softAssert = new SoftAssert();
        Login.loginWithRegisteredUserCredentials(loginData);
        AddItem.clickMensLabel();
        AddItem.clickRunCategory();
        AddItem.clickFirstShoeInList();
        AddItem.clickShoeSizeNine();
        AddItem.clickAddToCartButton();
        softAssert.assertTrue(AddItem.isSuccessMessageDisplayedAfterAddingFirstItem(), "SUCCESS MESSAGE IS NOT DISPLAYED AFTER ADDING AN ITEM TO THE CART");
        MyAccount.clickCartButton();
        softAssert.assertTrue(Cart.isNameofFirstItemDisplayed(),"NAME OF THE ADDED ITEM IS NOT DISPLAYED");
        softAssert.assertTrue(Cart.isSubTotalOfFirstItemDisplayed(),"SUBTOTAL OF THE ADDED ITEM IS NOT DISPLAYED");
        Cart.clickProceedToCheckoutButtonInCart();
        CheckOut.setDataforCheckOutPageRequiredFields(checkOutData);
        CheckOut.clickContinueButton();
        softAssert.assertTrue(CheckOut.isPaymentInformationHeaderAvailable(),"PAYMENT INFORMATION HEADER IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isPayPalOptionAvailable(),"PAYPAL PAYMENT OPTION IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isCreditCardOptionAvailable(),"CREDICT CARD OPTION IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isPayOverTimeOptionAvailable(),"PAY OVER TIME OPTION IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isGrandTotalLabelAvailable(),"GRAND TOTAL LABEL IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isDisabledPlaceOrderButtoneAvailable(),"DISABLED PLACE ORDER BUTTON IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertAll();
        softAssert.assertAll();

    }
}

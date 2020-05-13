package com.sysco.javaWebUIAutomation.tests;

import com.sysco.javaWebUIAutomation.common.Constants;
import com.sysco.javaWebUIAutomation.data.CheckOutData;
import com.sysco.javaWebUIAutomation.data.LoginData;
import com.sysco.javaWebUIAutomation.function.*;
import com.sysco.javaWebUIAutomation.util.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckOutTest extends TestBase {

    static LoginData loginData = new LoginData();
    static CheckOutData checkOutData = new CheckOutData();

    @BeforeClass
    public void initClass(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "CheckOut - CheckOut");
        TheAthletesFootHome.loadHomePage();
        TheAthletesFootHome.clickLoginButton();

    }

    @Test(description = "To verify the first name and last name in check out page")
    public void VerifyFirstAndLastNameInCheckOutPage(){
        SoftAssert softAssert = new SoftAssert();
        Login.loginWithRegisteredUserCredentials(loginData);
        AddItem.clickMensLabel();
        AddItem.clickRunCategory();
        AddItem.clickFirstShoeInList();
        AddItem.clickShoeSizeNine();
        AddItem.clickAddToCartButton();
        MyAccount.clickCartButton();
        Cart.clickProceedToCheckoutButtonInCart();
        //softAssert.assertEquals(CheckOut.getFirstName(), "william");//cannot verify the text as the text in html is not present
        //softAssert.assertEquals(CheckOut.getFirstName(), "jacob");//cannot verify the text as the text in html is not present
        softAssert.assertTrue(CheckOut.isFirstNameAvailable(),"FISRT NAME TEXT BOX IS NOT AVAILABLE ");
        softAssert.assertTrue(CheckOut.isLastNameAvailable(),"LAST NAME TEXT BOX IS NOT AVAILABLE");
        softAssert.assertAll();
    }

    @Test(description = "Verify the Mandotory error messages" , dependsOnMethods = "VerifyFirstAndLastNameInCheckOutPage")
    public  void VerifyClickingTheContinueButtonWithoutEnteringMandatoryData(){
        SoftAssert softAssert = new SoftAssert();
//        TheAthletesFootHome.loadHomePage();
//        TheAthletesFootHome.clickLoginButton();
//        Login.loginWithRegisteredUserCredentials(loginData);
//        AddItem.clickMensLabel();
//        AddItem.clickRunCategory();
//        AddItem.clickFirstShoeInList();
//        AddItem.clickShoeSizeNine();
//        AddItem.clickAddToCartButton();
//        MyAccount.clickCartButton();
//        Cart.clickProceedToCheckoutButtonInCart();
        CheckOut.clickContinueButton();
        String[] errorMessages_checkout = CheckOut.getErrorMessagesForEmptyDetailsInCheckOutPage();
        softAssert.assertEquals(errorMessages_checkout[0], Constants.ERRORMESSAGE_ADDRESS_IS_REQUIRED);
        softAssert.assertEquals(errorMessages_checkout[1], Constants.ERRORMESSAGE_SUBURB_IS_REQUIRED);
        softAssert.assertEquals(errorMessages_checkout[2], Constants.ERRORMESSAGE_STATE_PROVINCE_IS_REQUIRED);
        softAssert.assertEquals(errorMessages_checkout[3], Constants.ERRORMESSAGE_POSTAL_CODE_IS_REQUIRED);
        softAssert.assertEquals(errorMessages_checkout[4], Constants.ERRORMESSAGE_PHONE_NUMBER_IS_REQUIRED);
        CheckOut.getErrorMessagesForEmptyDetailsInCheckOutPage();
        softAssert.assertAll();
    }


    @Test(description = "Verify the payment details after entering valid checkout details", dependsOnMethods = "VerifyClickingTheContinueButtonWithoutEnteringMandatoryData")
    public void VerifyPaymentDetailsSectionAfterEnteringValidCheckOutDetails(){
        SoftAssert softAssert = new SoftAssert();
//        TheAthletesFootHome.loadHomePage();
//        TheAthletesFootHome.clickLoginButton();
//        Login.loginWithRegisteredUserCredentials(loginData);
//        AddItem.clickMensLabel();
//        AddItem.clickRunCategory();
//        AddItem.clickFirstShoeInList();
//        AddItem.clickShoeSizeNine();
//        AddItem.clickAddToCartButton();
//        MyAccount.clickCartButton();
//        Cart.clickProceedToCheckoutButtonInCart();
        CheckOut.setDataforCheckOutPageRequiredFields(checkOutData);
        CheckOut.clickContinueButton();
        softAssert.assertTrue(CheckOut.isPaymentInformationHeaderAvailable(),"PAYMENT INFORMATION HEADER IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isPayPalOptionAvailable(),"PAYPAL PAYMENT OPTION IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isCreditCardOptionAvailable(),"CREDICT CARD OPTION IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isPayOverTimeOptionAvailable(),"PAY OVER TIME OPTION IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isGrandTotalLabelAvailable(),"GRAND TOTAL LABEL IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertTrue(CheckOut.isDisabledPlaceOrderButtoneAvailable(),"DISABLED PLACE ORDER BUTTON IS NOT PRESENT IN THE PAYMENT CONFIRMATION PAGE");
        softAssert.assertAll();


    }
}

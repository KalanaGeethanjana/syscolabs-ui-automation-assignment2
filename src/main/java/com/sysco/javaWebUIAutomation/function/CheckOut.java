package com.sysco.javaWebUIAutomation.function;

import com.sysco.javaWebUIAutomation.page.CheckOutPage;

public class CheckOut {
    public static CheckOutPage checkOutPage = new CheckOutPage();


    public static String getFirstName(){
    return checkOutPage.getFirstName();
}

    public static String getLastName(){
        return checkOutPage.getLastName();
    }

    public static boolean isFirstNameAvailable(){
        return checkOutPage.isFirstNameAvailable();
    }

    public static boolean isLastNameAvailable(){
        return checkOutPage.isLastNameAvailable();
    }

    public static void  clickContinueButton(){
         checkOutPage.clickContinueButton();
    }

    public static String[] getErrorMessagesForEmptyDetailsInCheckOutPage() {
        String[] errorMessages = checkOutPage.getErrorMessagesForEmptyDetailsInCheckOutPage();
        return errorMessages;
    }

    public static void setDataforCheckOutPageRequiredFields(){
        checkOutPage.setDataforCheckOutPageRequiredFields();
    }

    public static boolean isPaymentInformationHeaderAvailable(){
        return checkOutPage.isPaymentInformationHeaderAvailable();
    }

    public static boolean isPayPalOptionAvailable(){
        return checkOutPage.isPayPalOptionAvailable();
    }

    public static boolean isCreditCardOptionAvailable(){
        return checkOutPage.isCreditCardOptionAvailable();
    }

    public static boolean isPayOverTimeOptionAvailable(){
        return checkOutPage.isPayOverTimeOptionAvailable();
    }

    public static boolean isGrandTotalLabelAvailable(){
        return checkOutPage.isGrandTotalLabelAvailable();
    }

    public static boolean isDisabledPlaceOrderButtoneAvailable(){
        return checkOutPage.isDisabledPlaceOrderButtoneAvailable();
    }

    }

package com.sysco.javaWebUIAutomation.function;

import com.sysco.javaWebUIAutomation.page.AddItemPage;

public class AddItem {
    public static AddItemPage addItemPage = new AddItemPage();

    public static void clickMensLabel(){
        addItemPage.clickMensLabel();
    }

    public static void clickRunCategory(){
        addItemPage.clickRunCategory();
    }

    public static void clickFirstShoeInList(){
        addItemPage.clickFirstShoeInList();
    }

    public static void clickShoeSizeNine(){
        addItemPage.clickShoeSizeNine();
    }

    public static void clickAddToCartButton(){
        addItemPage.clickAddToCartButton();
    }

    public static boolean isSuccessMessageDisplayedAfterAddingFirstItem(){
        return addItemPage.isSuccessMessageDisplayedAfterAddingFirstItem();
    }


}

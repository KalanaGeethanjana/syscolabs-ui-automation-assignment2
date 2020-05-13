package com.sysco.javaWebUIAutomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class AddItemPage extends TheAthletesFootHomePage {

    private By lnkMen =By.xpath("//*[@id='mi-1-2']");
    //private By lnkRun =By.xpath("//*[@id='mi-3-2-3-1']");
    private By lnkRun =By.xpath("//*[@id='mi-3-2-3-1' and @title='Run']");
    //private By lnkFirstShoe = By.xpath("//a[@class='product-item-link' and @title='BROOKS ADRENALINE GTS 20 MENS NAVY BLUE SILVER']");
    private By lnkFirstShoe = By.xpath("//a[@class='product-item-link'][1]");
    private By lblShoeSize9 = By.xpath("//div[@option-id='286' and @option-label='9']");
    private By btnAddToCart = By.xpath("//button[@title='Add to Cart']");
    private By successMessageForAddingFirstItem = By.xpath("//div[text()='You added BROOKS ADRENALINE GTS 20 MENS NAVY BLUE SILVER to your shopping cart.']");

    public void clickMensLabel(){
        syscoLabUI.waitTillElementLoaded(lnkMen);
        syscoLabUI.click(lnkMen);
    }

    public void clickRunCategory(){
        //JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        //executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//a[@class='product-item-link'][1]")));
        syscoLabUI.waitTillElementLoaded(lnkRun);
        syscoLabUI.click(lnkRun);
    }

    public void clickFirstShoeInList(){
        syscoLabUI.sleep(5);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//a[@class='product-item-link'][1]")));
        //syscoLabUI.waitTillElementLoaded(lnkFirstShoe);
        //syscoLabUI.click(lnkFirstShoe);
    }

    public void clickShoeSizeNine(){
        syscoLabUI.waitTillElementLoaded(lblShoeSize9);
        syscoLabUI.click(lblShoeSize9);
    }

    public void clickAddToCartButton(){
        syscoLabUI.waitTillElementLoaded(btnAddToCart);
        syscoLabUI.click(btnAddToCart);
    }

    public boolean isSuccessMessageDisplayedAfterAddingFirstItem(){
        syscoLabUI.waitTillElementLoaded(successMessageForAddingFirstItem);
        return syscoLabUI.isDisplayed(successMessageForAddingFirstItem);
    }

}

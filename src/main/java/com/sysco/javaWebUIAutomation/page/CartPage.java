package com.sysco.javaWebUIAutomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CartPage extends TheAthletesFootHomePage {
    private By btnRemoveFromCart = By.xpath("//a[@class='action delete']");
    //private By btnRemoveFromCart = By.cssSelector("a.action.delete");
    private By btnCloseCart = By.xpath("//*[@class='close']");
    private By confirmDeleteMessage = By.xpath("//div[text()='Are you sure you would like to remove this item from the shopping cart?']");
    private By btnOKinConfirmItemDeleteMessage = By.xpath("//span[text()='OK']");
    private By firstItemNameInCart = By.xpath("//a[text()='BROOKS ADRENALINE GTS 20 MENS NAVY BLUE SILVER']");
    private By firstItemSubtotalInCart = By.xpath("//span[@data-bind='html: cart().subtotal_incl_tax']");
    private By btnProceedToCheckout = By.xpath("//button[@title='Proceed To Checkout']");

    public boolean isElementPresent(By by) {
        try {
            syscoLabUI.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickRemoveButtonInCart(){
        if(isElementPresent(btnRemoveFromCart)){
            JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
            executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//a[@class='action delete']")));
            syscoLabUI.sleep(5);
        }

    }

    public void clickCloseButtonInCart(){
        syscoLabUI.waitTillElementLoaded(btnCloseCart);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//*[@class='close']")));
        syscoLabUI.sleep(5);
    }

    public boolean isConfirmDeleteItemMessageDisplayed(){
        return syscoLabUI.isDisplayed(confirmDeleteMessage) ;
    }

    public void clickOkButtonInConfirmItemDeleteFromCart(){
        syscoLabUI.waitTillElementLoaded(btnOKinConfirmItemDeleteMessage);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//span[text()='OK']")));
        syscoLabUI.sleep(3);
    }

     public boolean isNameofFirstItemDisplayed(){
        syscoLabUI.waitTillElementLoaded(firstItemNameInCart);
         JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
         executor.executeScript("arguments[0].text;", syscoLabUI.driver.findElement(By.xpath("//a[text()='BROOKS ADRENALINE GTS 20 MENS NAVY BLUE SILVER']")));
        return syscoLabUI.isDisplayed(firstItemNameInCart);
     }

     public boolean isSubTotalOfFirstItemDisplayed(){
        syscoLabUI.waitTillElementLoaded(firstItemSubtotalInCart);
         JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
         executor.executeScript("arguments[0].text;", syscoLabUI.driver.findElement(By.xpath("//span[@data-bind='html: cart().subtotal_incl_tax']")));
        return syscoLabUI.isDisplayed(firstItemSubtotalInCart);
     }
     public void clickProceedToCheckoutButtonInCart(){
        syscoLabUI.waitTillElementLoaded(btnProceedToCheckout);
        syscoLabUI.click(btnProceedToCheckout);
     }


//    public void clickRemoveButtonInCart() {
//        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
//        executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//a[@class='action delete']")));
//        syscoLabUI.sleep(5);
    //syscoLabUI.waitTillElementLoaded(btnRemoveFromCart);
    //WebElement element = syscoLabUI.driver.findElement(By.xpath("//a[@class='action delete']"));
    //syscoLabUI.sleep(5);
    // syscoLabUI.waitTillElementLoaded(btnRemoveFromCart);
    // Actions actions = new Actions(syscoLabUI.driver);
    //actions.moveToElement(element).click().perform();
    //syscoLabUI.click(btnRemoveFromCart);
    //}


//    WebElement element = driver.findElement(By("element_path"));
//
//    Actions actions = new Actions(driver);
//
//actions.moveToElement(element).click().perform();


}

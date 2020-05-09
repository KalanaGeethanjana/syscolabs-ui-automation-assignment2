package com.sysco.javaWebUIAutomation.page;


import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyAccountPage extends TheAthletesFootHomePage{


    private By lblUserName = By.xpath("//span[contains(text(),'william  jacob')]");
    private By lblMyAccount = By.xpath("//h1[@class='page-title']");
    private By btnCartValue = By.xpath("//span[@class='value']");//span[@class='showcart-trigger header-sidebar-link -cart']
    private By btnCart = By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']");

    public boolean isUserNameDisplayedInMyAccount(){
        return syscoLabUI.isDisplayed(lblUserName) ;
    }

    public boolean isMyAccountPageTitleDisplayed(){
        return syscoLabUI.isDisplayed(lblMyAccount) ;
    }

    public void clickCartButtonValue(){
        syscoLabUI.waitTillElementLoaded(btnCartValue);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//span[@class='value']")));
        //syscoLabUI.click(btnCartValue);
    }

    public void clickCartButton(){
        syscoLabUI.waitTillElementLoaded(btnCart);
        JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        executor.executeScript("arguments[0].click();", syscoLabUI.driver.findElement(By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']")));
        //syscoLabUI.click(btnCart);
    }

}

package com.sysco.javaWebUIAutomation.function;

import com.sysco.javaWebUIAutomation.page.TheAthletesFootHomePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TheAthletesFootHome {



     static TheAthletesFootHomePage theAthletesFootHomePage = new  TheAthletesFootHomePage();

    public static void loadHomePage(){
        theAthletesFootHomePage.loadAthletesFootHomePage();
    }

    public static void clickLoginButton(){
        theAthletesFootHomePage.clickLoginButton();
    }


    public static void quitDriver(){
        theAthletesFootHomePage.quitDriver();
    }



}

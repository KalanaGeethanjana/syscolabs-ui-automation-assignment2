package com.sysco.javaWebUIAutomation.page;

import com.sysco.javaWebUIAutomation.common.Constants;
import com.sysco.javaWebUIAutomation.util.DriverEnvironmentSetUpUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;

public class TheAthletesFootHomePage {
protected static SyscoLabUI syscoLabUI;

private By lnkLogin = By.xpath("//a[text()='Login']");

    public void openGoogleHomePage(){
        DriverEnvironmentSetUpUtil.setToRunLocally();
        syscoLabUI = new SyscoLabWUI(null);
        syscoLabUI.navigateTo(Constants.GOOGLE_HOMEPAGE_URL);
        syscoLabUI.driver.manage().window().maximize();
    }

    public void loadAthletesFootHomePage(){
        DriverEnvironmentSetUpUtil.setToRunLocally();
        syscoLabUI = new SyscoLabWUI(null);
        syscoLabUI.navigateTo(Constants.THE_ATHLETES_FOOT_URL);
        syscoLabUI.driver.manage().window().maximize();
    }

    public void clickLoginButton(){
        syscoLabUI.click(lnkLogin);
    }

    public void quitDriver(){
        syscoLabUI.quit();
    }

}

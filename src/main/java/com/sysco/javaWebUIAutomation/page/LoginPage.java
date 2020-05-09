package com.sysco.javaWebUIAutomation.page;

import com.sysco.javaWebUIAutomation.data.LoginData;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

public class LoginPage extends TheAthletesFootHomePage{
//protected static SyscoLabUI syscoLabUI;
    LoginData loginData = new LoginData();

    private By loginOrCreateMyFitRewardsAccountHeader = By.xpath("//span[text()='LOGIN OR CREATE A MyFIT REWARDS™ ACCOUNT']");
    private By loginToMyFitRewardsHeader = By.xpath("//strong[text()='LOGIN TO MYFIT REWARDS']");
    private By txtEmail = By.xpath("//*[@id='email']");
    private By txtPassword = By.xpath("//*[@id='pass']");
    private By lnkForgotPassword = By.xpath("//span[text()='Forgot Your Password?']");
    private By btnLogin = By.xpath("//*[@class='action login primary']");
    private By joinMyFitRewardsHeader = By.xpath("//strong[text()='Join MyFit Rewards']");
    private By btnCreateMyFitRewardsAccount = By.xpath("//span[text()='Create a MyFit Rewards']");
    private By registerOrLoginSociallyHeader = By.xpath("//h2[text()='Register or login socially']");
    private By btnConnectWithFacebook = By.xpath("//span[text()='Connect with Facebook']");
    private By errorEmailIsRequired = By.xpath("//*[@id='email-error']");
    private By errorPasswordIsRequired = By.xpath("//*[@id='pass-error']");
    private By errorInvalidEmailFormat = By.xpath("//div[text()='Please enter a valid email address (Ex: johndoe@domain.com).']");
    private By errorUnregisteredUser = By.xpath("//div[text()='You did not sign in correctly or your account is temporarily disabled.']");



    public boolean isLoginOrCreateMyFitRewardsAccountHeaderAvailable(){
        return syscoLabUI.isDisplayed(loginOrCreateMyFitRewardsAccountHeader) ;
    }

    public boolean isLoginToMyFitRewardsHeaderAvailable(){
        return syscoLabUI.isDisplayed(loginToMyFitRewardsHeader) ;
    }

    public boolean isEmailTextboxAvailable(){
        return syscoLabUI.isDisplayed(txtEmail) ;
    }

    public boolean isPasswordTextboxAvailable(){
        return syscoLabUI.isDisplayed(txtPassword) ;
    }

    public boolean isFotgotPasswordLinkAvailable(){
        return syscoLabUI.isDisplayed(lnkForgotPassword) ;
    }

    public boolean isLoginButtonAvailable(){
        return syscoLabUI.isDisplayed(btnLogin) ;
    }

    public boolean isJoinMyFitRewardsHeaderAvailable(){
        return syscoLabUI.isDisplayed(joinMyFitRewardsHeader) ;
    }

    public boolean isCreateMyFitRewardsAccountButtonAvailable(){
        return syscoLabUI.isDisplayed(btnCreateMyFitRewardsAccount) ;
    }

    public boolean isRegisterOrLoginSociallyHeaderAvailable(){
        return syscoLabUI.isDisplayed(registerOrLoginSociallyHeader) ;
    }

    public boolean isConnectWithFacebookAvailable(){
        return syscoLabUI.isDisplayed(btnConnectWithFacebook) ;
    }

    public void clickLoginButton(){
        syscoLabUI.waitTillElementLoaded(btnLogin);
        syscoLabUI.click(btnLogin);
    }

    public String[] getErrorMessagesForEmptyLoginDetails(){
        String[] errorMessages = new String[2];
        errorMessages[0] = syscoLabUI.getText(errorEmailIsRequired);
        errorMessages[1] = syscoLabUI.getText(errorPasswordIsRequired);
        return errorMessages;
    }

    public void clickLoginButtonWithInvalidEmail(){
        syscoLabUI.sendKeys(txtEmail,loginData.invalidEmail);
        syscoLabUI.waitTillElementLoaded(btnLogin);
        syscoLabUI.click(btnLogin);
    }

    public String getInvalidEmailErrorMessage(){
        String errorMessages = syscoLabUI.getText(errorInvalidEmailFormat);
        return errorMessages;
    }

    public void clickLoginButtonWithUnregisteredEmailAndPassword(){
        syscoLabUI.sendKeys(txtEmail,loginData.unregisteredEmail);
        syscoLabUI.sendKeys(txtPassword,loginData.unregisteredPassword);
        syscoLabUI.waitTillElementLoaded(btnLogin);
        syscoLabUI.click(btnLogin);
    }

    public String getUnregisteredUserErrorMessage(){
        syscoLabUI.waitTillElementLoaded(errorUnregisteredUser);
        String errorMessages = syscoLabUI.getText(errorUnregisteredUser);
        return errorMessages;
    }

    public void clickLoginButtonWithRegisteredEmailAndPassword(){
        syscoLabUI.sendKeys(txtEmail,loginData.registeredEmail);
        syscoLabUI.sendKeys(txtPassword,loginData.registeredPassword);
        syscoLabUI.waitTillElementLoaded(btnLogin);
        syscoLabUI.click(btnLogin);
    }



    public void quitDriver(){
        syscoLabUI.quit();
    }

}

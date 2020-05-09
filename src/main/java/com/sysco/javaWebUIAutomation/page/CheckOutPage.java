package com.sysco.javaWebUIAutomation.page;

import com.sysco.javaWebUIAutomation.data.CheckOutData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CheckOutPage extends TheAthletesFootHomePage {

    CheckOutData checkOutData = new CheckOutData();

    private By txtFirstName = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='First Name']/../following-sibling::div/input");
    private By txtLastName = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Last Name']/../following-sibling::div/input");
    private By btnContinue = By.xpath("//button[@title='Continue']");
    private By errorEmptyAddress =By.xpath("//div[@id='shipping-new-address-form']/fieldset//span[text()='Street Address Line 1']/../following-sibling::div/div/span");
    private By errorEmptySuburb =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Suburb']/../following-sibling::div/div/span");
    private By errorEmptyStateProvince =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='State/Province']/../following-sibling::div/div/span");
    private By errorEmptyPostCode =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Post Code']/../following-sibling::div/div/span");
    private By errorEmptyPhoneNumber =By.xpath("//div[@id='shipping-new-address-form']/div//label/span[text()='Phone Number']/../following-sibling::div/div[@class='field-error mage-error']/span");
    private By txtAddress = By.xpath("//div[@id='shipping-new-address-form']/fieldset//span[text()='Street Address Line 1']/../following-sibling::div/input");
    private By txtSuburb =By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Suburb']/../following-sibling::div/input");
    private By txtStateProvince = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='State/Province']/../following-sibling::div/input");
    private By txtPostCode = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='Post Code']/../following-sibling::div/input");
    private By txtPhoneNumber = By.xpath("//div[@id='shipping-new-address-form']/div//label/span[text()='Phone Number']/../following-sibling::div/input");
    private By txtPostCodeOption1 = By.xpath("//a[text()=' BARANGAROO New South Wales']");
    private By txtStateProvinceOption1 = By.xpath("//div[@id='shipping-new-address-form']/div/label/span[text()='State/Province']/../following-sibling::div/input");
    private By lblPaymentInformationHeader = By.xpath("//span[text()='Payment Information']");
    private By rdPayPal = By.xpath("//span[@class='paypal-text']");
    private By rdCredictCard = By.xpath("//strong[@class='card-title']");
    private By rdPayOverTime = By.xpath("//span[text()='Pay Over Time']");
    private By lblGrandTotal = By.xpath("//strong[text()='Grand Total']");
    private By btnPlaceOrderDisabled = By.xpath("//div[@class='opc-submit-step']");



    public String getFirstName(){
       // syscoLabUI.waitTillElementLoaded(txtFirstName);
        //JavascriptExecutor executor = (JavascriptExecutor)syscoLabUI.driver;
        //executor.executeScript("arguments[0].text;", syscoLabUI.driver.findElement(txtFirstName));
        return syscoLabUI.getText(txtFirstName);
    }


    public String getLastName(){
        return syscoLabUI.getText(txtLastName);
    }

    public boolean isFirstNameAvailable(){
        return syscoLabUI.isDisplayed(txtFirstName);
    }

    public boolean isLastNameAvailable(){
        return syscoLabUI.isDisplayed(txtLastName);
    }

    public void clickContinueButton(){
        syscoLabUI.waitTillElementLoaded(btnContinue);
        syscoLabUI.click(btnContinue);
        syscoLabUI.sleep(10);
    }

    public String[] getErrorMessagesForEmptyDetailsInCheckOutPage(){
        String[] errorMessages = new String[5];
        errorMessages[0] = syscoLabUI.getText(errorEmptyAddress);
        errorMessages[1] = syscoLabUI.getText(errorEmptySuburb);
        errorMessages[2] = syscoLabUI.getText(errorEmptyStateProvince);
        errorMessages[3] = syscoLabUI.getText(errorEmptyPostCode);
        errorMessages[4] = syscoLabUI.getText(errorEmptyPhoneNumber);
        return errorMessages;
    }

    public void setDataforCheckOutPageRequiredFields(){
        syscoLabUI.sendKeys(txtAddress, checkOutData.address);
        syscoLabUI.sendKeys(txtSuburb, checkOutData.suburb);
        //syscoLabUI.sendKeys(txtStateProvince,checkOutData.provinceState);
        //syscoLabUI.click(txtStateProvinceOption1);
        //syscoLabUI.sleep(10);
        syscoLabUI.sendKeys(txtPostCode,checkOutData.postalCode);
        syscoLabUI.sleep(5);
        syscoLabUI.waitTillElementLoaded(txtPostCodeOption1);
        syscoLabUI.click(txtPostCodeOption1);
        syscoLabUI.sendKeys(txtPhoneNumber,checkOutData.phoneNumber);
        syscoLabUI.sleep(10);
    }

    public boolean isPaymentInformationHeaderAvailable(){
        return syscoLabUI.isDisplayed(lblPaymentInformationHeader);
    }

    public boolean isPayPalOptionAvailable(){
        return syscoLabUI.isDisplayed(rdPayPal);
    }

    public boolean isCreditCardOptionAvailable(){
        return syscoLabUI.isDisplayed(rdCredictCard);
    }

    public boolean isPayOverTimeOptionAvailable(){
        return syscoLabUI.isDisplayed(rdPayOverTime);
    }

    public boolean isGrandTotalLabelAvailable(){
        return syscoLabUI.isDisplayed(lblGrandTotal);
    }

    public boolean isDisabledPlaceOrderButtoneAvailable(){
        return syscoLabUI.isDisplayed(btnPlaceOrderDisabled);
    }


}

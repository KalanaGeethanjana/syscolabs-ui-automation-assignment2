package com.sysco.javaWebUIAutomation.util;

import com.sysco.javaWebUIAutomation.common.Constants;
import com.sysco.javaWebUIAutomation.function.TheAthletesFootHome;
import com.sysco.javaWebUIAutomation.page.TheAthletesFootHomePage;
import com.syscolab.qe.core.common.LoggerUtil;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Listeners(SyscoLabListener.class)

public class TestBase {

    private SyscoLabListener testListeners;
    protected SyscoLabUI syscoLabUI;

    @BeforeClass
    public void init() {
        testListeners = new SyscoLabListener();
        //syscoLabQCenter = new SyscoLabQCenter();
        DriverEnvironmentSetUpUtil.setToRunLocally();
        syscoLabUI = new SyscoLabWUI(null);
        try {
            String URL = URLEncoder.encode(Constants.THE_ATHLETES_FOOT_URL, "UTF-8");
            //syscoLabWUI.navigateTo(Constants.THE_ATHLETES_FOOT_URL);
            //syscoLabWUI.getDriver().manage().window().maximize();
           // TheAthletesFootHomePage.setWebDriver(syscoLabWUI.getDriver());
        } catch (UnsupportedEncodingException e) {
            LoggerUtil.logERROR("Unable to encode URL", e);
        }
    }


    @BeforeTest
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }


    @AfterTest
    public void quitDriverMethod() {
        TheAthletesFootHome.quitDriver();
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        syscoLabUI.quit();

    }
}

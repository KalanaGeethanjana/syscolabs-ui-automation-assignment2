package com.sysco.javaWebUIAutomation.util;

import com.sysco.javaWebUIAutomation.function.TheAthletesFootHome;
import org.testng.annotations.AfterTest;

public class TestBase {

    @AfterTest
    public void quitDriverMethod(){
        TheAthletesFootHome.quitDriver();
    }
}

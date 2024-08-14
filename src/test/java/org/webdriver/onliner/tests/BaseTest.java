package org.webdriver.onliner.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.webdriver.onliner.utility.Browser;

import java.net.MalformedURLException;

public class BaseTest {

    {
        System.setProperty("browserType", "CHROME");
    }

    @BeforeMethod
    public void initDriver(){
        Browser.initDriver();
    }
    @AfterMethod
    public void cleanup(){
        Browser.close();
    }
}

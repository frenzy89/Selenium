package org.webdriver.onliner.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.webdriver.onliner.utility.Browser;

public class AlertTest extends BaseTest{

    @Test
    public void alertTest() throws InterruptedException {
        Browser.getDriver().get("https://www.quackit.com/javascript/javascript_alert_box.cfm");

        ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollBy(0,200)");

        Browser.getDriver().switchTo().frame("result1");

        WebElement element = Browser.getDriver().findElement(By.xpath("//input[@value='Click me']"));
//        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);


        Browser.getDriver().findElement(By.xpath("//input")).click();

        Alert alert = Browser.getDriver().switchTo().alert();

        Assert.assertEquals(alert.getText(),"Thanks... I feel much better now!");

        alert.accept();
        Browser.getDriver().switchTo().defaultContent();

        Thread.sleep(5000);

    }
}

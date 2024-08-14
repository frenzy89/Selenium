package org.webdriver.onliner.tests;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.webdriver.onliner.pages.steam.SteamDownloadPage;
import org.webdriver.onliner.pages.steam.SteamMainPage;
import org.webdriver.onliner.utility.Browser;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AdvanceTests extends BaseTest {

    @Test
    public void logTest() throws IOException {
        Browser.getDriver().get("https://store.steampowered.com/");
        SteamMainPage mainPage = new SteamMainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        Browser.saveScreenShot();

    }

    @Test
    public void downloadTest() {
        String downloadPath = "C:\\Users\\Dzmitry_Shykunou\\Downloads\\SteamSetup.exe";
        File fileToCheck = new File(downloadPath);
        if(fileToCheck.exists()){
            fileToCheck.delete();
        }
        Browser.getDriver().get("https://store.steampowered.com/");
        SteamMainPage mainPage = new SteamMainPage();
        SteamDownloadPage steamDownloadPage = mainPage.openInstallationPage();
        steamDownloadPage.downloadSteamClient();


        FluentWait<File> waiter = new FluentWait<>(fileToCheck);
        waiter.withTimeout(30, TimeUnit.SECONDS);
        waiter.pollingEvery(2000, TimeUnit.MILLISECONDS);
        waiter.until(file -> file.exists() && file.length() > 0);

        Assert.assertTrue(fileToCheck.exists(),downloadPath + " is not exist after downloading");

    }

    @AfterMethod
    public void clean() throws InterruptedException {
        Browser.printLogs();
        Thread.sleep(5000);
    }

}

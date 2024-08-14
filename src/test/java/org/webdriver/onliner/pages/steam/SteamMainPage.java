package org.webdriver.onliner.pages.steam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webdriver.onliner.utility.Browser;

public class SteamMainPage {

    @FindBy(xpath = "//*[@class='header_installsteam_btn_content']")
    private WebElement installSteamButton;

    public SteamMainPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public boolean isPageOpened() {
        return installSteamButton.isDisplayed();
    }

    public SteamDownloadPage openInstallationPage() {
        installSteamButton.click();
        return new SteamDownloadPage();
    }
}

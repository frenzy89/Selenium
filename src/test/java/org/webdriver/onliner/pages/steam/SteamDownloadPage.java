package org.webdriver.onliner.pages.steam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webdriver.onliner.utility.Browser;

public class SteamDownloadPage {
    @FindBy(xpath = "//*[@class='about_install_steam_link'][1]")
    private WebElement installSteamButton;

    public SteamDownloadPage() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void downloadSteamClient(){
        installSteamButton.click();
    }
}

package org.webdriver.onliner.pages.onliner;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webdriver.onliner.enums.TopMenuItem;
import org.webdriver.onliner.pages.BasePage;
import org.webdriver.onliner.utility.Browser;

public class NewsPageFactory extends BasePage {
    @FindBy(xpath = "//a[@class='b-tile-main']")
    private WebElement newsTitle;

    public NewsPageFactory(){
        PageFactory.initElements(Browser.getDriver(), this);
    }
    @Override
    public void openPage() {
        topMenu.clickOnItem(TopMenuItem.NEWS);
    }

    public boolean isNewsItemMenuPresent() {
        return topMenu.isItemExist(TopMenuItem.NEWS);
    }

    public String getNewsTitle() {
        return newsTitle.getText();
    }
}

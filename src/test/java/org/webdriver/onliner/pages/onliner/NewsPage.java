package org.webdriver.onliner.pages.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.webdriver.onliner.enums.TopMenuItem;
import org.webdriver.onliner.pages.BasePage;
import org.webdriver.onliner.utility.Browser;

public class NewsPage extends BasePage {
    private By newsTitleLocator = By.xpath("//a[@class='b-tile-main']");

    @Override
    public void openPage() {
        topMenu.clickOnItem(TopMenuItem.NEWS);
    }

    public boolean isNewsItemMenuPresent() {
        return topMenu.isItemExist(TopMenuItem.NEWS);
    }

    public String getNewsTitle() {
        WebElement newsTitle = waitForElementIsVisible(newsTitleLocator);
        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].style.backgroundColor = 'red'",
                newsTitle);
        return newsTitle.getText();
    }

}

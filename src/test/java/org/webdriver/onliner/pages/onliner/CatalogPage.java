package org.webdriver.onliner.pages.onliner;

import org.webdriver.onliner.enums.TopMenuItem;
import org.webdriver.onliner.pages.BasePage;

public class CatalogPage extends BasePage {
    @Override
    public void openPage() {
        topMenu.clickOnItem(TopMenuItem.CATALOG);
    }
}

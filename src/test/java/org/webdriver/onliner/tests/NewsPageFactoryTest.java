package org.webdriver.onliner.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.webdriver.onliner.pages.onliner.NewsPageFactory;
import org.webdriver.onliner.utility.Browser;

public class NewsPageFactoryTest extends BaseTest {
    NewsPageFactory newsPage;
    @BeforeMethod
    public void openOnliner(){
        Browser.getDriver().get("https://www.onliner.by/");
    }

    @Test
    public void testNewsItemPresent(){
        Assert.assertTrue(newsPage.isNewsItemMenuPresent());
    }
    @Test
    public void openNewsPageTest(){
        newsPage.openPage();
        Assert.assertFalse(newsPage.getNewsTitle().isEmpty());
    }
}

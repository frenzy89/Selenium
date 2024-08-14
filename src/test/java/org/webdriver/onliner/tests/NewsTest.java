package org.webdriver.onliner.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.webdriver.onliner.pages.onliner.NewsPage;
import org.webdriver.onliner.utility.Browser;

import java.io.IOException;

public class NewsTest extends BaseTest {
    NewsPage newsPage;
    @BeforeMethod
    public void openOnliner(){
        Browser.getDriver().get("https://www.onliner.by/");
        newsPage = new NewsPage();
    }
    @AfterMethod
    public void cleanup(){
        Browser.close();
    }

    @Test
    public void testNewsItemPresent(){
        Assert.assertTrue(newsPage.isNewsItemMenuPresent());
    }
    @Test
    public void openNewsPageTest() throws IOException {
        newsPage.openPage();
        Assert.assertFalse(newsPage.getNewsTitle().isEmpty());
        Browser.saveScreenShot();
    }
}

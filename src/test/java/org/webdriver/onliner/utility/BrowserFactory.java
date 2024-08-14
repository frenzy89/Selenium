package org.webdriver.onliner.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.webdriver.onliner.enums.BrowserType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BrowserFactory {
    static {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
    }

    public static boolean isLogsEnabled = true;

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver;
        switch (browserType) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("browser.helperApps.alwaysAsk.force", false);
                prefs.put("safebrowsing.enabled",true);
                prefs.put("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/csv;application/octet-stream;application/x-msdownload");
                prefs.put("profile.default_content_settings.popups", 0);
                options.setExperimentalOption("prefs",prefs);
                if (isLogsEnabled) {
                    LoggingPreferences preferences = new LoggingPreferences();
                    preferences.enable(LogType.BROWSER, Level.ALL);
                    options.setCapability(CapabilityType.LOGGING_PREFS, preferences);
                }
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case RemoteWebDriver:
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.100.18:4444"), new ChromeOptions());
                } catch (MalformedURLException e) {
                    throw new RuntimeException("URL is not supported" + e.getMessage());
                }
                break;
            default:
                throw new IllegalStateException("Browser Not Supported: " + browserType);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}

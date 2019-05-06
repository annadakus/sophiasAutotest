package com.sophiasstyle.configure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {


 @BeforeClass  //settings for launch tests using selenoid (docker) on Windows
    static public void setupSelenoid() {
       Configuration.remote = "http://192.168.99.100:4444/wd/hub";
      Configuration.browser = "chrome";
        Configuration.browserSize = "1280x1024";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Before
    public void setUp() {
       // System.setProperty("selenide.browser", "chrome");
        Configuration.timeout = 50000;
    }

    @After
    public void clearLocalStorage() {
        Selenide.executeJavaScript("localStorage.clear()");
    }

    @After
    public void clearCache() {
        clearBrowserCache();
    }

    @After
    public void clearCookieTest() {
        clearBrowserCookies();
    }

    @After
    public void tearDown() throws IOException {
        File lastSelenideScreenshot = Screenshots.getLastScreenshot();
        if (lastSelenideScreenshot != null) {
            screenshot(Files.toByteArray(lastSelenideScreenshot));
        }
    }

    @Attachment(type = "image/png")
    public static byte[] screenshot(byte[] dataForScreenshot) {
        return dataForScreenshot;
    }

}

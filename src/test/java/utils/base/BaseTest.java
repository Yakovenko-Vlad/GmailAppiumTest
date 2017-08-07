package utils.base;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.Properties;

import java.net.MalformedURLException;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
//@Listeners({AllureScreenshotListener.class})
public abstract class BaseTest {
    public static AppiumDriver<MobileElement> driver;


    /**
     * Prepares {@link WebDriver} instance with timeout configurations.
     */
    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = DriverFactory.initAppiumDriver(Properties.getDeviceName(), Properties.getAppiumUrl());
        driver.manage().timeouts().implicitlyWait(BaseScreen.DEFAULT_TIMEOUT.getTime(), BaseScreen.DEFAULT_TIMEOUT.getTimeUnit());

    }

    /**
     * Closes driver instance after test class execution.
     */
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

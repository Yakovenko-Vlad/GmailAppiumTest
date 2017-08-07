package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static AndroidDriver<MobileElement> initAppiumDriver(String deviceName, String appiumServerUrl) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
        capabilities.setCapability(MobileCapabilityType.APP, new File(DriverFactory.class.getResource("/com.google.android.gm.apk").getFile()).getPath());
        capabilities.setCapability("appActivity","ConversationListActivityGmail");
        capabilities.setCapability("appPackage","com.google.android.gm");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("unicodeKeyboard", true);
        try {
            return new AndroidDriver<>(new URL(appiumServerUrl), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Unable to create Appium WebDriver instance!");
        }
    }
}

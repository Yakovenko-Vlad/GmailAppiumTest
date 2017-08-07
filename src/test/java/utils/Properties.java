package utils;

/**
 * Help class to get passed parameters from environment for further usage in the automation project
 */
public class Properties {
    private static final String DEFAULT_DEVICE_NAME = "Nexus 5X";
    private static final String DEFAULT_APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private Properties() {

    }

    /**
     * @return Device that is used for scripts execution.
     */
    public static String getDeviceName() {
        return System.getProperty(EnvironmentVariable.DEVICE_NAME.toString(), DEFAULT_DEVICE_NAME);
    }

    /**
     * @return Address to running Appium server to connect.
     */
    public static String getAppiumUrl() {
        return System.getProperty(EnvironmentVariable.APPIUM_URL.toString(), DEFAULT_APPIUM_URL);
    }
}

/**
 * All parameters that are passed to automation project
 */
enum EnvironmentVariable {
    DEVICE_NAME("appium.device_name"),
    APPIUM_URL("appium.url");

    private String value;

    EnvironmentVariable(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
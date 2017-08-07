package utils.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Base class for application screens (pages)
 */
public abstract class BaseScreen {
    public static final TimeOutDuration DEFAULT_TIMEOUT = new TimeOutDuration(25, TimeUnit.SECONDS);

    protected final AppiumDriver driver;
    protected final WebDriverWait wait;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT.getTime());
        PageFactory.initElements(new AppiumFieldDecorator(driver, DEFAULT_TIMEOUT), this);
    }

    @Step
    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step
    protected void waitForVisibility(MobileElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step
    protected boolean waitForVisibilityNotStrict(int timeout, By locator) {
        boolean found = false;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
            found = true;
        } catch (Exception e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT.getTime(), DEFAULT_TIMEOUT.getTimeUnit());
        }

        return found;
    }

    @Step
    protected void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Performs swipe operation from (starX, startY) coordinate to (endX, endY) coordinate.
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    @Step
    protected void performSwipe(int startX, int startY, int endX, int endY, int seconds) {
        new TouchAction(driver)
                .press(startX, startY)
                .waitAction(Duration.ofSeconds(seconds))
                .moveTo(endX, endY)
                .release()
                .perform();
    }

    /**
     * Performs swipe operation from (starX, startY) coordinate to (endX, endY) coordinate with default swiping period.
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    @Step
    protected void performSwipe(int startX, int startY, int endX, int endY) {
        performSwipe(startX, startY, endX, endY, 5);
    }

    @Step
    protected void typeInFormField(String value, String fieldName, By locator) {
        MobileElement input = scrollToElement(locator);
        Assert.assertNotNull(input, fieldName + " input is not found");
        input.setValue(value);
    }

    @Step
    private MobileElement scrollToElement(By locator) {
        int scrollingAttempt = 0;
        MobileElement foundElement = null;
        do {
            if (waitForVisibilityNotStrict(1, locator)) {
                foundElement = (MobileElement) driver.findElement(locator);
            } else {
                performSwipe(100, 400, 100, 200, 1);
                scrollingAttempt += 1;
            }
        } while (foundElement == null && scrollingAttempt < 10);

        return foundElement;
    }
}

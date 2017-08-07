package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import ru.yandex.qatools.allure.annotations.Step;
import utils.base.BaseScreen;

import java.util.concurrent.TimeUnit;

public class EmailListPage extends BaseScreen {
    private final double x_percentage = 0.95;
    private final double y_percentage = 0.95;

    public EmailListPage(AppiumDriver driver) {
        super(driver);
        waitForVisibility(emailList);
    }

    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout[1]/android.view.View")
    private MobileElement newInboxEmail;
    @AndroidFindBy(id = "com.google.android.gm:id/list_view")
    private MobileElement emailList;

    @Step
    public NewEmailPage openNewEmailPage() {
        Dimension size = driver.manage().window().getSize();
        int xPoint = (int) (size.width * x_percentage);
        int yPoint = (int) (size.height * y_percentage);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(xPoint, yPoint).perform();
        return new NewEmailPage(driver);
    }

    @Step
    public NewInputEmailPage openNewInputEmail() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        newInboxEmail.click();
        return new NewInputEmailPage(driver);
    }

}

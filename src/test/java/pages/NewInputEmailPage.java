package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utils.base.BaseScreen;

import static org.testng.Assert.assertEquals;

public class NewInputEmailPage extends BaseScreen {
    public NewInputEmailPage(AppiumDriver driver) {
        super(driver);
        waitForVisibility(emailFrom);
    }

    @AndroidFindBy(id = "com.google.android.gm:id/subject_and_folder_view")
    MobileElement inputEmailSubject;
    @AndroidFindBy(id = "com.google.android.gm:id/title_container")
    MobileElement emailFrom;
    @AndroidFindBy(xpath = "//android.webkit.WebView/android.webkit.WebView/android.view.View")
    MobileElement emailText;

    @Step
    public void getText() {
        assertEquals(inputEmailSubject.getText().substring(0, 14), "Gmail app test");
    }
}

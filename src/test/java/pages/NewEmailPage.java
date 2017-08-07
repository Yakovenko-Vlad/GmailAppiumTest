package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;
import utils.base.BaseScreen;
import static org.testng.Assert.assertEquals;

public class NewEmailPage extends BaseScreen {
    public NewEmailPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.google.android.gm:id/send")
    MobileElement sendEmail;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    MobileElement pageName;
    private By toField = By.id("com.google.android.gm:id/to");
    private By subject = By.id("com.google.android.gm:id/subject");
    private By email = By.id("com.google.android.gm:id/composearea_tap_trap_bottom");

    @Step
    public NewEmailPage fillToField(String value) {
        waitForVisibility(toField);
        typeInFormField(value, "Field TO", toField);
        return this;
    }

    @Step
    public NewEmailPage fillSubject(String value) {
        typeInFormField(value, "Subject", subject);
        return this;
    }

    @Step
    public NewEmailPage fillEmail(String value) {
        typeInFormField(value, "Email", email);
        return this;
    }

    @Step
    public EmailListPage sendEmailClick(){
        sendEmail.click();
        assertEquals(pageName.getText(), "Primary", "Email send fail");
        return new EmailListPage(driver);
    }
}

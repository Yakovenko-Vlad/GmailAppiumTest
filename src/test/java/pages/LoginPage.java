package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.base.BaseScreen;

public class LoginPage extends BaseScreen {
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "identifierNext")
    private MobileElement emailNext;
    @AndroidFindBy(id = "passwordNext")
    private MobileElement passwordNext;
    @AndroidFindBy(id = "next")
    private MobileElement privacyNext;
    @AndroidFindBy(id = "com.google.android.gm:id/action_done")
    private MobileElement openGmailAccount;
    @AndroidFindBy(id = "com.google.android.gms:id/suw_navbar_next")
    private MobileElement googleServiceNext;
    @AndroidFindBy(id = "com.google.android.gms:id/suw_items_title")
    private MobileElement googleServiceText;
    @AndroidFindBy(id = "com.google.android.gms:id/suw_navbar_more")
    private MobileElement moreButton;
    @AndroidFindBy(id = "com.google.android.gm:id/owner")
    private MobileElement owner;

    private By emailField = By.id("identifierId");
    private By password = By.id("password");

    @Step
    public LoginPage enterEmail(String value) {
        waitForVisibility(emailField);
        typeInFormField(value, "Email", emailField);
        return this;
    }

    @Step
    public LoginPage enterPassword(String value) {
        waitForVisibility(password);
        typeInFormField(value, "Password", password);
        return this;
    }

    @Step
    public LoginPage submitEmail() {
        emailNext.click();
        return this;
    }

    @Step
    public LoginPage submitPassword() {
        passwordNext.click();
        return this;
    }

    @Step
    public LoginPage privacyclick() {
        waitForVisibility(privacyNext);
        privacyNext.click();
        return this;
    }

    @Step
    public LoginPage googleServiceClick() {
        waitForVisibility(googleServiceText);
        moreButton.click();
        waitForVisibility(googleServiceNext);
        googleServiceNext.click();
        return this;
    }

    @Step
    public void openGmailAccount() {
        waitForVisibility(owner);
        openGmailAccount.click();
    }
}

package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utils.base.BaseScreen;

public class WelcomePage extends BaseScreen {
    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }
    @AndroidFindBy(id = "com.google.android.gm:id/welcome_tour_got_it")
    private MobileElement skipWelcomePage;

    @AndroidFindBy(id = "com.google.android.gm:id/setup_addresses_add_another")
    private MobileElement addAnEmail;
    //TODO
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/providers_list']/android.widget.LinearLayout[1]")
    private MobileElement newGoogleAccount;

    @Step
    public WelcomePage clickOnSkipPageButton(){
        waitForVisibility(skipWelcomePage);
        skipWelcomePage.click();
        return this;
    }

    @Step
    public WelcomePage addNewEmail(){
        waitForVisibility(addAnEmail);
        addAnEmail.click();
        return this;
    }

    @Step
    public LoginPage googleAccountClick(){
        waitForVisibility(newGoogleAccount);
        newGoogleAccount.click();
        return new LoginPage(driver);
    }

}

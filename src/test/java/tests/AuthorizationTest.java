package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;
import utils.base.BaseTest;

public class AuthorizationTest extends BaseTest {
    @Test(priority = 0)
    public void firstUITest() {
        LoginPage loginPage = new WelcomePage(driver)
                .clickOnSkipPageButton()
                .addNewEmail()
                .googleAccountClick();

        loginPage.enterEmail("testemailqatestlab@gmail.com")
                .submitEmail()
                .enterPassword("qatestla")
                .submitPassword()
                .privacyclick()
                .googleServiceClick();
        loginPage.openGmailAccount();
    }
}
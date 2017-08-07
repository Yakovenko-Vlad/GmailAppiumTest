package tests;

import org.testng.annotations.Test;
import pages.EmailListPage;
import pages.NewEmailPage;
import pages.NewInputEmailPage;
import utils.base.BaseTest;

public class GmailTest extends BaseTest {
    @Test(priority = 0)
    public void newEmailTest() {
        NewEmailPage newEmailPage = new EmailListPage(driver).openNewEmailPage();

        EmailListPage emailListPage = newEmailPage
                .fillSubject("Gmail app test")
                .fillEmail("Automation test gmail app for Android")
                .fillToField("testemailqatestlab@gmail.com")
                .sendEmailClick();

        NewInputEmailPage newInputEmailPage = emailListPage.openNewInputEmail();
        newInputEmailPage.getText();
    }
}

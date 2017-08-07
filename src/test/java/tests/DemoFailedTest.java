package tests;



import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailListPage;
import utils.base.BaseTest;

public class DemoFailedTest extends BaseTest {

    @Test(priority = 0)
    public void failedLoginTest() {
        new EmailListPage(driver);
        Assert.assertTrue(false, "Some demo assertion failure.");
    }

}

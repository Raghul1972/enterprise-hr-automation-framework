package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.LoggerUtils;

public class LogoutTest extends BaseTest {

	@Test(retryAnalyzer = retry.RetryAnalyzer.class)

    public void verifyLogout() {

        LoginPage login =
                new LoginPage(driver);

        login.login(

                ConfigReader.getProperty("username"),

                ConfigReader.getProperty("password")

        );

        DashboardPage dashboard =
                new DashboardPage(driver);

        dashboard.logout();

        SoftAssert softAssert =
                new SoftAssert();

        softAssert.assertTrue(

                driver.getCurrentUrl().contains("login"),

                "Logout Failed"

        );

        softAssert.assertAll();

        LoggerUtils.logger.info("Logout Successful");

    }

}
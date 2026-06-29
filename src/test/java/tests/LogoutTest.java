package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;

public class LogoutTest extends BaseTest {

    @Test

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

        Assert.assertTrue(

                driver.getCurrentUrl().contains("login"),

                "Logout Failed"

        );

        System.out.println("Logout Successful");

    }

}
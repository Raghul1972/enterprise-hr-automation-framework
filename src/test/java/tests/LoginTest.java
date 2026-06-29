package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

    @Test

    public void verifyLogin() {

        LoginPage login =
                new LoginPage(driver);

        login.login(

                ConfigReader.getProperty("username"),

                ConfigReader.getProperty("password")

        );

        DashboardPage dashboard =
                new DashboardPage(driver);

        Assert.assertTrue(

                dashboard.isDashboardDisplayed(),

                "Login Failed"

        );

        System.out.println("Login Successful");

    }

}
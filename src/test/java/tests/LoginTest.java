package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataprovider.LoginDataProvider;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(
		    dataProvider = "loginData",
		    dataProviderClass = LoginDataProvider.class,
		    retryAnalyzer = retry.RetryAnalyzer.class
		)
    public void verifyLogin(String username,
                            String password) {

        LoginPage login =
                new LoginPage(driver);

        login.login(username, password);

        DashboardPage dashboard =
                new DashboardPage(driver);

        Assert.assertTrue(
                dashboard.isDashboardDisplayed(),
                "Login Failed");
        

        System.out.println(
                "Login Successful : " + username);
    }
}
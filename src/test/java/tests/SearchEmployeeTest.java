package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchEmployeePage;
import utilities.ConfigReader;

public class SearchEmployeeTest extends BaseTest {

	@Test(retryAnalyzer = retry.RetryAnalyzer.class)
    public void verifySearchEmployee() {

        LoginPage login = new LoginPage(driver);

        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        SearchEmployeePage search = new SearchEmployeePage(driver);

        search.clickPIM();

        search.enterEmployeeName("John");

        search.clickSearch();

        System.out.println("Employee Search Completed");
    }
}
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;

public class AddEmployeeTest extends BaseTest {

	@Test(retryAnalyzer = retry.RetryAnalyzer.class)

    public void verifyAddEmployee() {

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

        AddEmployeePage employee =
                new AddEmployeePage(driver);

        employee.openAddEmployeePage();

        employee.addEmployee(

                "John",

                "David"

        );

        System.out.println("Employee Added Successfully");

    }

}
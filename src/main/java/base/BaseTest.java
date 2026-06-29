package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverFactory;
import utilities.ConfigReader;

public class BaseTest {

	public static WebDriver driver;

    @BeforeMethod

    public void setup() {

        driver = DriverFactory.getDriver();

        driver.get(
                ConfigReader.getProperty("url"));

    }

    @AfterMethod

    public void tearDown() {

        DriverFactory.quitDriver();

    }

}
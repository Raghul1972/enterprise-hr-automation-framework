package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import driver.DriverFactory;
import listeners.TestListener;
import utilities.ConfigReader;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        try {

            driver = DriverFactory.getDriver();

            driver.get(ConfigReader.getProperty("url"));

        } catch (Exception e) {

            System.out.println("========== SETUP FAILED ==========");
            e.printStackTrace();
            throw e;

        }

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
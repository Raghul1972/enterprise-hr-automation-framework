package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ConfigReader;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser =
                    ConfigReader.getProperty("browser");
            
            System.out.println("Selected Browser: " + browser);

            switch (browser.toLowerCase()) {

            case "chrome":

                driver = new ChromeDriver();

                break;

            case "edge":

                System.setProperty(
                        "webdriver.edge.driver",
                        "C:\\WebDrivers\\msedgedriver.exe");

                driver = new EdgeDriver();

                break;
            case "firefox":

                driver = new FirefoxDriver();

                break;

            default:

                throw new RuntimeException(
                        "Invalid Browser : " + browser);

            }

            driver.manage().window().maximize();

            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(
                            Integer.parseInt(
                                    ConfigReader.getProperty(
                                            "timeout"))));

        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}
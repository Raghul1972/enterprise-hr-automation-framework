package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import constants.FrameworkConstants;
import utilities.ConfigReader;
import utilities.LoggerUtils;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser =
                    ConfigReader.getProperty("browser");
            
            System.out.println("Selected Browser: " + browser);

            switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions chromeOptions = new ChromeOptions();

                if (Boolean.parseBoolean(
                        ConfigReader.getProperty("headless"))) {

                    chromeOptions.addArguments("--headless=new");

                }

                if (Boolean.parseBoolean(
                        ConfigReader.getProperty("incognito"))) {

                    chromeOptions.addArguments("--incognito");

                }

                if (!Boolean.parseBoolean(
                        ConfigReader.getProperty("notifications"))) {

                    chromeOptions.addArguments("--disable-notifications");

                }

                driver = new ChromeDriver(chromeOptions);

                break;

            case "edge":

                System.setProperty(
                        "webdriver.edge.driver",
                        FrameworkConstants.EDGE_DRIVER_PATH);

                EdgeOptions edgeOptions = new EdgeOptions();

                if (Boolean.parseBoolean(
                        ConfigReader.getProperty("headless"))) {

                    edgeOptions.addArguments("--headless=new");

                }

                if (Boolean.parseBoolean(
                        ConfigReader.getProperty("incognito"))) {

                    edgeOptions.addArguments("--inprivate");

                }

                if (!Boolean.parseBoolean(
                        ConfigReader.getProperty("notifications"))) {

                    edgeOptions.addArguments("--disable-notifications");

                }

                driver = new EdgeDriver(edgeOptions);

                break;
                
            case "firefox":

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (Boolean.parseBoolean(
                        ConfigReader.getProperty("headless"))) {

                    firefoxOptions.addArguments("-headless");

                }

                if (Boolean.parseBoolean(
                        ConfigReader.getProperty("incognito"))) {

                    firefoxOptions.addArguments("-private");

                }

                driver = new FirefoxDriver(firefoxOptions);

                break;

            default:

                throw new RuntimeException(
                        "Invalid Browser : " + browser);

            }

            if (Boolean.parseBoolean(
                    ConfigReader.getProperty("maximize"))) {

                try {

                    driver.manage().window().maximize();

                } catch (Exception e) {

                    LoggerUtils.logger.warn(
                            "Unable to maximize browser.");

                }

            }
            
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
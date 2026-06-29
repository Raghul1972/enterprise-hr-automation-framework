package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriver driver;

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(

                driver,

                Duration.ofSeconds(

                        Integer.parseInt(

                                ConfigReader.getProperty("timeout"))));

    }

    public void waitForVisibility(

            WebElement element) {

        wait.until(

                ExpectedConditions.visibilityOf(element));

    }

    public void waitForClick(

            WebElement element) {

        wait.until(

                ExpectedConditions.elementToBeClickable(element));

    }

}
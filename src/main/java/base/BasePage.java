package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ObjectRepository;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;

    }

    public void click(By locator) {

        driver.findElement(locator).click();

    }

    public void type(By locator, String text) {

        driver.findElement(locator).sendKeys(text);

    }

    public String getText(By locator) {

        return driver.findElement(locator).getText();

    }

    public boolean isDisplayed(By locator) {

        return driver.findElement(locator).isDisplayed();

    }

    protected By getBy(String key) {

        String locator =
                ObjectRepository.getLocator(key);

        String[] parts =
                locator.split("=", 2);

        switch (parts[0]) {

        case "id":
            return By.id(parts[1]);

        case "name":
            return By.name(parts[1]);

        case "xpath":
            return By.xpath(parts[1]);

        case "css":
            return By.cssSelector(parts[1]);

        case "linkText":
            return By.linkText(parts[1]);

        case "className":
            return By.className(parts[1]);

        default:
            throw new RuntimeException(
                    "Invalid locator type : "
                            + parts[0]);

        }

    }

}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchEmployeePage {

    WebDriver driver;

    public SearchEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By pimMenu = By.xpath("//span[text()='PIM']");

    By employeeName =
            By.xpath("(//input[@placeholder='Type for hints...'])[1]");

    By searchButton =
            By.xpath("//button[@type='submit']");

    // Methods

    public void clickPIM() {
        driver.findElement(pimMenu).click();
    }

    public void enterEmployeeName(String name) {
        driver.findElement(employeeName).sendKeys(name);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
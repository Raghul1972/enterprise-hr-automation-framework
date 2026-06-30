package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class SearchEmployeePage extends BasePage{

    public SearchEmployeePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    By pimMenu = By.xpath("//span[text()='PIM']");

    By employeeName =
            By.xpath("(//input[@placeholder='Type for hints...'])[1]");

    By searchButton =
            By.xpath("//button[@type='submit']");

    // Methods

    public void clickPIM() {
    	click(pimMenu);
    }

    public void enterEmployeeName(String name) {
    	type(employeeName, name);
    }

    public void clickSearch() {
    	click(searchButton);
    }
}
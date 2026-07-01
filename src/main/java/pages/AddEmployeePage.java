package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import utilities.ObjectRepository;

public class AddEmployeePage extends BasePage {

    public AddEmployeePage(WebDriver driver) {

        super(driver);

        ObjectRepository.load("AddEmployeePage");

    }

    public void openAddEmployeePage() {

        click(getBy("pimMenu"));

        click(getBy("addEmployeeButton"));

    }

    public void addEmployee(String fname, String lname) {

        type(getBy("firstName"), fname);

        type(getBy("lastName"), lname);

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions
                .invisibilityOfElementLocated(
                        getBy("loader")));

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        getBy("saveButton")));

        click(getBy("saveButton"));

    }

}
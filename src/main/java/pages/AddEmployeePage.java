package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {

    WebDriver driver;

    public AddEmployeePage(WebDriver driver) {

        this.driver = driver;

    }

    By pimMenu =
            By.xpath("//span[text()='PIM']");

    By addEmployeeButton =
            By.linkText("Add Employee");

    By firstName =
            By.name("firstName");

    By lastName =
            By.name("lastName");

    By saveButton =
            By.xpath("//button[@type='submit']");

    public void openAddEmployeePage() {

        driver.findElement(pimMenu).click();

        driver.findElement(addEmployeeButton).click();

    }

    public void addEmployee(String fname,
                            String lname) {

        driver.findElement(firstName).sendKeys(fname);

        driver.findElement(lastName).sendKeys(lname);

        driver.findElement(saveButton).click();

    }

}
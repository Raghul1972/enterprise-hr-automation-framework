package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    
    By loader =
            By.className("oxd-form-loader");

    public void openAddEmployeePage() {

        driver.findElement(pimMenu).click();

        driver.findElement(addEmployeeButton).click();

    }

    public void addEmployee(String fname,
            String lname) {

driver.findElement(firstName).sendKeys(fname);

driver.findElement(lastName).sendKeys(lname);

WebDriverWait wait =
new WebDriverWait(driver,
        Duration.ofSeconds(10));

wait.until(ExpectedConditions
.invisibilityOfElementLocated(loader));

wait.until(ExpectedConditions
.elementToBeClickable(saveButton));

driver.findElement(saveButton).click();

}

}
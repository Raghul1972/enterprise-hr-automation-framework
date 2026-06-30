package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;

public class AddEmployeePage extends BasePage {

    public AddEmployeePage(WebDriver driver) {

        super(driver);

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

    	click(pimMenu);

    	click(addEmployeeButton);
    }

    public void addEmployee(String fname,
            String lname) {

    	type(firstName, fname);

    	type(lastName, lname);

WebDriverWait wait =
new WebDriverWait(driver,
        Duration.ofSeconds(10));

wait.until(ExpectedConditions
.invisibilityOfElementLocated(loader));

wait.until(ExpectedConditions
.elementToBeClickable(saveButton));

click(saveButton);

}

}
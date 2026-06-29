package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By dashboardHeader =
            By.xpath("//h6[text()='Dashboard']");

    By profileMenu =
            By.cssSelector(".oxd-userdropdown-tab");

    By logout =
            By.linkText("Logout");

    public boolean isDashboardDisplayed() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    public void logout() {

        driver.findElement(profileMenu).click();

        driver.findElement(logout).click();

    }

}
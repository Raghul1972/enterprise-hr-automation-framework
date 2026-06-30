package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {

        super(driver);

    }

    By dashboardHeader =
            By.xpath("//h6[text()='Dashboard']");

    By profileMenu =
            By.cssSelector(".oxd-userdropdown-tab");

    By logout =
            By.linkText("Logout");

    public boolean isDashboardDisplayed() {

        return isDisplayed(dashboardHeader);

    }

    public void logout() {

        click(profileMenu);

        click(logout);

    }

}
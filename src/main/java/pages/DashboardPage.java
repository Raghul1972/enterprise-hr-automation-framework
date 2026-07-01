package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ObjectRepository;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {

        super(driver);

        ObjectRepository.load("DashboardPage");

    }

    public boolean isDashboardDisplayed() {

        return driver.findElement(getBy("dashboardHeader"))
                .isDisplayed();

    }

    public void logout() {

        click(getBy("profileMenu"));

        click(getBy("logout"));

    }

    

}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    private By username =
            By.name("username");

    private By password =
            By.name("password");

    private By loginButton =
            By.cssSelector("button[type='submit']");

    public void login(String user, String pass) {

        driver.findElement(username).sendKeys(user);

        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginButton).click();

    }

}
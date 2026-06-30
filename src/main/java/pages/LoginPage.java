package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);

    }

    private By username =
            By.name("username");

    private By password =
            By.name("password");

    private By loginButton =
            By.cssSelector("button[type='submit']");

    public void login(String user, String pass) {

    	type(username, user);

    	type(password, pass);

    	click(loginButton);

    }

}
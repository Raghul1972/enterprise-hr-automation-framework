package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ObjectRepository;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);

        ObjectRepository.load("LoginPage");

    }

    public void login(String user, String pass) {

        type(getBy("username"), user);

        type(getBy("password"), pass);

        click(getBy("loginButton"));

    }

    }
package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.ObjectRepository;

public class SearchEmployeePage extends BasePage {

    public SearchEmployeePage(WebDriver driver) {

        super(driver);

        ObjectRepository.load("SearchEmployeePage");

    }

    public void clickPIM() {

        click(getBy("pimMenu"));

    }

    public void enterEmployeeName(String name) {

        type(getBy("employeeName"), name);

    }

    public void clickSearch() {

        click(getBy("searchButton"));

    }

}
package com.filatov.fromdocument;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Main {
    public static void main(String[] args) {
        String siteHomePage = "https://pn.com.ua";
        WebDriver driver = new FirefoxDriver();
        driver.get(siteHomePage);
        HomePage homePage;
        ComputerPage computerPage;
        homePage = PageFactory.initElements(driver, HomePage.class);
        computerPage = homePage.choiceComputerCategory();
    }
}

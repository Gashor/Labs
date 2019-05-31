package com.filatov;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class StepsForSerenity {
    public HomePage homePage;
    public WebDriver driver;
    public ComputerPage computerPage;
    public String siteHomePage = "https://pn.com.ua";

    @Step("Given the user visits a page {0}")
    public void a_user_visits_a_page_(String homePage) {
        this.siteHomePage = homePage;
    }

    @Step("When the user chooses Computer {0}")
    public void the_user_chooses_category_Computer() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get(siteHomePage);
        computerPage = homePage.choiceComputerCategory();
    }

    @Step("The user sees {0} subcatefory")
    public void the_user_can_see_subcategory_ITService(String subCategory) {
        assertThat(computerPage.getTextITService()).overridingErrorMessage("testComputerCategory failed").contains(subCategory);
        driver.quit();
    }
}

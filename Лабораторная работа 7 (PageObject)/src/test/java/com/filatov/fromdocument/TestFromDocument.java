package com.filatov.fromdocument;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestFromDocument {
    private String siteHomePage = "https://pn.com.ua/";
    private WebDriver driver;
    private HomePage homePage;
    private ComputerPage computerPage;

    @Before
    public void testBeforeClass() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(siteHomePage);
    }

    @Test
    public void testComputerFactory() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        computerPage = homePage.choiceComputerCategory();
        System.out.println(computerPage.getTextITService());
        computerPage.getTextITService();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        assertEquals(true, computerPage.getTextITService().contains("IT услуги"));
    }
}

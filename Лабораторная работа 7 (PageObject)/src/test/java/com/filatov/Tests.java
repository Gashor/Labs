package com.filatov;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
public class Tests {
    static WebDriver webDriver;

    @BeforeClass
    public static void webDriverInitialisation() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.get("https://pn.com.ua");
    }

    @Test
    public void test(){
        HomePage homePage = new HomePage(webDriver);
        List<String> sofasNames = homePage.choiceSofas().getSofasNames();
        for(String sofaName : sofasNames){
            Assert.assertEquals(true, sofaName.startsWith("AMF"));
        }
    }
}

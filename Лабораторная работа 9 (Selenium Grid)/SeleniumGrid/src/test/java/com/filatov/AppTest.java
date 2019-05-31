package com.filatov;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    static WebDriver driver;
    static DesiredCapabilities capabilities;

    @BeforeClass
    public static void init() throws MalformedURLException {
        capabilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:5556/wd/hub"), capabilities);
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver.get("https://pn.com.ua");
    }

    @Test
    public void test() {
        driver.findElement(By.xpath(".//*[@id=\"column-center\"]/section/div[1]/a")).click();
    }

}

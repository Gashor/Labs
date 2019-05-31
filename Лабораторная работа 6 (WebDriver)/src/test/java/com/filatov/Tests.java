package com.filatov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.xpath;

public class Tests {
    WebDriver webDriver;

    @BeforeEach
    void webDriverInitialisation() {
        System.setProperty("webdriver.gecko.driver", "G:\\GAMES\\QA\\Лаба 6 (WebDriver)\\geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

    @Test
    void test_1(){
        webDriver.get("https://pn.com.ua/");
        webDriver.findElement(xpath(".//a[text()='Диваны']")).click();
        webDriver.findElement(xpath(".//*[@id='producers-filter-block']/div[3]/span[3]")).click();
        String companyName = webDriver.findElement(xpath(".//*[@id='producers-filter-block']/div[3]/span[3]")).getText();
        List<WebElement> sofas = webDriver.findElements(xpath(".//li[*]/article/div[2]/div[1]/a"));
        for (WebElement webElement : sofas) {
            assertEquals(true, webElement.getText().startsWith(companyName));
        }
    }


    @Test
    void test_2(){
        webDriver.get("https://pn.com.ua/");
        webDriver.findElement(xpath(".//a[text()='Диваны']")).click();
        int numOfGoods = Integer.valueOf(webDriver.findElement(xpath(".//*[@id='producers-filter-block']/div[3]/span[3]/small")).getText());
        webDriver.findElement(xpath(".//*[@id='producers-filter-block']/div[3]/span[3]")).click();
        int numOfFoundGoods = Integer.valueOf(webDriver.findElement(xpath(".//li[3]/small/b")).getText());

        assertEquals(numOfFoundGoods == numOfGoods, true);
    }

    @Test
    void test_3() throws InterruptedException {
        webDriver.get("https://pn.com.ua/");
        webDriver.findElement(xpath(".//a[text()=\"Холодильники\"]")).click();
        List<WebElement> frides = webDriver.findElements(xpath(".//a[text()=\"добавить в сравнение        \"]"));
        frides.get(0).click();
        frides.get(1).click();
        webDriver.findElement(xpath(".//a[text()=\"Сравнить        \"]")).click();
        assertEquals(true, webDriver.getCurrentUrl().contains("compare"));
        Thread.sleep(500);
        int numberOfFridges = webDriver.findElements(xpath(".//div[@class=\"item\"]")).size();
        Thread.sleep(500);
        assertEquals(2, numberOfFridges);
    }

    @Test
    void test_4() {
        webDriver.get("https://pn.com.ua/");
        webDriver.findElement(xpath(".//a[text()=\"Холодильники\"]")).click();
        List<WebElement> frides = webDriver.findElements(xpath(".//a[text()=\"добавить в сравнение        \"]"));
        frides.get(0).click();
        frides.get(1).click();
        frides.get(2).click();
        frides.get(3).click();
        webDriver.findElement(xpath(".//a[text()=\"Сравнить        \"]")).click();
        assertEquals(true, webDriver.getCurrentUrl().contains("compare"));
        int numberOfFridges = webDriver.findElements(xpath(".//div[@class=\"item\"]")).size();
        assertEquals(4, numberOfFridges);
        webDriver.findElements(xpath(".//a[text()=\" удалить                        \"]")).get(0).click();
        numberOfFridges = webDriver.findElements(xpath(".//div[@class=\"item\"]")).size();
        assertEquals(3, numberOfFridges);
    }

    @Test
    void test_5() throws InterruptedException {
        webDriver.get("https://pn.com.ua/");
        webDriver.findElement(xpath(".//a[text()=\"Холодильники\"]")).click();
        List<WebElement> frides = webDriver.findElements(xpath(".//a[text()=\"добавить в сравнение        \"]"));
        frides.get(0).click();
        frides.get(1).click();
        frides.get(2).click();
        frides.get(3).click();
        webDriver.findElement(xpath(".//a[text()=\"Сравнить        \"]")).click();
        webDriver.findElement(xpath(".//a[text()=\"удалить сравнение                \"]")).click();
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
        assertEquals(true, webDriver.getCurrentUrl().equals("https://pn.com.ua/ct/2163/"));
    }

    @Test
    void test_6() throws InterruptedException {
        webDriver.get("https://pn.com.ua/");
        WebElement search = webDriver.findElement(xpath(".//input[@placeholder=\"Найти товар в Харькове\"]"));
        String searchingPhrase = "Samsung";
        search.sendKeys(searchingPhrase);
        search.submit();
        Thread.sleep(500);
        webDriver.findElement(xpath(".//a[text()=\"Смартфоны Samsung\"]")).click();
        List<WebElement> goodsNames = webDriver.findElements(xpath(".//div[@class=\"catalog-block-head\"]"));
        for(WebElement element : goodsNames){
            assertEquals(true, element.getText().startsWith(searchingPhrase));
        }
    }
}

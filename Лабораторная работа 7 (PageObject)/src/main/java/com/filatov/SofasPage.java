package com.filatov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class SofasPage {
    private WebDriver webDriver;
    @FindBy(xpath = ".//*[@id='producers-filter-block']/div[3]/span[3]/a")
    private WebElement amf;

    public SofasPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getSofasNames(){
        amf.click();
        List<WebElement> sofasNames = webDriver.findElements(By.xpath(".//li[*]/article/div[2]/div[1]/a"));
        List<String> sofasStringNames = new LinkedList<>();
        for(WebElement sofaName : sofasNames){
            sofasStringNames.add(sofaName.getText());
        }

        return sofasStringNames;
    }
}

package com.filatov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver webDriver;
    @FindBy(xpath=".//*[@id='column-center']/section/div[5]/ul/li[1]/a")
    private WebElement sofas;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public SofasPage choiceSofas(){
        sofas.click();
        return new SofasPage(webDriver);
    }
}

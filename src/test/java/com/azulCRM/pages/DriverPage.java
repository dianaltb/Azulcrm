package com.azulCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DriverPage extends BasePage{


    @FindBy(xpath = "//div[@id='top_menu_id_docs']//span[@class='main-buttons-item-text-title']")
    public List<WebElement> driverPageModules;
}

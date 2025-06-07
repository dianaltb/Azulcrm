package com.azulCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class EmployeePage extends BasePage{

    @FindBy(xpath = "//div[@id='top_menu_id_company']//span[@class='main-buttons-item-text-title']\n")
    public List<WebElement> modulesList;

    @FindBy(xpath = "//div[contains(@class,'main-buttons-item-active')]//span[@class='main-buttons-item-text-title']")
    public WebElement selectedTab;
}

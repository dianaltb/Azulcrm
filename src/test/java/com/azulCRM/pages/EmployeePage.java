package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeePage extends BasePage{

    public EmployeePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@id='top_menu_id_company']//span[@class='main-buttons-item-text-title']\n")
    public List<WebElement> modulesList;

    @FindBy(xpath = "//div[contains(@class,'main-buttons-item-active')]//span[@class='main-buttons-item-text-title']")
    public WebElement selectedTab;


}

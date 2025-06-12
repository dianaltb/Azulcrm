package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompanyPage extends BasePage {
public CompanyPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}
    @FindBy(xpath = "//div[@id='top_menu_id_about']//span[@class='main-buttons-item-text']")
    public List<WebElement> moduleList;
}

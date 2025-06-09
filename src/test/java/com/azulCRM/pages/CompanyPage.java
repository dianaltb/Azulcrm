package com.azulCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends BasePage {

@FindBy(xpath = "//div[@id='top_menu_id_about']//div[@class='main-buttons-item main-buttons-item-active']")
    public List<WebElement> modulesList;







}

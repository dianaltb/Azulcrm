package com.azulCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage{
    public ProfilePage(){
        super();
    }

    @FindBy(xpath = "//a[contains(@class, 'profile-menu-item')]")
    public List<WebElement> options;

    @FindBy(xpath = "//span[@id='pagetitle']")
    public WebElement emailTab;
}

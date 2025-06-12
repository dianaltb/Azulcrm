package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BasePage {
    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(@class, 'profile-menu-item')]")
    public List<WebElement> options;

    @FindBy(xpath = "//span[@id='pagetitle']")
    public WebElement emailTab;
}

package com.azulCRM.pages;

import com.azulCRM.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

    @FindBy(css = "img[width='32']")
    public WebElement profileIcon;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutLink;


    public void logout(){
        profileIcon.click();
        BrowserUtils.sleep(2);
        logoutLink.click();
    }
}

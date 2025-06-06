package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='user-block']")
    public WebElement userBlock;

    @FindBy(xpath = "//span[.='My Profile']")
    public WebElement myProfile;

    @FindBy(xpath = "//a[@title='Activity Stream']")
    public WebElement activityStreamTab;

    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeesTab;

}

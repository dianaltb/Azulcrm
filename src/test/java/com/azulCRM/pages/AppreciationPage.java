package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppreciationPage{

    public AppreciationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='More']")
    public WebElement moreButton;


    @FindBy(xpath = "//span[.='Appreciation']")
    public WebElement dropdownElement;

    @FindBy(xpath = "//div[@class='menu-popup-items']")
    public WebElement popUpMenu;




    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement textBox;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//div[.='appreciation']")
    public WebElement text;

    @FindBy(xpath = "//a[@id='bx-grat-tag']")
    public WebElement recipientDropdown;

    @FindBy(xpath = "//div[.='helpdesk22@cydeo.com']")
    public WebElement helpdesk22Dropdown;

    @FindBy(xpath = "//div[.='appreciation']")
    public WebElement sentMessage;
}


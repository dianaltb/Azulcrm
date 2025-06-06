package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppreciationPage extends BasePage{

    @FindBy(id = "feed-add-post-form-link-text")
    public WebElement moreButton;

    @FindBy(xpath = "(//span[.='Appreciation'])[2]")
    public WebElement appreciationButton;

    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadField;

    @FindBy(xpath = "//span[contains(@id,'check-in-text-n')]") //dynamic element
    public WebElement insertInTextButton;

    @FindBy(css = ".del-but")
    public WebElement cancelButtonX;


}

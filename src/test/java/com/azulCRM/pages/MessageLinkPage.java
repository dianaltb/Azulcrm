package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageLinkPage extends BasePage {

    public MessageLinkPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Activity Stream']")
    public WebElement activityStreamBtn;

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']")
    public WebElement messageBtn;

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement addLink;


    @FindBy(xpath = "//input[@placeholder='Link text']")
    public WebElement textInput;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    public WebElement urlInput;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendBtn;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveBtn;

    @FindBy(id = "feed-post-contentview-BLOG_POST-217")
    public WebElement sentLink;
}

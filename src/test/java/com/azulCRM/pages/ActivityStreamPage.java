package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import com.azulCRM.utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActivityStreamPage extends BasePage{
    private final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @FindBy(xpath = "(//span[contains(@id, 'message')])[2]")
    public WebElement messageTab;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement textFrame;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelButton;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement titleError;

    @FindBy(xpath = "//span[contains(text(), 'at least one person')]")
    public WebElement recipientError;

    @FindBy(xpath = "//span[@data-id='UA']")
    public WebElement messageDeliveryTab;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement removeDefaultRecipients;

    public By listOfMessages = By.xpath("//div[@class='feed-post-text-block-inner-inner']");

    public void typeMessage(String message){
        messageTab.click();
        Waits.waitAndSwitchToFrame(textFrame);
        By bodyLocator = By.tagName("body");
        WebElement bodyInFrame = wait.until(ExpectedConditions.presenceOfElementLocated(bodyLocator));
        bodyInFrame.click();
        bodyInFrame.sendKeys(message);
        Driver.getDriver().switchTo().defaultContent();
    }

    public boolean isMessageSent(String expected){
        List<WebElement> list = Driver.getDriver()
                .findElements(listOfMessages);
        for(WebElement sent : list){
            if(sent.getText().equals(expected)){
                return true;
            }
        }
        return false;
    }
}

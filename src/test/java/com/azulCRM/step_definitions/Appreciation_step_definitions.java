package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Appreciation_step_definitions extends ActivityStreamPage {
ActivityStreamPage activityStreamPage = new ActivityStreamPage();

    @Given("user navigates to appreciation")
    public void user_navigates_to_appreciation() {
        activityStreamPage.moreButton.click();
        activityStreamPage.appreciationButton.click();
        BrowserUtils.sleep(3);

    }

    @And("user types in an {string} message")
    public void userTypesInAnMessage(String message) {

        typeMessage(message);
/*
        Driver.getDriver().switchTo().frame(0);
        BrowserUtils.sleep(3);
        activityStreamPage.textBox.sendKeys(message);
        BrowserUtils.sleep(3);
        Driver.getDriver().switchTo().defaultContent();
        BrowserUtils.sleep(3);


 */
    }


    @And("user sends the appreciation message")
    public void userSendsTheAppreciationMessage() {
        activityStreamPage.recipientDropdown.click();
        activityStreamPage.helpdesk22Dropdown.click();
        activityStreamPage.sendButton.click();
    }

    @Then("verifies if message is displayed")
    public void verifiesIfMessageIsDisplayed() {

WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
WebElement sentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='appreciation']")));
Assert.assertTrue(sentMessage.isDisplayed());


    }

    @And("user types in an {string} emptyMessage")
    public void userTypesInAnEmptyMessage(String emptyMessage) {
        typeMessage(emptyMessage);
    }

    @And("user sends the emptyMessage")
    public void userSendsTheEmptyMessage() {
        activityStreamPage.sendButton.click();

    }

    @Then("verifies if error message is displayed")
    public void verifiesIfErrorMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='The message title is not specified']")));
        Assert.assertTrue(errorMessage.isDisplayed());

    }


    @And("user cancels sending the appreciation message")
    public void userCancelsSendingTheAppreciationMessage() {
        activityStreamPage.cancelButton.click();

    }
}

package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
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

public class Appreciation_Step_Defs extends ActivityStreamPage {
    private final ActivityStreamPage ACTIVE = new ActivityStreamPage();

    @Given("user navigates to appreciation")
    public void user_navigates_to_appreciation() {
        ACTIVE.moreButton.click();
        ACTIVE.appreciationButton.click();
    }

    @And("user types in an {string} message")
    public void userTypesInAnMessage(String message) {
        ACTIVE.typeMessage(message);
    }

    @And("user sends the appreciation message")
    public void userSendsTheAppreciationMessage() {
        ACTIVE.recipientDropdown.click();
        ACTIVE.helpdesk22Dropdown.click();
        ACTIVE.sendButton.click();
    }

    @Then("verifies if message is displayed")
    public void verifiesIfMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement sentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='appreciation']")));
        Assert.assertTrue(sentMessage.isDisplayed());
    }

    @And("user types in an {string} emptyMessage")
    public void userTypesInAnEmptyMessage(String emptyMessage) {
        ACTIVE.typeMessage(emptyMessage);
    }

    @And("user sends the emptyMessage")
    public void userSendsTheEmptyMessage() {
        ACTIVE.sendButton.click();
    }

    @Then("verifies if error message is displayed")
    public void verifiesIfErrorMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='The message title is not specified']")));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @And("user cancels sending the appreciation message")
    public void userCancelsSendingTheAppreciationMessage() {
        ACTIVE.cancelButton.click();
    }
}

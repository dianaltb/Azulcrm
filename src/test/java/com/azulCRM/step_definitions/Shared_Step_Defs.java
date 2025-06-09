package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Shared_Step_Defs {
    private final ActivityStreamPage ACTIVITY = new ActivityStreamPage();

    @Then("user sees the error message {string}")
    public void user_sees_the_error_message(String error) {
        By locator = By.xpath("//span[@class='feed-add-info-text']");
        WebElement errorMessage = Waits.waitVisibilityOfElement(locator);
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), error);
    }

    @When("user clicks the send button")
    public void user_clicks_the_send_button() {
        By locator = By.xpath("//button[@id='blog-submit-button-save']");
        WebElement sendButton = Waits.waitVisibilityOfElement(locator);
        sendButton.click();
    }
}

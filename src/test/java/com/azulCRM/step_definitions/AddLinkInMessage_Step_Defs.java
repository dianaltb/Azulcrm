package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddLinkInMessage_Step_Defs {
    private ActivityStreamPage ACTIVITY;

    @Before
    public void setUpPages() {
        ACTIVITY = new ActivityStreamPage();
    }

    @When("user clicks on link button")
    public void user_clicks_on_link_button() {
        ACTIVITY.addLink.click();
    }

    @When("user enters {string} in text box")
    public void user_enters_in_text_box(String linkText) {
        ACTIVITY.textInput.sendKeys(linkText);
    }

    @When("user enters {string} in URL box")
    public void user_enters_in_url_box(String linkUrl) {
        ACTIVITY.urlInput.sendKeys(linkUrl);
    }

    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        BrowserUtils.sleep(1);
        ACTIVITY.saveBtn.click();
        //jun13
        BrowserUtils.sleep(1);
        ACTIVITY.sendButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("user sees the {string} as a link.")
    public void user_sees_the_as_a_link(String linkText) {
        String expectedLinkText = "google search page";
        Assert.assertTrue(linkText.contains(expectedLinkText));

    }

    //jun13
    @When("user clicks on Send button")
    public void user_clicks_on_send_button() {
        BrowserUtils.sleep(1);
        ACTIVITY.sendButton.click();
        BrowserUtils.sleep(2);
    }

    //jun13
    @Then("user sees the {string} as a clickable link.")
    public void user_sees_the_as_a_clickable_link(String linkText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
        System.out.println(linkText);
        ACTIVITY.sentLink.click();

    }
}

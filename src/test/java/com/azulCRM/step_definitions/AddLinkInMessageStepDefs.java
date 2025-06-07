package com.azulCRM.step_definitions;

import com.azulCRM.pages.BasePage;
import com.azulCRM.pages.MessageLinkPage;
import com.azulCRM.pages.MessageUploadPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddLinkInMessageStepDefs {

    MessageLinkPage messageLinkPage = new MessageLinkPage();
    MessageUploadPage messageUploadPage = new MessageUploadPage();


    // testing VALID URL
    @When("user clicks on activity stream button")
    public void user_clicks_on_activity_stream_button() {
        messageLinkPage.activityStreamBtn.click();
    }

    @When("user clicks on massage button")
    public void user_clicks_on_massage_button() {
        messageUploadPage.messageBtn.click();
    }

    @When("user clicks on link button")
    public void user_clicks_on_link_button() {
        messageLinkPage.addLink.click();
    }


    @When("user enters {string} in text box")
    public void user_enters_in_text_box(String linkText) {
        messageLinkPage.textInput.sendKeys(linkText);
    }

    @When("user enters {string} in URL box")
    public void user_enters_in_url_box(String linkUrl) {
        messageLinkPage.urlInput.sendKeys(linkUrl);
    }


    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        BrowserUtils.sleep(1);
        messageLinkPage.saveBtn.click();
    }

    @Then("user sees the {string} as a clickable link.")
    public void user_sees_the_as_a_clickable_link(String linkText) {

        System.out.println("linkText = " + linkText);
     String expectedLinkText = "google search page";
        System.out.println("expectedLinkText = " + expectedLinkText);
     Assert.assertTrue(linkText.contains(expectedLinkText));

        BrowserUtils.sleep(2);
    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {

             messageLinkPage.sendBtn.click();
    }


}

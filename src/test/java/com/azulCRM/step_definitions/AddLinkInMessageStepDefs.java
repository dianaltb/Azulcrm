package com.azulCRM.step_definitions;

import com.azulCRM.pages.MessageLinkPage;
import com.azulCRM.pages.MessageUploadPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddLinkInMessageStepDefs {
    WebDriver driver;
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
        BrowserUtils.sleep(2);
        messageLinkPage.saveBtn.click();

    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {

        messageLinkPage.sendBtn.click();
    }

    @Then("user sees the {string} as a clickable link.")
    public void user_sees_the_as_a_clickable_link(String clickableText) {

    }




}

package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SendMessage_Step_Defs {
    private ActivityStreamPage ACTIVITY;
    private String testMessage;

    @Before
    public void setUpPages() {
        ACTIVITY = new ActivityStreamPage();
        testMessage = "Test";
    }

    //1st Outline
    @When("user clicks on the message tab")
    public void user_clicks_on_the_message_tab() {
        Waits.waitClickable(ACTIVITY.messageTab);
        ACTIVITY.messageTab.click();
    }
    @When("user types any text, but removes All employees from recipients")
    public void user_types_any_text_but_removes_all_employees_from_recipients() {
        ACTIVITY.typeMessage(testMessage);
        Waits.waitClickable(ACTIVITY.removeDefaultRecipients);
        ACTIVITY.removeDefaultRecipients.click();
        Waits.waitClickable(ACTIVITY.sendButton);
        ACTIVITY.sendButton.click();
    }
    @Then("user adds recipients back and fills all the mandatory fields")
    public void user_adds_recipients_back_and_fills_all_the_mandatory_fields() {
        testMessage = " Egor";
        ACTIVITY.typeMessage(testMessage);
        Waits.waitClickable(ACTIVITY.sendButton);
        ACTIVITY.sendButton.click();
    }
    @Then("user is able to send a message")
    public void user_is_able_to_send_a_message() {
        Waits.waitElementLocated(ACTIVITY.listOfMessages);
        Assert.assertTrue(ACTIVITY.isMessageSent(testMessage));
    }

    //2nd Outline
    @Then("user sees the All employees in the message delivery by default")
    public void user_sees_the_all_employees_in_the_message_delivery_by_default() {
        Waits.waitVisible(ACTIVITY.messageDeliveryTab);
        Assert.assertTrue(ACTIVITY.messageDeliveryTab.isDisplayed());
    }

    //3rd Outline
    @When("user fills all the mandatory fields")
    public void user_fills_all_the_mandatory_fields() {
        testMessage = "Another message";
        ACTIVITY.typeMessage(testMessage);
    }
    @Then("user is able to cancel the message before sending")
    public void user_is_able_to_cancel_the_message_before_sending() {
        Waits.waitClickable(ACTIVITY.cancelButton);
        ACTIVITY.cancelButton.click();
        Waits.waitElementLocated(ACTIVITY.listOfMessages);
        Assert.assertFalse(ACTIVITY.isMessageSent(testMessage));
    }
}

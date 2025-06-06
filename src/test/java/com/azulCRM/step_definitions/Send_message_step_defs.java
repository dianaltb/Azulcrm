package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Send_message_step_defs {
    private final LoginPage LOGIN = new LoginPage();
    private final ActivityStreamPage ACTIVITY = new ActivityStreamPage();
    private String testMessage = "Egor test";

    //1st Outline
    @Given("user is logged into main page as {string}")
    public void user_is_logged_into_main_page_as(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        LOGIN.login(userType);
    }
    @When("user clicks on the message tab")
    public void user_clicks_on_the_message_tab() {
        Waits.waitClickable(ACTIVITY.messageTab);
        ACTIVITY.messageTab.click();
    }
    @When("user doesn't type any text and press send button")
    public void user_doesn_t_type_any_text_and_press_send_button() {
        ACTIVITY.sendButton.click();
    }
    @Then("user sees the title error message {string}")
    public void user_sees_the_title_error_message(String error) {
        Assert.assertTrue(ACTIVITY.titleError.isDisplayed());
        Assert.assertEquals(ACTIVITY.titleError.getText(), error);
    }
    @When("user types any text, but removes All employees from recipients")
    public void user_types_any_text_but_removes_all_employees_from_recipients() {
        ACTIVITY.typeMessage(testMessage);
        Waits.waitClickable(ACTIVITY.removeDefaultRecipients);
        ACTIVITY.removeDefaultRecipients.click();
        Waits.waitClickable(ACTIVITY.sendButton);
        ACTIVITY.sendButton.click();
    }
    @Then("user sees the recipient error message {string}")
    public void user_sees_the_recipient_error_message(String error) {
        Waits.waitVisible(ACTIVITY.recipientError);
        Assert.assertTrue(ACTIVITY.recipientError.isDisplayed());
        Assert.assertEquals(ACTIVITY.recipientError.getText(), error);
    }
    @Then("user adds recipients back and fills all the mandatory fields")
    public void user_adds_recipients_back_and_fills_all_the_mandatory_fields() {
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

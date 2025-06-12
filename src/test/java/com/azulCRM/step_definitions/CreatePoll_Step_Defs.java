package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;

import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class CreatePoll_Step_Defs {
    public ActivityStreamPage ACTIVITY;
    String testMessage;

    @Before
    public void setUpPages() {
        ACTIVITY = new ActivityStreamPage();
        testMessage = "Diana Test";
    }

    @Given("user clicks on the Poll tab")
    public void userClicksOnThePollTab() {
        Waits.waitClickable(ACTIVITY.messageTab);
        ACTIVITY.pollTab.click();
    }

    @When("user enters text as the message title")
    public void user_enters_text_as_the_message_title() {
        ACTIVITY.typeMessage(testMessage);
    }

    @When("user types question text in Question field")
    public void user_types_question_text_in_question_field() {
        ACTIVITY.questionField.sendKeys(testMessage);
    }


    @Then("user should be able to create poll")
    public void user_should_be_able_to_create_poll() {
        Waits.waitElementLocated(ACTIVITY.listOfMessages);
        Assert.assertTrue(ACTIVITY.isMessageSent(testMessage));
    }

    @Then("user clicks on “Allow multiple choice” checkbox")
    public void user_clicks_on_allow_multiple_choice_checkbox() {
        ACTIVITY.multipleChoiceBox.click();
        Assert.assertTrue(ACTIVITY.multipleChoiceBox.isSelected());
    }




    @And("user types question {string} text in Question field")
    public void userTypesQuestionTextInQuestionField(String testMessage) {
        ACTIVITY.answerField.clear();
        ACTIVITY.answerField.sendKeys(testMessage);
    }

    @When("user adds answer text in Answer field")
    public void userAddsAnswerTextInAnswerField() {
        ACTIVITY.answerField.sendKeys(testMessage);
    }


}


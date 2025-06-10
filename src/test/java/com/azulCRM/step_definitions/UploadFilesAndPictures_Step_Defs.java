package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import java.nio.file.Paths;

public class UploadFilesAndPictures_Step_Defs {
    private ActivityStreamPage ACTIVITY;

    @Before
    public void setUpPages() {
        ACTIVITY = new ActivityStreamPage();
    }

    @When("user clicks on {string} dropdown")
    public void user_clicks_on_dropdown(String moreButton) {
        ACTIVITY.moreButton.click();
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String Appreciation) {
        ACTIVITY.appreciationButton.click();
    }

    @When("user clicks on {string} icon")
    public void user_clicks_on_icon(String uploadFile) {
        ACTIVITY.uploadFileButton.click();
    }

    @Then("user uploads a file {string}")
    public void user_Uploads_A_File(String fileName) {
        //dynamic path
        String filePath = Paths.get("src", "test", "resources", "upload_files", fileName).toAbsolutePath().toString();
        ACTIVITY.uploadField.sendKeys(filePath);
    }

    @Then("user sees the file is attached")
    public void user_Sees_The_File_Is_Attached() {
        Assert.assertTrue(ACTIVITY.insertInTextButton.isDisplayed());
    }

    @When("user clicks {string} button")
    public void user_clicks_button(String string) {
        ACTIVITY.insertInTextButton.click();
    }

    @Then("user should see {string} displayed on the button")
    public void user_should_see_displayed_on_the_button(String text) {
        Assert.assertEquals(ACTIVITY.insertInTextButton.getText(), text);
    }

    @When("user clicks on x to remove the file")
    public void user_Clicks_On_X_To_Remove_The_File() {
        ACTIVITY.deleteButton.click();
    }

    @Then("user confirms file is removed before sending text")
    public void user_Confirms_File_Is_Removed_Before_Sending_Text() {
        try {
            Assert.assertFalse(ACTIVITY.insertInTextButton.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
}

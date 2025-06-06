package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;

public class MessageUploadStep_Def {
    private ActivityStreamPage ACTIVITY;

    @Before(order = 1)
    public void setUpPages() {
        ACTIVITY = new ActivityStreamPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user clicks on message button in the top left corner")
    public void user_clicks_on_message_button_in_the_top_left_corner() {
        ACTIVITY.messageBtn.click();
    }
    @When("user clicks on upload files icon")
    public void user_clicks_on_upload_files_icon() {
        ACTIVITY.uploadFileButton.click();
    }
}

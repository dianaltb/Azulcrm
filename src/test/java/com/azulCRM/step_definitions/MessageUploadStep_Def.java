package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import io.cucumber.java.en.When;

public class MessageUploadStep_Def {
    private final ActivityStreamPage ACTIVITY = new ActivityStreamPage();


    @When("user clicks on message button in the top left corner")
    public void user_clicks_on_message_button_in_the_top_left_corner() {
        ACTIVITY.messageBtn.click();

    }
    @When("user clicks on upload files icon")
    public void user_clicks_on_upload_files_icon() {
        ACTIVITY.uploadFileButton.click();

    }

}

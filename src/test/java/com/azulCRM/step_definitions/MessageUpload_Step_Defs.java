package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;

public class MessageUpload_Step_Defs {
    private ActivityStreamPage ACTIVITY;

    @Before
    public void setUpPages() {
        ACTIVITY = new ActivityStreamPage();
    }

    @When("user clicks on upload files icon")
    public void user_clicks_on_upload_files_icon() {
        ACTIVITY.uploadFileButton.click();
    }
}

package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;

public class UploadFilesAndPictures_Step_Defs {
    private ActivityStreamPage ACTIVITY;

    @Before(order = 1)
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
}

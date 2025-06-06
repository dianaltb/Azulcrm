package com.azulCRM.step_definitions;

import com.azulCRM.pages.MessageUploadPage;
import io.cucumber.java.en.When;

public class MessageUploadStep_Def {
    MessageUploadPage messageUploadPage = new MessageUploadPage();


    @When("user clicks on message button in the top left corner")
    public void user_clicks_on_message_button_in_the_top_left_corner() {
    messageUploadPage.messageBtn.click();

    }
    @When("user clicks on upload files icon")
    public void user_clicks_on_upload_files_icon() {
       // messageUploadPage.uploadFileButton.click();

    }

}

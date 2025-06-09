package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;

public class Shared_Step_Defs {
    private ActivityStreamPage ACTIVITY;
    private LoginPage LOGIN;

    @Before
    public void setupPages(){
        ACTIVITY = new ActivityStreamPage();
        LOGIN = new LoginPage();
    }
    //USED ON: All the pages
    @When("user logs in as {string}")
    public void userLogsInAs(String user) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Waits.waitTitle("Authorization");
        BrowserUtils.verifyTitle("Authorization");
        //send username and password and login
        LOGIN.login(user);
    }
    //USED ON: SendMessage
    @Then("user sees the error message {string}")
    public void user_sees_the_error_message(String error) {
        By locator = By.xpath("//span[@class='feed-add-info-text']");
        WebElement errorMessage = Waits.waitVisibilityOfElement(locator);
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), error);
    }
    //USED ON: SendMessage, AddLinkInMessage,
    @When("user clicks the send button")
    public void user_clicks_the_send_button() {
        By locator = By.xpath("//button[@id='blog-submit-button-save']");
        WebElement sendButton = Waits.waitVisibilityOfElement(locator);
        Waits.waitClickable(sendButton);
        sendButton.click();
    }
    //USED ON: MessageUpload, UploadFilesAndPictures
    @Then("user uploads a file {string}")
    public void user_Uploads_A_File(String fileName) {
        //dynamic path
        String filePath = Paths.get("src", "test", "resources", "upload_files", fileName).toAbsolutePath().toString();
        ACTIVITY.uploadField.sendKeys(filePath);
    }
    //USED ON: MessageUpload, UploadFilesAndPictures
    @Then("user sees the file is attached")
    public void user_Sees_The_File_Is_Attached() {
        Assert.assertTrue(ACTIVITY.insertInTextButton.isDisplayed());
    }
    //USED ON: MessageUpload, UploadFilesAndPictures
    @Then("user should see {string} displayed on the button")
    public void user_should_see_displayed_on_the_button(String text) {
        Assert.assertEquals(ACTIVITY.insertInTextButton.getText(), text);
    }
    //USED ON: MessageUpload, UploadFilesAndPictures
    @When("user clicks on x to remove the file")
    public void user_Clicks_On_X_To_Remove_The_File() {
        ACTIVITY.deleteButton.click();
    }
    //USED ON: MessageUpload, UploadFilesAndPictures
    @Then("user confirms file is removed before sending text")
    public void user_Confirms_File_Is_Removed_Before_Sending_Text() {
        try {
            Assert.assertFalse(ACTIVITY.insertInTextButton.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
    //USED ON: MessageUpload, UploadFilesAndPictures
    @When("user clicks {string} button")
    public void user_clicks_button(String string) {
        ACTIVITY.insertInTextButton.click();
    }
}

package com.azulCRM.step_definitions;

import com.azulCRM.pages.AppreciationPage;
import com.azulCRM.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;

public class UploadFilesAndPictures_StepDefinitions {

    AppreciationPage appreciationPage = new AppreciationPage();


    @When("user clicks on {string} dropdown")
    public void user_clicks_on_dropdown(String moreButton) {

        appreciationPage.moreButton.click();

    }


    @When("user clicks on {string} button")
    public void user_clicks_on_button(String Appreciation) {

        appreciationPage.appreciationButton.click();

    }

    @When("user clicks on {string} icon")
    public void user_clicks_on_icon(String uploadFile) {

        appreciationPage.uploadFileButton.click();

    }


    @Then("user uploads a file {string}")
    public void user_Uploads_A_File(String fileName) {

        //dynamic path
        String filePath = Paths.get("src", "test", "resources", "uploadFiles", fileName).toAbsolutePath().toString();
        appreciationPage.uploadField.sendKeys(filePath);

    }

    @Then("user sees the file is attached")
    public void user_Sees_The_File_Is_Attached() {

        Assert.assertTrue(appreciationPage.insertInTextButton.isDisplayed());
    }


    @When("user clicks {string} button")
    public void user_clicks_button(String string) {

        appreciationPage.insertInTextButton.click();

    }

    @Then("user should see {string} displayed on the button")
    public void user_should_see_displayed_on_the_button(String text) {

        Assert.assertEquals(appreciationPage.insertInTextButton.getText(), text);
    }


    @When("user clicks on x to remove the file")
    public void user_Clicks_On_X_To_Remove_The_File() {

        appreciationPage.cancelButtonX.click();
    }

    @Then("user confirms file is removed before sending text")
    public void user_Confirms_File_Is_Removed_Before_Sending_Text() {

        try {
            Assert.assertFalse( appreciationPage.insertInTextButton.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue( true);
        }

    }
}

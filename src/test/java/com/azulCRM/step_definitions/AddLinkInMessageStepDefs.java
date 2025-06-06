package com.azulCRM.step_definitions;

import com.azulCRM.pages.MessagePage;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddLinkInMessageStepDefs {
    WebDriver driver;
    MessagePage messagePage = new MessagePage();





    // testing VALID URL
    @When("user clicks on activity stream button")
    public void user_clicks_on_activity_stream_button() {
        messagePage.activityStreamBtn.click();
    }

    @When("user clicks on massage button")
    public void user_clicks_on_massage_button() {
        messagePage.messageBtn.click();
    }

    @When("user clicks on link button")
    public void user_clicks_on_link_button() {
        messagePage.addLink.click();
    }

    @Then("user sees the link window")
    public void user_sees_the_link_window() {
        Driver.getDriver().switchTo().frame("bx-admin-prefix");
    }


    @When("user enters {string} in text box")
    public void user_enters_in_text_box(String linkText) {
       messagePage.textInput.sendKeys("google");
    }

    @When("user enters {string} in URL box")
    public void user_enters_in_url_box(String linkUrl) {
        messagePage.urlInput.sendKeys(linkUrl);
    }

    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        messagePage.saveBtn.click();

    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {
        driver.switchTo().defaultContent();
        messagePage.sendBtn.click();
    }

    @Then("user sees the {string} as a clickable link.")
    public void user_sees_the_as_a_clickable_link(String linkUrl) {

    }


    //testing INVALID URL


}

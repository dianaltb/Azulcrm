package com.azulCRM.step_definitions;

import com.azulCRM.pages.ProfilePage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Profile_step_definitions {
    ProfilePage PROFILE;

    @Before(order = 1)
    public void setUpPages() {
        PROFILE = new ProfilePage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user clicks on his email in the top right corner")
    public void user_clicks_on_his_email_in_the_top_right_corner() {
        PROFILE.userBlock.click();
    }

    @And("user clicks on the My Profile from the dropdown")
    public void user_clicks_on_the_my_profile_from_the_dropdown() {
        PROFILE.myProfile.click();
    }

    @Then("user is able to see the following options")
    public void user_is_able_to_see_the_following_options(List<String> expected) {
        for (WebElement option : PROFILE.options) {
            Assert.assertTrue(option.isDisplayed());
        }
        List<String> actual = BrowserUtils.getStringList(PROFILE.options);
        Assert.assertEquals(expected, actual);
    }

    @Then("user is able to see his {string} under the General tab")
    public void user_is_able_to_see_his_under_the_general_tab(String email) {
        Assert.assertTrue(PROFILE.emailTab.isDisplayed());
        Assert.assertEquals(PROFILE.emailTab.getText(), email);
    }
}

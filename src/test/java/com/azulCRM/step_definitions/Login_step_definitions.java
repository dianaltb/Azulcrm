package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_step_definitions {
    private LoginPage LOGIN;

    @Before
    public void setUpPages(){
        LOGIN = new LoginPage();
    }

    @When("user logs in as {string}")
    public void userLogsInAs(String user) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Waits.waitTitle("Authorization");
        BrowserUtils.verifyTitle("Authorization");
    //send username and password and login
        LOGIN.login(user);
    }

    @Then("user should be able to see {string} as page title")
    public void userShouldBeAbleToSeeAsPageTitle(String title) {
        Waits.waitTitle(title);
        BrowserUtils.verifyTitle(title);
    }
}


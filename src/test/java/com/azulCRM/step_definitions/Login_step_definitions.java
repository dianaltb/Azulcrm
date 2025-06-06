package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_step_definitions {
    LoginPage LOGIN;

    @Before(order = 1)
    public void setup(){
        LOGIN = new LoginPage();
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Waits.waitTitle("Authorization");
        BrowserUtils.verifyTitle("Authorization");
    }

    @When("user logs in as {string}")
    public void userLogsInAs(String user) {
    //send username and password and login
        LOGIN.login(user);
    }

    @Then("user should be able to see {string} as page title")
    public void userShouldBeAbleToSeeAsPageTitle(String title) {
        Waits.waitTitle(title);
        BrowserUtils.verifyTitle(title);
    }
}


package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_step_definitions {
    LoginPage loginPage = new LoginPage();
    private String expectedTitle;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Login to app in Before Method");
        expectedTitle = "Authorization";
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("user logs in as {string}")
    public void userLogsInAs(String user) {
//send username and password and login
        loginPage.login(user);
    }

    @Then("user should be able to see {string} as page title")
    public void userShouldBeAbleToSeeAsPageTitle(String title) {
        expectedTitle = title;
        BrowserUtils.verifyTitle(expectedTitle);
    }
}


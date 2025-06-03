package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_step_definitions {
    private final LoginPage PAGE = new LoginPage();
    private String expectedTitle;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        expectedTitle = "Authorization";
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("user logs in as {string}")
    public void userLogsInAs(String user) {
        System.out.println("Logging in as a " + user);
    }

    @And("user enters {string} and {string}")
    public void user_enters_and(String login, String password) {
        PAGE.login(login, password);
    }

    @Then("user should see {string} in page URL")
    public void user_should_see_in_page_url(String keyWord) {
        expectedTitle = keyWord;
        BrowserUtils.verifyTitle(expectedTitle);
    }
}


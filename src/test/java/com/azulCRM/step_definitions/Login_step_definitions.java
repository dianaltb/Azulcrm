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

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //based on input enter that user information
        String username = "";
        String password = "";

        if (userType.equalsIgnoreCase("hr")) {
            username = ConfigurationReader.getProperty("hr_username");
            password = ConfigurationReader.getProperty("hr_password");
        } else if (userType.equalsIgnoreCase("help_desk")) {
            username = ConfigurationReader.getProperty("help_desk_username");
            password = ConfigurationReader.getProperty("help_desk_password");
        } else if (userType.equalsIgnoreCase("marketing")) {
            username = ConfigurationReader.getProperty("marketing_username");
            password = ConfigurationReader.getProperty("marketing_password");
        }

        //send username and password and login


        new LoginPage().login(username, password);

    }

    @Given("the user logged in with username as {string} and password as {string}")
    public void the_user_logged_in_with_username_as_and_password_as(String username, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @Then("user should see {string} in page URL")
    public void user_should_see_in_page_url(String keyWord) {
        expectedTitle = keyWord;
        BrowserUtils.verifyTitle(expectedTitle);
    }
}


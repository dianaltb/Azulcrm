package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Step_Defs {
    //  private final LoginPage LOGIN = new LoginPage();//change
    LoginPage loginPage;

    public Login_Step_Defs() {
        loginPage = new LoginPage();
    }

    @When("user logs in as {string}")
    public void userLogsInAs(String user) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Waits.waitTitle("Authorization");
        BrowserUtils.verifyTitle("Authorization");
        loginPage.login(user);
    }

    @Then("user should be able to see {string} as page title")
    public void userShouldBeAbleToSeeAsPageTitle(String title) {
        Waits.waitTitle(title);
        BrowserUtils.verifyTitleContains(title);
    }
}


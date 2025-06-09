package com.azulCRM.step_definitions;

import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.en.Then;


public class Login_Step_Defs {

    @Then("user should be able to see {string} as page title")
    public void userShouldBeAbleToSeeAsPageTitle(String title) {
        Waits.waitTitle(title);
        BrowserUtils.verifyTitle(title);
    }
}


package com.azulCRM.step_definitions;

import com.azulCRM.pages.CompanyPage;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

public class CompanyPage_StepDefinitions {
    private CompanyPage COMPANY;
    private Actions actions;

    @Before
    public void seUpPages(){
        COMPANY = new CompanyPage();
        actions = new Actions(Driver.getDriver());
    }

    @When("the user clicks the Company page")
    public void the_user_clicks_the_company_page() {
        COMPANY.companyTab.click();

    }
    @Then("the following modules should be visible on the page:")
    public void the_following_modules_should_be_visible_on_the_page() {


    }
}

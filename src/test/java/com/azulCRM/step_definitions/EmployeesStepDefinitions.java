package com.azulCRM.step_definitions;

import com.azulCRM.pages.BasePage;
import com.azulCRM.pages.EmployeePage;
import com.azulCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class EmployeesStepDefinitions {
    BasePage basePage = new BasePage();
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String employeeModule) {
        basePage.employeeModule.click();
    }
    EmployeePage employeePage = new EmployeePage();
    @Then("the user should see the following modules on the page:")
    public void the_user_should_see_the_following_modules_on_the_page(List<String> expectedModulList) {
        List<String> actualModules = new ArrayList<>();

        for (WebElement each : employeePage.modulesList) {
            actualModules.add(each.getText().trim());
            System.out.println(each);
        }

        Assert.assertEquals(expectedModulList,actualModules);
    }
    @Then("the {string} module should be selected by default")
    public void the_module_should_be_selected_by_default(String defaultSelected) {

        String actual = employeePage.selectedTab.getText();
        System.out.println("actual = " + actual);
        Assert.assertEquals(defaultSelected, actual);
    }
}

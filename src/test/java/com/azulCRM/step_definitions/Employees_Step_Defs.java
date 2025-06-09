package com.azulCRM.step_definitions;

import com.azulCRM.pages.EmployeePage;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;

public class Employees_Step_Defs {
    private EmployeePage EMPLOYEE;
    private Actions actions;

    @Before
    public void setUpPages() {
        EMPLOYEE = new EmployeePage();
        actions = new Actions(Driver.getDriver());
    }

    @When("the user clicks the Employees module")
    public void the_user_clicks_the_module() {
        EMPLOYEE.employeesTab.click();
    }

    @Then("the user should see the following modules on the page:")
    public void the_user_should_see_the_following_modules_on_the_page(List<String> expectedModulList) {
        List<String> actualModules = new ArrayList<>();
        for (WebElement each : EMPLOYEE.modulesList) {
            actions.moveToElement(each).perform();
            actualModules.add(each.getText().trim());
        }
        Assert.assertEquals(expectedModulList, actualModules);
    }

    @Then("the {string} module should be selected by default")
    public void the_module_should_be_selected_by_default(String defaultSelected) {
        String actual = EMPLOYEE.selectedTab.getText();
        Assert.assertEquals(defaultSelected, actual);
    }
}

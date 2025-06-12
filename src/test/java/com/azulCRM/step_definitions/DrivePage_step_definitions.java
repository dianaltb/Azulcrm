package com.azulCRM.step_definitions;

import com.azulCRM.pages.BasePage;
import com.azulCRM.pages.DriverPage;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class DrivePage_step_definitions {

    DriverPage driverPage = new DriverPage();
    BasePage basePage = new BasePage();

    @When("user clicks on {string}")
    public void user_clicks_on(String drivePageLink) {
        basePage.driveTab.click();
    }

    @Then("user sees following modules:")
    public void user_sees(List<String> expectedModules) {

        Actions actions = new Actions(Driver.getDriver());

        List<String> actualList = new ArrayList<>();

        for (WebElement module : driverPage.driverPageModules) {
            actions.moveToElement(module).perform();
            actualList.add(module.getText());
        }

        Assert.assertEquals(expectedModules,actualList);

    }


}

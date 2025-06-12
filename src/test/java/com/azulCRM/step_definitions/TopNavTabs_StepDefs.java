package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStreamPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import com.azulCRM.utilities.Waits;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TopNavTabs_StepDefs {
    private ActivityStreamPage activityPage;
    private Actions actions;

    @Before
    public void setUpPages() {

        activityPage = new ActivityStreamPage();
        actions = new Actions(Driver.getDriver());
    }

    @When("the user navigates to the Activity Stream page")
    public void the_user_navigates_to_the_activity_stream_page() {
        Waits.waitTitle("Portal");

    }

    @Then("the user should see the following options on the page:")
    public void the_user_should_see_the_following_options_on_the_page(List<String> expectedTabs) {
        List<String> actualTabs = BrowserUtils.getStringList(activityPage.topMenuOptions);
        System.out.println("Top tabs found: " + actualTabs);
        Assert.assertEquals("Top tabs mismatch!", expectedTabs, actualTabs);
    }

    @When("the user clicks the {string} tab")
    public void the_user_clicks_the_tab(String tabName) {
        if (tabName.equalsIgnoreCase("MORE")) {
            BrowserUtils.waitForClickablility(activityPage.moreTab, 5).click();
            // Explicit wait for dropdown menu to appear
            BrowserUtils.waitForVisibility(
                    By.xpath("//div[contains(@class,'menu-popup-items')]"), 20);

        }
    }

    @Then("the user should see the following options under the MORE tab:")
    public void the_user_should_see_the_following_options_under_the_more_tab(List<String> expectedOptions) {
        // locate dynamically after click
        List<WebElement> dropdownElements = Driver.getDriver()
                .findElements(By.xpath("//div[contains(@class,'menu-popup-items')]//span[@class='menu-popup-item-text']"));
        List<String> actualOptions = BrowserUtils.getStringList(dropdownElements);

        System.out.println("Dropdown items found: " + actualOptions);
        Assert.assertEquals("Dropdown options mismatch!", expectedOptions, actualOptions);
    }
}

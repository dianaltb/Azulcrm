package com.azulCRM.step_definitions;

import com.azulCRM.pages.AppreciationPage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Appreciation_step_definitions {

    AppreciationPage appreciationPage = new AppreciationPage();
//Select yearDropdown = new Select (driver.findElement(By.xpath("//select[@id='year']")));

    @Given("user navigates to appreciation")
    public void user_navigates_to_appreciation() {
        appreciationPage.moreButton.click();
        appreciationPage.dropdownElement.click();
        BrowserUtils.sleep(3);

    }

    @And("user types in an {string} message")
    public void userTypesInAnMessage(String message) {

        Driver.getDriver().switchTo().frame(0);
        BrowserUtils.sleep(3);
        appreciationPage.textBox.sendKeys(message);
        BrowserUtils.sleep(3);
        Driver.getDriver().switchTo().defaultContent();
        BrowserUtils.sleep(3);
    }


    @And("user sends the appreciation message")
    public void userSendsTheAppreciationMessage() {
        appreciationPage.recipientDropdown.click();
        appreciationPage.helpdesk22Dropdown.click();


        //yearDropdown.selectByVisibleText("1933");
        appreciationPage.sendButton.click();
    }

    @Then("verifies if message is displayed")
    public void verifiesIfMessageIsDisplayed() {

WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
WebElement sentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='appreciation']")));
Assert.assertTrue(sentMessage.isDisplayed());

    }
}

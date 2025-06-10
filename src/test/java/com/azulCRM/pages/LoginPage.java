package com.azulCRM.pages;


import com.azulCRM.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "USER_LOGIN")
    public WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(xpath = "//input[@class='login-btn']")
    public WebElement submit;

    public void login(String userType) {
        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty("password");
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        submit.click();
    }
}
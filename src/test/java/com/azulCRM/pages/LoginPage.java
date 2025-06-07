package com.azulCRM.pages;


import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(name = "USER_LOGIN")
    public WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(xpath = "//input[@class='login-btn']")
    public WebElement submit;

    public void login(String userType) {
        String username = ConfigurationReader.getProperty(userType + "_username");
        String user_password = ConfigurationReader.getProperty("password");
        userName.sendKeys(username);
        password.sendKeys(user_password);
        submit.click();
    }
}
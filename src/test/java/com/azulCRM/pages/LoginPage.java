package com.azulCRM.pages;


import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
public LoginPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}

    @FindBy(name = "USER_LOGIN")
    private WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(xpath = "//input[@class='login-btn']")
    private WebElement submit;

    public void login(String userType) {
        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty("password");
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        submit.click();
    }
}
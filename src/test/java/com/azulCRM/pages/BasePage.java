package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //TOP HEADER HORIZONTAL ELEMENTS
    @FindBy(id = "sitemap-menu")
    public WebElement siteMapMenu;

    @FindBy(xpath = "//a[@id='logo_24_a']")
    public WebElement crm24Logo;

    @FindBy(xpath = "//input[@id='search-textbox-input']")
    public WebElement topSearchBar;

    @FindBy(xpath = "//span[@id='timeman-block']")
    public WebElement clockInBlock;

    @FindBy(xpath = "//div[@id='user-block']")
    public WebElement userBlock;

    @FindBy(xpath = "//span[.='My Profile']")
    public WebElement myProfile;

    @FindBy(xpath = "//div[@id='bx-help-block']")
    public WebElement helpBlock;

    //LEFT SIDE COLUMN PAGE TABS
    @FindBy(xpath = "//a[@title='Activity Stream']")
    public WebElement activityStreamTab;

    @FindBy(xpath = "//a[@title='Tasks']")
    public WebElement tasksTab
            ;
    @FindBy(xpath = "//a[@title='Chat and Calls']")
    public WebElement chatAndCallsTab;

    @FindBy(xpath = "//a[@title='Workgroups']")
    public WebElement workgroupsTab;

    @FindBy(xpath = "//a[@title='Drive']")
    public WebElement driveTab;

    @FindBy(xpath = "//a[@title='Calendar']")
    public WebElement calendarTab;

    @FindBy(xpath = "//a[@title='Mail']")
    public WebElement mailTab;

    @FindBy(xpath = "//a[@title='Contact Center']")
    public WebElement contactCenterTab;

    @FindBy(xpath = "//a[@title='Time and Reports']")
    public WebElement timeAndReportsTab;

    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeesTab;

    @FindBy(xpath = "//a[@title='Services']")
    public WebElement servicesTab;

    @FindBy(xpath = "//a[@title='Company']")
    public WebElement companyTab;

    //"MORE" TAB - USE IT TO GET HIDDEN TABS UNDER THIS BUTTON
    //Use "applications" or "workflows" as a tagName argument
    public WebElement getHiddenFromMore(String tabName){
        Driver.getDriver()
                .findElement(By.id("left-menu-more-btn")).click();

        WebElement applications = Driver.getDriver()
                .findElement(By.xpath("//a[@title='Applications']"));
        WebElement workflows = Driver.getDriver()
                .findElement(By.xpath("//a[@title='Applications']"));

        if(tabName.equalsIgnoreCase("applications")){
            return applications;
        } else {
            return workflows;
        }
    }

    @FindBy(xpath = "//span[@id='left-menu-settings']")
    public WebElement configureMenu;

    //RIGHT SIDE COLUMN:
    @FindBy(className = "bx-im-informer bx-im-border-b")
    public WebElement notificationSign;

    @FindBy(xpath = "//div[@id='bx-im-bar-search']")
    public WebElement searchSign;
}
